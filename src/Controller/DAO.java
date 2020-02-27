/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DAO {
    public static Connection con;

    public DAO() {
    }
    public static void getInstance()
    {
        if(con==null)
        {
            String dburl = "jdbc:mysql://localhost:3306/Insurance?useSSL=false";
            String dbDriver = "com.mysql.jdbc.Driver";
            try {
                Class.forName(dbDriver);
                con = DriverManager.getConnection(dburl, "root", "12345678");
                System.out.println("thanh cong");
            } catch (Exception e) {
                e.printStackTrace();
                //System.out.println("KHONG KET noi duoc");
            }
        }
    }
    public static void main(String[] args) {
        getInstance();
    }
}
