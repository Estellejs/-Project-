package net.jdbc;

import net.beans.image;
import org.apache.commons.lang.ObjectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.commons.lang.ObjectUtils.*;

public class imageTools {

    //根据返回的rs获取image的基础数据
    public static image getImageBasicInformation(ResultSet rs) throws SQLException {
        System.out.println(" service start select photo 选择第几张图片");
        int ImageID=rs.getInt("ImageID");
        int UID=rs.getInt("UID");
        String PATH=rs.getString("PATH");
        // String author=rs.getString();
        String title=rs.getString("Title");
        String topic=rs.getString("Topic");
        String description=rs.getString("Description");
        int hot=rs.getInt("Hot");
        // String country;//单独请求
        String Country_RegionCodeISO=rs.getString("Country_RegionCodeISO");
        // String city;//单独请求
        int CityCode=rs.getInt("CityCode");
        System.out.println(" service start select photo 选择第1张图片");
        String publishTime=rs.getString("PublishTime");
        System.out.println(" service start select photo 选择第#张图片");



        System.out.println(" service start select photo 选择第2张图片");
        image image=new image(ImageID,UID,PATH,title,topic,description,hot,publishTime,Country_RegionCodeISO,CityCode);

        System.out.println(" service start select photo 选择第3张图片");
        String AuthorSQL = "SELECT UserName FROM traveluser WHERE UID=" + image.getUID();
        String countrySQL = "SELECT Country_RegionName FROM geocountries_regions WHERE ISO='" + image.getCountry_RegionCodeISO() + "'";
        String citySQL = "SELECT AsciiName FROM geocities WHERE GeoNameID=" + image.getCityCode();
        String city = imageTools.getOtherData(citySQL, "AsciiName");
        String author = imageTools.getOtherData(AuthorSQL, "UserName");
        String county = imageTools.getOtherData(countrySQL, "Country_RegionName");
        image.setAuthor(author);
        image.setCountry(county);
        image.setCity(city);
        return image;
    }
//根据SQL和条件，获取图片其他信息，city country author
    public static String getOtherData(String SQL,String name) throws SQLException{

        System.out.println(" 开始获取其他数据");
        String data=null;
         Connection conn = null;
         PreparedStatement ps=null;
         ResultSet rs=null;
        try{
            conn= jdbcUtils.getConnection();
            ps=conn.prepareStatement(SQL);
            rs=ps.executeQuery();
            if (rs.next()){
                data=rs.getString(name);
                System.out.println(" service start select photo 其他数据获取成功  "+name+"   "+data);
            }else{
                System.out.println(name+ "获取失败");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtils.closeCPSR(conn,ps,rs);
        }
        return data;
    }

    //根据SQL获取image List
    public static List<image> getImageList(String SQL) throws SQLException {
        List<image> imageList=new ArrayList<image>();
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            conn= jdbcUtils.getConnection();
            ps=conn.prepareStatement(SQL);
            rs=ps.executeQuery();
            System.out.println(" service start select photo 数据库连接");
            while (rs.next()){
                image image= imageTools.getImageBasicInformation(rs);
                imageList.add(image);
                System.out.println("image ID  "+  image.getImageID());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtils.closeCPSR(conn,ps,rs);
        }


        return imageList;
    }


}
