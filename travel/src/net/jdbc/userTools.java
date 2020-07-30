package net.jdbc;

import net.beans.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userTools {
    //根据    SQL获取user list
    public static List<user> usersList(String SQL) throws SQLException {
        String data=null;
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ps = conn.prepareStatement(SQL);
        user user=new user();
        rs = ps.executeQuery();
        List<user> userList=new ArrayList<user>();
        if(rs.next()) {
            user=userInformation(rs);
            userList.add(user);
        }
        return userList;
    }

    public static user userInformation (ResultSet rs) throws SQLException {
        user user=new user();
        user.setUID(rs.getInt("UID"));
        user.setEmail(rs.getString("Email"));
        user.setUserName(rs.getString("UserName"));
        user.setPass(rs.getString("Pass"));
        user.setState(rs.getByte("State"));
        user.setDateJoined(rs.getDate("DateJoined"));
        user.setDateLastModified(rs.getDate("DateLastModified"));

        return user;

    }



}
