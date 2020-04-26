package com.utils;

import java.sql.*;

public class DBconnect {
    static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT";
    static String user = "root";
    static String pass = "123456";
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static Statement st = null;

    public static void init() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int addUpdateDelete(String sql){
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            boolean flag = ps.execute();
            if(flag==false){
                i++;
            }
        } catch (SQLException e) {
            System.out.println("数据库增删改异常");
            e.printStackTrace();
        }
        return i;
    }

    public static ResultSet selectSql(String sql){
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭异常");
            e.printStackTrace();
        }
    }
}
