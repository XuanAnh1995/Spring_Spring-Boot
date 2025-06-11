package com.luuviet.superapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=HSF302;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "123456789";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connect to DB successfully");

            // Tạo class  PREPAREDSTATEMENT dùng quản lý câu lệnh SQL
            PreparedStatement stm = conn.prepareStatement("select * from Subject");
            ResultSet rs = stm.executeQuery();  // Thực thi câu SQL và trả về ResultSet
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                Integer credits = rs.getInt("Credits");
                Integer studyHours = rs.getInt("StudyHours");
                System.out.printf("|%5s|%-40s|%-80s|%4s|%4s| \n", code, name, description, credits, studyHours);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}