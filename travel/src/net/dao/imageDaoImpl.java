package net.dao;

import net.beans.image;
import net.jdbc.imageTools;
import net.jdbc.jdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class imageDaoImpl implements IImageDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override   //根据image id 获取信息
    public image imageDetails(int imageID) throws SQLException {

        System.out.println(" service imageDetails select photo");
        String SQL = "SELECT * FROM travelimage WHERE ImageID=" + imageID;
        image image = null;
        try {
            conn = jdbcUtils.getConnection();
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                image = imageTools.getImageBasicInformation(rs);
                System.out.println(" service imageDetails select photo 数据获取成功  " + image.getPATH());
            }
            System.out.println(" service start select photo 获取其他数据");
            return image;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeCPSR(conn, ps, rs);
        }

        return null;
    }

    @Override  //获取三张最新或最热图片信息
    public List<image> selectHotPhotos(String method) throws SQLException {
        System.out.println(" service start select photo");
        String SQL;
        if (method.equals("hot")) {
            System.out.println(" service start select HOT photo");
            SQL = "SELECT * FROM travelimage ORDER BY Hot DESC limit 3";
        } else if (method.equals("new")) {
            System.out.println(" service start select new photo");
            SQL = "SELECT * FROM travelimage ORDER BY PublishTime DESC limit 3";
        } else {
            return null;
        }
        List<image> imageList = new ArrayList<image>();
        imageList = imageTools.getImageList(SQL);
        return imageList;
    }

    @Override
    public boolean isImageCollected(int ImageID, int UID) throws SQLException {
        String SQL="SELECT * FROM travelimagefavor WHERE UID=? AND ImageID=?";
        try{
            conn=jdbcUtils.getConnection();
            ps=conn.prepareStatement(SQL);
            ps.setInt(1,UID);
            ps.setInt(2,ImageID);
            rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt("FavorID");
                System.out.println("该图片已收藏   "+id);
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeCPSR(conn, ps, rs);
        }
        System.out.println("该图片未收藏");
        return false;
    }

    @Override
    public int cancelOrCollectImage(int ImageID, int UID) throws SQLException {
        boolean isCollected=isImageCollected(ImageID,UID);
        String SQL="";
        int id=0;
        if (isCollected){//取消收藏
            SQL="DELETE FROM travelimagefavor WHERE ImageID=? AND UID=?";
        }else {
            SQL="INSERT INTO travelimagefavor(ImageID,UID) VALUES(?,?)";
        }
        try {
            conn=jdbcUtils.getConnection();
            ps=conn.prepareStatement(SQL);
            ps.setInt(1,ImageID);
            ps.setInt(2,UID);
            ps.executeUpdate();
            if (!isCollected){
                String sql="select last_insert_id() newID";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                if (rs.next()){
                    id=rs.getInt("FavorID");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeCPSR(conn, ps, rs);
        }
        return id;
    }

    @Override
    public int cancelCollection(int ImageID, int UID) throws SQLException {
        String SQL="DELETE FROM travelimagefavor WHERE ImageID=? AND UID=?";
        try {
            conn=jdbcUtils.getConnection();
            ps=conn.prepareStatement(SQL);
            ps.setInt(1,ImageID);
            ps.setInt(2,UID);
            ps.executeUpdate();
            return 1;
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeCPSR(conn, ps, rs);
        }

        return 0;
    }

    @Override
    public int deleteImage(int ImageID) throws SQLException {
        String SQL="DELETE FROM travelimage WHERE ImageID="+ImageID;
        try {
            conn=jdbcUtils.getConnection();
            ps=conn.prepareStatement(SQL);
            ps.executeUpdate();
            return 1;
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeCPSR(conn, ps, rs);
        }
        return 0;

    }


    @Override   //获取我的图片
    public List<image> getMyImageList(int UID) throws SQLException {
        String SQL = "SELECT * FROM travelimage WHERE UID=" + UID;
        List<image> imageList = new ArrayList<image>();
        imageList = imageTools.getImageList(SQL);
        return imageList;
    }

    @Override //获取我的收藏
    public List<image> getMyCollection(int UID) throws SQLException {
        System.out.println("开始查找collection");
        String SQL1 = "SELECT ImageID FROM travelimagefavor WHERE UID=" + UID;
        System.out.println("UID    "+UID);
        List<Integer> ImageIDList = new ArrayList<Integer>();
        List<image> ImageList = new ArrayList<image>();
        //获取图片的uid
        try {
            conn = jdbcUtils.getConnection();
            ps = conn.prepareStatement(SQL1);
            rs = ps.executeQuery();
            System.out.println(" service start select photo 数据库连接");
            while (rs.next()) {
                System.out.println(" 获取图片收藏ID  " + " ImageID  ");
                int ImageID = rs.getInt("ImageID");
                ImageIDList.add(ImageID);
                System.out.println(" 获取图片收藏ID  " + ImageID + "   ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeCPSR(conn, ps, rs);
        }

        //获取图片 根据imageID获取所有数据
        for (int i = 0; i < ImageIDList.size(); i++) {
            System.out.println("获取我的收藏第 "+i+ "");
            image image=imageDetails(ImageIDList.get(i));
            ImageList.add(image);
        }
        return ImageList;
    }

}