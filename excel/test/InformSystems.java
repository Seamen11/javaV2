package com.excel.test;

import java.sql.*;
import java.util.Scanner;

public class InformSystems
{
    protected static Scanner scan = new Scanner(System.in);
    protected static String tablename = scan.nextLine();
    protected static String tablename1 = scan.nextLine();

    protected static String myURL = "jdbc:mysql://localhost/test";

    protected static Connection con;

    static
    {
        try
        {
            con = DriverManager.getConnection(myURL, "root", "7043931Nik");
        }catch (SQLException e )
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException
    {
        int x = 0;
        String s = "";
        while (!"3".equals(s))
        {
            System.out.println("""
                    Добро пожаловтаь в наше кафе. Вы администратор или клиент?
                    1. Администратор
                    2. Клиент
                    3. Выход""");
            s = scan.next();
            try
            {
                x = Integer.parseInt(s);
            }catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода");
            }switch (x){
                case 1 -> Administrator.main();
                case 2 -> Client.main();
            }
        }
        System.out.println("До свидания!!! :)");
    }
}
