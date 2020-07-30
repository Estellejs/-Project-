package net.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.beans.user;
import net.jdbc.jdbcUtils;
import net.jdbc.userTools;


public class userDaoImpl implements IUserDAO{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement state;


    @Override
    public user selectUserLogin(String name, String pass) throws SQLException {
        user user = null;
        try {
            conn = jdbcUtils.getConnection();

            String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
            //Email
            String SQL="";
            if (name.matches(em)){
                SQL="select * from traveluser where Email=? and Pass=?";
            }else {
                SQL="select * from traveluser where UserName=? and Pass=?";
            }
            ps = conn.prepareStatement(SQL);
            ps.setString(1, name);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()) {
                user = new user();
                user=userTools.userInformation(rs);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
            	jdbcUtils.closeCPSR(conn, ps, rs);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public user getUserInformationByID(int UID) throws SQLException {
        user user=new user();
        try {
            conn = jdbcUtils.getConnection();
            String sqlSelectName="SELECT * FROM traveluser WHERE UID="+UID;
            state=conn.createStatement();
            rs= state.executeQuery(sqlSelectName);
            if (rs.next()){
                user=userTools.userInformation(rs);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.closeCSR(conn,state,rs);
        }
        return user;
    }

    @Override
    public int insertUser(user user) throws SQLException {
        int id = 0;

        try {
            //判断用户名是否重复
            conn = jdbcUtils.getConnection();
        	String sqlSelectName="SELECT COUNT(*) FROM traveluser WHERE UserName='"+user.getUserName()+"'";
        	state=conn.createStatement();
        	rs= state.executeQuery(sqlSelectName);
        	if(rs.next()) {
                int count=rs.getInt(1);
                System.out.println("count   "+count);
                if (count>0){
                    jdbcUtils.closeCSR(conn,state,rs);
                    return -1;
                }else{
                    jdbcUtils.closeCSR(conn,state,rs);
                    conn = jdbcUtils.getConnection();
                    String sqlSelectEmail="SELECT COUNT(*) FROM traveluser WHERE Email='"+user.getEmail()+"'";
                    state=conn.createStatement();
                    rs= state.executeQuery(sqlSelectEmail);
                    if(rs.next()) {
                        count=rs.getInt(1);
                        System.out.println("countEmail   "+count);
                        if (count>0){
                            jdbcUtils.closeCSR(conn,state,rs);
                            return -2;
                        }else{
                            jdbcUtils.closeCSR(conn, state, rs);
                            conn = jdbcUtils.getConnection();
                            java.sql.Date time= new java.sql.Date(new java.util.Date().getTime());
                            String sql = "insert into traveluser(Email,UserName,Pass,DateJoined) values(?,?,?,?)";
                            ps = conn.prepareStatement(sql);
                            ps.setString(1, user.getEmail());
                            ps.setString(2, user.getUserName());
                            ps.setString(3, user.getPass());
                            ps.setDate(4,time);
                            ps.executeUpdate();
                            sql = "select last_insert_id() newId";
                            ps = conn.prepareStatement(sql);
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                id = rs.getInt("newId");
                            }
                        }
                    }
                }
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            	jdbcUtils.closeCPSR(conn, ps, rs);
        }
        return id;


    }

    @Override
    public List<user> getMyFriend(int UID) throws SQLException {
        List<user> userList=new ArrayList<user>();
        List<Integer> FIDList=new ArrayList<Integer>();
        String SQLFID="SELECT * FROM travelfriend WHERE UID="+UID;
        try {
            conn = jdbcUtils.getConnection();
            ps=conn.prepareStatement(SQLFID);
            rs= ps.executeQuery();
            System.out.println(" service getFriend select photo 数据库连接");
            while (rs.next()){
                int FID=rs.getInt("FID");
                System.out.println("FID  "+FID);
                FIDList.add(FID);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.closeCPSR(conn,ps,rs);
        }

        //获取user信息
        for (int i=0;i<FIDList.size();i++){
            String SQL="SELECT * FROM traveluser WHERE UID="+FIDList.get(i);
            user user=new user();
            try{
                conn=jdbcUtils.getConnection();
                state=conn.createStatement();
                rs=state.executeQuery(SQL);
                if (rs.next()){
                    user=userTools.userInformation(rs);
                    userList.add(user);
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                jdbcUtils.closeCSR(conn,state,rs);
            }

        }
        return userList;
    }


}