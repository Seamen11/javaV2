package com.main3.idea;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class sem2Medium
{
    public static String[] BazaZad()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую строку до 50 символов");
        String s1 = in.nextLine();
        while (s1.length() > 50)
        {
            System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
            s1 = in.nextLine();
        }
        System.out.println("Введите вторую строку до 50 символов");
        String s2 = in.nextLine();
        while (s2.length() > 50)
        {
            System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
            s2 = in.nextLine();
        }

        String sum = s1 + s2;
        String[] summirize = {s1, s2, sum};

        System.out.println("Строка 1: " + s1 + ", Строка 2: " + s2 + "\nРазмер первой строки: " + s1.length() +
                ",  Размер второй строки: " + s2.length() + "\nОбъединение двух строк: " + sum +
                "\nСравнения двух строк (одинаковы ли они или нет?): " + s1.equals(s2));

        return summirize;
    }
    public static void insertSQL(String tablename, String ID, String result, String ID1, String result1) throws SQLException
    {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mySQLurl2 = "jdbc:mysql://localhost:3306/lesson1";
        Connection con2 = DriverManager.getConnection(mySQLurl2, "root", "7043931Nik");
        System.out.println("Успешное подключение к базе данных. ");

        String query2 = "INSERT INTO " + tablename + "(ID, RES) VALUES (?, ?), (?, ?)";
        PreparedStatement stmt3 = con2.prepareStatement(query2);
        stmt3.setString(1, ID);
        stmt3.setString(2, result);
        stmt3.setString(3, ID1);
        stmt3.setString(4, result1);

        stmt3.executeUpdate();
        System.out.println("Данные успешно внесены в SQL!!! ");

        ResultSet rs2 = stmt3.executeQuery("SELECT * from " + tablename + "");
        System.out.println("Введенные данные: ");
        while (rs2.next())
        {
            System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
            System.out.println();
        }
    }
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";
        System.out.println("Введите название таблицы: ");
        String tablename = scan.nextLine();

        while (!"7".equals(s)) {
            System.out.println("1. Выводим все таблицы из базы данных. ");
            System.out.println("2. Создать таблицу в базе данных. ");
            System.out.println("3. Ввести две строки с клавиатуры, результат сохранить в MySQL с последующим выводом в консоль. ");
            System.out.println("4. Подсчитать размер ранее введенных строк, результат сохранить в MySQL с последующим" +
                    " выводом в консоль. ");
            System.out.println("5. Объединить две строки в единое целое, результат сохранить в MySQL с последующим" +
                    " выводом в консоль. ");
            System.out.println("6. Сравнить две ранее введенные строки, результат сохранить в MySQL с" +
                    " последующим выводом в консоль.");
            System.out.println("7. Выход из программы. ");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода. ");
            }

            switch (x) {
                case 1 -> // Вывести все таблицы из бд
                {  // посредник соеди нитель между базой данных и нами
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl = "jdbc:mysql://localhost:3306/lesson1";
                    Connection con = DriverManager.getConnection(mySQLurl, "root", "7043931Nik");
                    System.out.println("Успешное подключение к базе данных. ");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("Show Tables");
                    System.out.println("Таблицы из текущей базы данных. ");
                    while (rs.next()) {
                        System.out.print(rs.getString(1)); // print нужен чтобы выводились не через строку,
                        // так как ей присуща \n
                        System.out.println();
                    }
                }
                case 2 -> // создать таблицу
                {
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl1 = "jdbc:mysql://localhost:3306/lesson1";
                    Connection con1 = DriverManager.getConnection(mySQLurl1, "root", "7043931Nik");
                    System.out.println("Успешное подключение к базе данных. ");
                    Statement stmt1 = con1.createStatement();
                    String query = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID varchar(255), RES varchar(255))";
                    stmt1.executeUpdate(query);
                    ResultSet rs1 = stmt1.executeQuery("Show Tables");
                    System.out.println("Таблицы из базы данных: ");
                    while (rs1.next()) {
                        System.out.print(rs1.getString(1));
                        System.out.println();
                    }
                }case 3 -> { // сохранение двух строк
                    String[] data = BazaZad();
                    String s1 = data[0];
                    String s2 = data[1];
                    String ID = "ПерваяCтрока";
                    String ID1 = "ВтораяCтрока";
                    insertSQL(tablename, ID, s1, ID1, s2);
                }case 4 ->{ // сохранение размера
                    String[] data = BazaZad();
                    String len1 = Arrays.toString(new int[]{data[0].length()});
                    String len2 = Arrays.toString(new int[]{data[1].length()});
                    String ID = "Длина первой строки ";
                    String ID1 = "Длина второй строки ";
                    insertSQL(tablename, ID, len1, ID1, len2);
                }case 5 ->{
                    String[] data = BazaZad();
                    String ID = "Данные строки: ";
                    String ID1 = "Объединенная строка: ";
                    String view = data[0] + "   " + data[1];
                    String sum1 = data[2];
                    insertSQL(tablename, ID, view, ID1, sum1);
                }case 6 ->{
                    String[] data = BazaZad();
                    String ID = "Является ли одна строка концом другой: ";
                    String ID1 = "Одинаковые ли строки: ";
                    String s1 = data[0];
                    String s2 = data[1];
                    String ss1 = "false";
                    String ss2 = "false";
                    if (s1.endsWith(s2)){
                        ss1 = "true";
                    }
                    if (s1.equals(s2)){
                        ss2 = "true";
                    }
                    insertSQL(tablename, ID, ss1, ID1, ss2);
                }
            }
        }
        System.out.println("Выход из программы (успешно)");
    }
}
