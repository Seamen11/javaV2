package com.main4.idea;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class sem3Medium {
    public static boolean ProverkaNaChetnost(int arguement)
    {
        return arguement % 2 == 0;
    }

    public static boolean ProverkaNaInt(String arguement)
    {
        try
        {
            int Value = Integer.parseInt(arguement);
            return true;
        } catch (NumberFormatException e)
        {
            System.out.println("Введенное значение невозможно преобразовать в целочисленное, повторите ввод: ");
        }
        return false;
    }

    public static void insertSQL(String tablename, String ID, int cyfra, String haracter) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mySQLurl2 = "jdbc:mysql://localhost:3306/lesson1";
        Connection con2 = DriverManager.getConnection(mySQLurl2, "root", "7043931Nik");
        System.out.println("Успешное подключение к базе данных. ");

        String query2 = "INSERT INTO " + tablename + "(ID, CYFRA, CHARACT) VALUES (?, ?, ?)";
        PreparedStatement stmt3 = con2.prepareStatement(query2);
        stmt3.setString(1, ID);
        stmt3.setInt(2, cyfra);
        stmt3.setString(3, haracter);


        stmt3.executeUpdate();
        System.out.println("Данные успешно внесены в SQL!!! ");

        ResultSet rs2 = stmt3.executeQuery("SELECT * from " + tablename + "");
        System.out.println("Введенные данные: ");
        while (rs2.next()) {
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

        while (!"4".equals(s)) {
            System.out.println("1. Выводим все таблицы из базы данных. ");
            System.out.println("2. Создать таблицу в базе данных. ");
            System.out.println("3. Выполнение задачи базового варианта, результат сохранить в MySQL с последующим выводом в консоль ");
            System.out.println("4. Выход из программы. ");
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
                    String query = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID varchar(255), CYFRA int, CHARACT varchar(255))";
                    stmt1.executeUpdate(query);
                    ResultSet rs1 = stmt1.executeQuery("Show Tables");
                    System.out.println("Таблицы из базы данных: ");
                    while (rs1.next()) {
                        System.out.print(rs1.getString(1));
                        System.out.println();
                    }
                }case 3 -> {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Введите количество чисел которые хотите задатть: ");
                    String kol = in.next();
                    while (!ProverkaNaInt(kol)) {
                        kol = in.next();
                    }

                    int koll = Integer.parseInt(kol);
                    int[] ArrayOfInts = new int[koll];
                    int[] ArrayOfChet = new int[koll];

                    for (int i = 0; i < koll; i++) {
                        System.out.println("Введите число под номером " + i);
                        String value = in.next();
                        while (!ProverkaNaInt(value)) {
                            value = in.next();
                        }
                        int valueU = Integer.parseInt(value);
                        if (ProverkaNaChetnost(valueU)) {
                            ArrayOfChet[i] = valueU;
                        }
                        ArrayOfInts[i] = valueU;
                    }

                    for (int i = 0; i < koll; i++)
                    {
                        int flag = 0;
                        for (int k : ArrayOfChet) {
                            if (ArrayOfInts[i] == k) {
                                flag++;
                                insertSQL(tablename, "Четное", ArrayOfInts[i], "true");
                            }
                        }
                        if (flag == 0)
                        {
                            insertSQL(tablename,"Четное",  ArrayOfInts[i], "false");
                        }
                    }
                }
            }
        }
        System.out.println("Выход из программы (успешно)");
    }
}