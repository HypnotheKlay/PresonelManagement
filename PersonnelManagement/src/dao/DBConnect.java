/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DBConnect {

    static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/company";
            String user="root";
            String password="root";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动器加载出错");
        } catch (SQLException e) {
        	System.out.println("连接出错");
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("在关闭游标的时候出错了" + e.getMessage());
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                System.out.println("在关闭操作对象的时候出错了" + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("在关闭连接对象的时候出错了" + e.getMessage());
            }
        }
    }
}
