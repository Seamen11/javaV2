package com.main5.idea;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class sem4Medium {

    public static boolean ProverkaNaInt(String arguement)
    {
        try
        {
            int Value = Integer.parseInt(arguement);
            return false;
        } catch (NumberFormatException e)
        {
            System.out.println("Введенное значение невозможно преобразовать в целочисленное, повторите ввод: ");
        }
        return true;
    }

    public static void insertSQL(String tablename, String ID, String stroka) throws SQLException {
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
            System.out.println("3. Возвращение подстроки по индексам, результат сохранить в MySQL с последующим" +
                    " выводом в консоль. ");
            System.out.println("4. Перевод строк в верхний и нижний регистры, результат сохранить в MySQL с последующим" +
                    " выводом в консоль. ");
            System.out.println("5. Поиск подстроки и определение окончания подстроки, результат сохранить в MySQL" +
                    " с последующим выводом в консоль. ");
            System.out.println("6. Выход из программы. ");
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
                }case 3 ->   // срез
                {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Введите первую строку до 50 символов");
                    String s1 = in.nextLine();
                    int NachaloSreza = 0;
                    int KonetsSreza = 0;

                    while (s1.length() > 50) {
                        System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
                        s1 = in.nextLine();
                    }
                    System.out.println("Введите вторую строку до 50 символов");
                    String s2 = in.nextLine();
                    while (s2.length() > 50) {
                        System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
                        s2 = in.nextLine();
                    }

                    System.out.println("Введите срез (начало), по умолчанию 0: ");
                    String kol = in.next();
                    if (kol.length() != 0)
                    {
                        while(ProverkaNaInt(kol))
                        {
                            kol = in.next();
                        }
                    }

                    System.out.println("Введите срез (конец), по умолчанию 0: ");
                    String kol1 = in.next();
                    if (kol1.length() != 0)
                    {
                        while(ProverkaNaInt(kol1))
                        {
                            kol1 = in.next();
                        }
                    }
                    NachaloSreza = Integer.parseInt(kol);
                    KonetsSreza = Integer.parseInt(kol1);

                    String ss1 = s1.substring(NachaloSreza, KonetsSreza);
                    String ss2 = s2.substring(NachaloSreza, KonetsSreza);

                    insertSQL(tablename, "Срез1", ss1);
                    insertSQL(tablename, "Срез2", ss2);


                }case 4 ->{  // регистр меняем
                    Scanner in = new Scanner(System.in);
                    System.out.println("Введите первую строку до 50 символов");
                    String s1 = in.nextLine();
                    int NachaloSreza = 0;
                    int KonetsSreza = 0;

                    while (s1.length() > 50) {
                        System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
                        s1 = in.nextLine();
                    }
                    System.out.println("Введите вторую строку до 50 символов");
                    String s2 = in.nextLine();
                    while (s2.length() > 50) {
                        System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
                        s2 = in.nextLine();
                    }
                    String ss1 = s1.toUpperCase();
                    String ss11 = s1.toLowerCase();
                    String ss2 = s2.toUpperCase();
                    String ss22 = s2.toLowerCase();

                    insertSQL(tablename, "Верхний1", ss1);
                    insertSQL(tablename, "Нижний1", ss11);
                    insertSQL(tablename, "Верхний2", ss2);
                    insertSQL(tablename, "Нижний", ss22);

                }case 5 ->{ // поиск подстроки и определение конца строки
                    Scanner in = new Scanner(System.in);
                    System.out.println("Введите первую строку до 50 символов");
                    String s1 = in.nextLine();

                    while (s1.length() > 50) {
                        System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
                        s1 = in.nextLine();
                    }
                    System.out.println("Введите вторую строку до 50 символов");
                    String s2 = in.nextLine();
                    while (s2.length() > 50) {
                        System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
                        s2 = in.nextLine();
                    }

                    System.out.println("Введите Подстроку, опредеелим кончается ли этой подстрокой наши строки: ");
                    String podstr = in.next();

                    while (podstr.length() > 50)
                    {
                        System.out.println("Подстрока не должна превышать 50 символов, повторите ввод: ");
                        podstr = in.nextLine();
                    }
                    String opred1 = "false";
                    String opred2 = "false";

                    if (s1.endsWith(podstr)){
                        opred1 = "true";
                    }if (s2.endsWith(podstr)){
                        opred2 = "true";
                    }
                    insertSQL(tablename, "ЯвляетсяЛи1", opred1);
                    insertSQL(tablename, "ЯвляетсяЛи2", opred2);
                }
            }
        }System.out.println("Выход из программы (успешно)");
    }
}

