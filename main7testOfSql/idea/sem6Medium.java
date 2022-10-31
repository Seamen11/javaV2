package com.main7testOfSql.idea;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class sem6Medium
{
    public static class ArrayPi1
    {
        static int index = 4;
        public static int[][] CreateTable()
        {
            Scanner in = new Scanner(System.in);
            int[][] array = new int[index][index];
            for (int i = 0; i < index; i++)
            {
                for (int j = 0; j < index; j++)
                {
                    System.out.println("Введите элемент массива с индексом столбца: " + i + " индексом строки: " + j);
                    array[i][j] = in.nextInt();
                }
            }
            return array;
        }
        int[][] arr = CreateTable();
    }

    public static class Matrix extends ArrayPi1
    {
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

        public static int[][] Creation()
        {
            int[][] array = CreateTable();
            //String aa = Arrays.deepToString(array);
            System.out.println(Arrays.deepToString(array));
            int[][] array1 = CreateTable();
            System.out.println(Arrays.deepToString(array1));
            int[][] array2 = new int[index][index];

            for (int i = 0; i < index; i++)
            {
                for (int j = 0; j < index; j++)
                {
                    for (int u = 0; u < index; u++)
                    {
                        array2[i][u] += array[i][j] * array1[j][u];
                    }
                }
            }
            System.out.println(Arrays.deepToString(array2));

            System.out.println("Отсортированный массив: " + Arrays.stream(array2).sorted());
            return array2;
        }

        public static void ZAD() throws SQLException {
            Scanner scan = new Scanner(System.in);
            int x = 0;
            String s = "";
            System.out.println("Введите название таблицы: ");
            String tablename = scan.nextLine();

            while (!"6".equals(s)) {
                System.out.println("1. Выводим все таблицы из базы данных. ");
                System.out.println("2. Создать таблицу в базе данных. ");
                System.out.println("3. Ввести две матрицы с клавиатуры и каждую из них сохранить в MySQL с последующим выводом в консоль.");
                System.out.println("4. Перемножить матрицу, сохранить перемноженную матрицу в MySQL и вывести в консоль. ");
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
                    }
                    case 3 -> {
                        int[][] a = CreateTable();
                        int[][] b = CreateTable();

                        insertSQL(tablename, "Matrix1", Arrays.deepToString(a));
                        insertSQL(tablename, "Matrix2", Arrays.deepToString(b));
                    }case 4 ->{
                        int[][] bb = Creation();
                        insertSQL(tablename, "MatrixUmnozh", Arrays.deepToString(bb));
                    }
                }
            }System.out.println("Выход из программы. ЕЕЕЕ");
        }
    }
}
