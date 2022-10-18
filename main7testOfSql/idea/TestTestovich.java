package com.main7testOfSql.idea;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class TestTestovich
{
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "7043931Nik");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");
            System.out.println(rs);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
