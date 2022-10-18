package com.main2.idea;

import java.sql.*; // импортируем все что связано с SQL
import java.util.Arrays; // util специалный класс состоящий из структуры коллекций, коллекций
import java.util.Scanner;


public class sem1Medium
{
    public static void main (String[] args) throws SQLException // чтобы выводились ошибки, если они допущены
    {
        Scanner scan = new Scanner(System.in);
        // создаем консольное меню
        int x = 0;
        String s = "";
        System.out.println("Введите название таблицы: ");
        String tablename = scan.nextLine();

        while (!"4".equals(s))
        {
            System.out.println("1. Выводим все таблицы из базы данных. ");
            System.out.println("2. Создать таблицу в базе данных. ");
            System.out.println("3. Сложение чисел, результат сохранить в MySQL с последующим выводом в консоль. ");
            System.out.println("4. Вычитание чисел, результат сохранить в MySQL с последующим выводом в консоль. ");
            System.out.println("5. Умножение чисел, результат сохранить в MySQL с последующим выводом в консоль.");
            System.out.println("5. Деление чисел, результат сохранить в MySQL с последующим выводом в консоль.");
            System.out.println("5. Деление чисел по модулю (остаток), результат сохранить в MySQL с последующим" +
                    " выводом в консоль.");
            System.out.println("5. Возведение числа в модуль, результат сохранить в MySQL с последующим выводом " +
                    "в консоль. ");
            System.out.println("5. Возведение числа в степень, результат сохранить в MySQL с последующим выводом" +
                    " в консоль. ");
            s = scan.next();

            try{
                x = Integer.parseInt(s);
            }catch(NumberFormatException e){
                System.out.println("Неверный формат ввода. ");
            }

            switch (x)
            {
                case 1 ->
                {  // посредник соеди нитель между базой данных и нами
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl = "jdbc:mysql://localhost:3306/lesson1";
                    Connection con = DriverManager.getConnection(mySQLurl, "root", "7043931Nik");
                    System.out.println("Успешное подключение к базе данных. ");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("Show Tables");
                    System.out.println("Таблицы из текущей базы данных. ");
                    while (rs.next())
                    {
                        System.out.print(rs.getString(1)); // print нужен чтобы выводились не через строку,
                        // так как ей присуща \n
                        System.out.println();
                    }
                }
                case 2 ->
                {
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl1 = "jdbc:mysql://localhost:3306/lesson1";
                    Connection con1 = DriverManager.getConnection(mySQLurl1, "root", "7043931Nik");
                    System.out.println("Успешное подключение к базе данных. ");
                    Statement stmt1 = con1.createStatement();
                    String query = "CREATE TABLE IF NOT EXISTS " +  tablename + " (ID int, test varchar(255))";
                    stmt1.executeUpdate(query);
                    ResultSet rs1 = stmt1.executeQuery("Show Tables");
                    System.out.println("Таблицы из базы данных: ");
                    while (rs1.next())
                    {
                        System.out.print(rs1.getString(1));
                        System.out.println();
                    }
                }
                case 3 ->
                {
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl2 = "jdbc:mysql://localhost:3306/lesson1";
                    Connection con2 = DriverManager.getConnection(mySQLurl2, "root", "7043931Nik");
                    System.out.println("Успешное подключение к базе данных. ");

                    System.out.println("Введите ID #1: ");
                    int ID = scan.nextInt();
                    System.out.println("Введите ID #2: ");
                    int ID1 = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Введите строку #1: ");
                    String test = scan.nextLine();
                    System.out.println("Введите строку #2: ");
                    String test1 = scan.nextLine();

                    String query2 = "INSERT INTO " + tablename + " (ID, test) VALUES (?, ?), (?,?)";
                    PreparedStatement stmt3 = con2.prepareStatement(query2);
                    stmt3.setInt(1, ID);
                    stmt3.setString(2, test);
                    stmt3.setInt(3, ID1);
                    stmt3.setString(4, test1);
                    stmt3.executeUpdate();
                    System.out.println("Данные успешно внесены в SQL!!! ");

                    // get и set безопасное извечение или запись данных

                    ResultSet rs2 = stmt3.executeQuery("SELECT * from " + tablename + "");
                    System.out.println("Введенные данные: ");
                    while (rs2.next())
                    {
                        System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
                        System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
                        System.out.println();
                    }
                }
            }
        }
        System.out.println("Выход из программы (успешно)");
    }
}

