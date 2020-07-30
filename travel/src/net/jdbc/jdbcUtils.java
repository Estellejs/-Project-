package net.jdbc;


import java.sql.*;
import java.util.Properties;

//import org.junit.Test;

public class jdbcUtils {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/new_travels?serverTimezone=GMT%2B8"; 
        Properties info=new Properties();
        info.put("user","root");
        info.put("password","123456");
        Driver driver=new com.mysql.cj.jdbc.Driver();
        Connection conn = null;
        conn = driver.connect(url,info);
        return conn;
    }

    public static void closeCSR(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed())  {
            try{
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (stmt != null && !stmt.isClosed())  {
            try{
                stmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null && !conn.isClosed())  {
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void closeCPSR(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed())  {
            try{
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (ps != null && !ps.isClosed())  {
            try{
                ps.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null && !conn.isClosed())  {
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}