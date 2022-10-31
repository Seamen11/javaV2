package com.main6.idea;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class sem5Medium
{

    public static StringBuffer PutTheString(int index)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ввидеите строку номер " + index + " (длина строка должна быть не менее 50 символов): ");
        String str = in.nextLine();
        while (str.length() > 50)
        {
            System.out.println("Введенная строка противоречит условию, повторите ввод: ");
            str = in.nextLine();
        }
        return new StringBuffer(str);
    }

    public static void insertSQL(String tablename, String ID, String stroka) throws SQLException
    {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mySQLurl2 = "jdbc:mysql://localhost:3306/lesson1";
        Connection con2 = DriverManager.getConnection(mySQLurl2, "root", "7043931Nik");
        System.out.println("Успешное подключение к базе данных. ");

        String query2 = "INSERT INTO " + tablename + " (ID, STROKA) VALUES (?, ?)";
        PreparedStatement stmt3 = con2.prepareStatement(query2);
        stmt3.setString(1, ID);
        stmt3.setString(2, stroka);


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

        while (!"6".equals(s)) {
            System.out.println("1. Выводим все таблицы из базы данных. ");
            System.out.println("2. Создать таблицу в базе данных. ");
            System.out.println("3. Изменить порядок символов строки на обратный, результат сохранить в MySQL с последующим выводом в" +
                    "консоль. ");
            System.out.println("4. Добавить одну строку в другую, результат сохранить в MySQL с последующим выводом в консоль. ");
            System.out.println("5. Выход из программы. ");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода. ");
            }

            switch (x) {
                case 1 ->  // Вывести все таблицы из бд
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
                case 2 -> // Возвращение подстроки по индексам, результат сохранить в MySQL с последующим выводом в консоль.
                {
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl1 = "jdbc:mysql://localhost:3306/lesson1";
                    Connection con1 = DriverManager.getConnection(mySQLurl1, "root", "7043931Nik");
                    System.out.println("Успешное подключение к базе данных. ");
                    Statement stmt1 = con1.createStatement();
                    String query = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID varchar(255),STROKA varchar(255))";
                    stmt1.executeUpdate(query);
                    ResultSet rs1 = stmt1.executeQuery("Show Tables");
                    System.out.println("Таблицы из базы данных: ");
                    while (rs1.next()) {
                        System.out.print(rs1.getString(1));
                        System.out.println();
                    }
                }case 3-> {
                    StringBuffer a = PutTheString(1);
                    StringBuffer b = PutTheString(2);

                    StringBuffer aa = a.reverse();
                    StringBuffer bb = b.reverse();

                    insertSQL(tablename, "Первая", String.valueOf(aa));
                    insertSQL(tablename, "Вторая", String.valueOf(bb));
                }case 4->{
                    StringBuffer a = PutTheString(1);
                    StringBuffer b = PutTheString(2);
                    String aa = String.valueOf(a.append(b));
                    insertSQL(tablename, "concatenacia", aa);
                }
            }
        }System.out.println("Выход из программы (успешно)");
    }
}
