package com.main2.idea;
import java.math.BigInteger;

import java.sql.*; // импортируем все что связано с SQL
import java.util.Arrays; // util специалный класс состоящий из структуры коллекций, коллекций
import java.util.Objects;
import java.util.Scanner;


public class sem1Medium
{
    public static int pow(int value, int powValue) {  // продумана возможность возведения больших степеней
        BigInteger a = new BigInteger(String.valueOf(value));
        return a.pow(powValue).intValue();
    }
    public static String Determiant()
    {
        System.out.println("Введите с каким типом вы хотите работать: 1)int; 2)float; 3)double; 4)byte ");
        Scanner in = new Scanner(System.in);
        String var = in.next();
        if (Objects.equals(var, "int") || Objects.equals(var, "float") || Objects.equals(var, "double")
                || Objects.equals(var, "byte"))
        {
            return var;
        }
        return "";
    }

    public static void insertSQL(String tablename, String ID, String ID1, String ID2, String result, String result1,
                                 String result2) throws SQLException
    {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mySQLurl2 = "jdbc:mysql://localhost:3306/lesson1";
        Connection con2 = DriverManager.getConnection(mySQLurl2, "root", "7043931Nik");
        System.out.println("Успешное подключение к базе данных. ");

        String query2 = "INSERT INTO " + tablename + "(ID, RES) VALUES (?, ?), (?, ?), (?, ?)";
        PreparedStatement stmt3 = con2.prepareStatement(query2);
        stmt3.setString(1, ID);
        stmt3.setString(2, result);
        stmt3.setString(3, ID1);
        stmt3.setString(4, result1);
        stmt3.setString(5, ID2);
        stmt3.setString(6, result2);
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

    public static void main (String[] args) throws SQLException // чтобы выводились ошибки, если они допущены
    {
        Scanner scan = new Scanner(System.in);
        // создаем консольное меню
        int x = 0;
        String s = "";
        System.out.println("Введите название таблицы: ");
        String tablename = scan.nextLine();

        while (!"10".equals(s))
        {
            System.out.println("1. Выводим все таблицы из базы данных. ");
            System.out.println("2. Создать таблицу в базе данных. ");
            System.out.println("3. Сложение чисел, результат сохранить в MySQL с последующим выводом в консоль. ");
            System.out.println("4. Вычитание чисел, результат сохранить в MySQL с последующим выводом в консоль. ");
            System.out.println("5. Умножение чисел, результат сохранить в MySQL с последующим выводом в консоль.");
            System.out.println("6. Деление чисел, результат сохранить в MySQL с последующим выводом в консоль.");
            System.out.println("7. Деление чисел по модулю (остаток), результат сохранить в MySQL с последующим" +
                    " выводом в консоль.");
            System.out.println("8. Возведение числа в модуль, результат сохранить в MySQL с последующим выводом " +
                    "в консоль. ");
            System.out.println("9. Возведение числа в степень, результат сохранить в MySQL с последующим выводом" +
                    " в консоль. ");
            System.out.println("10. Выход из программы. ");
            s = scan.next();

            try{
                x = Integer.parseInt(s);
            }catch(NumberFormatException e){
                System.out.println("Неверный формат ввода. ");
            }

            switch (x)
            {
                case 1 -> // Вывести все таблицы из бд
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
                case 2 -> // создать таблицу
                {
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl1 = "jdbc:mysql://localhost:3306/lesson1";
                    Connection con1 = DriverManager.getConnection(mySQLurl1, "root", "7043931Nik");
                    System.out.println("Успешное подключение к базе данных. ");
                    Statement stmt1 = con1.createStatement();
                    String query = "CREATE TABLE IF NOT EXISTS " +  tablename + " (ID varchar(255), RES varchar(255))";
                    stmt1.executeUpdate(query);
                    ResultSet rs1 = stmt1.executeQuery("Show Tables");
                    System.out.println("Таблицы из базы данных: ");
                    while (rs1.next())
                    {
                        System.out.print(rs1.getString(1));
                        System.out.println();
                    }
                }
                case 3 -> // сложение чисел
                {
                    String type = Determiant();

                    String ID = "Первое Слагаемое ";
                    String ID1 = "Второе Слагаемое ";
                    String ID2 = "Результат сложения ";

                    if (Objects.equals(type, "int")) {
                        System.out.println("Введите int число #1: ");
                        int number = scan.nextInt();
                        System.out.println("Введите int число #2: ");
                        int number1 = scan.nextInt();
                        scan.nextLine();
                        int number2 = number + number1;
                        String result = Integer.toString(number);// преобразование
                        String result1 = Integer.toString(number1);
                        String result2 = Integer.toString(number2);
                        insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                    }if (Objects.equals(type, "float")) {
                        System.out.println("Введите float число #1: ");
                        float number = scan.nextFloat();
                        System.out.println("Введите float число #2: ");
                        float number1 = scan.nextFloat();
                        scan.nextLine();
                        float number2 = number + number1;
                        String result = Float.toString(number); // преобразование
                        String result1 = Float.toString(number1);
                        String result2 = Float.toString(number2);
                        insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                    }if (Objects.equals(type, "double")) {
                    System.out.println("Введите double число #1: ");
                    double number = scan.nextDouble();
                    System.out.println("Введите double число #2: ");
                    double number1 = scan.nextDouble();
                    scan.nextLine();
                    double number2 = number + number1;
                    String result = Double.toString(number); // преобразование
                    String result1 = Double.toString(number1);
                    String result2 = Double.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "byte")) {
                    System.out.println("Введите double число #1: ");
                    byte number = scan.nextByte();
                    System.out.println("Введите double число #2: ");
                    byte number1 = scan.nextByte();
                    scan.nextLine();
                    byte number2 = (byte) (number + number1);
                    String result = Byte.toString(number); // преобразование
                    String result1 = Byte.toString(number1);
                    String result2 = Byte.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);}
                }case 4 ->{ // вычитание
                String type = Determiant();

                String ID = "вычитаемое ";
                String ID1 = "вычитатель ";
                String ID2 = "Результат вычетания ";

                if (Objects.equals(type, "int")) {
                    System.out.println("Введите int число #1: ");
                    int number = scan.nextInt();
                    System.out.println("Введите int число #2: ");
                    int number1 = scan.nextInt();
                    scan.nextLine();
                    int number2 = number - number1;
                    String result = Integer.toString(number);// преобразование
                    String result1 = Integer.toString(number1);
                    String result2 = Integer.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "float")) {
                    System.out.println("Введите float число #1: ");
                    float number = scan.nextFloat();
                    System.out.println("Введите float число #2: ");
                    float number1 = scan.nextFloat();
                    scan.nextLine();
                    float number2 = number - number1;
                    String result = Float.toString(number); // преобразование
                    String result1 = Float.toString(number1);
                    String result2 = Float.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "double")) {
                    System.out.println("Введите double число #1: ");
                    double number = scan.nextDouble();
                    System.out.println("Введите double число #2: ");
                    double number1 = scan.nextDouble();
                    scan.nextLine();
                    double number2 = number - number1;
                    String result = Double.toString(number); // преобразование
                    String result1 = Double.toString(number1);
                    String result2 = Double.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "byte")) {
                    System.out.println("Введите double число #1: ");
                    byte number = scan.nextByte();
                    System.out.println("Введите double число #2: ");
                    byte number1 = scan.nextByte();
                    scan.nextLine();
                    byte number2 = (byte) (number - number1);
                    String result = Byte.toString(number); // преобразование
                    String result1 = Byte.toString(number1);
                    String result2 = Byte.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);}
            }case 5 ->{   // умножение
                String type = Determiant();

                String ID = "Первое член ";
                String ID1 = "Второй член ";
                String ID2 = "Результат умножение ";

                if (Objects.equals(type, "int")) {
                    System.out.println("Введите int число #1: ");
                    int number = scan.nextInt();
                    System.out.println("Введите int число #2: ");
                    int number1 = scan.nextInt();
                    scan.nextLine();
                    int number2 = number * number1;
                    String result = Integer.toString(number);// преобразование
                    String result1 = Integer.toString(number1);
                    String result2 = Integer.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "float")) {
                    System.out.println("Введите float число #1: ");
                    float number = scan.nextFloat();
                    System.out.println("Введите float число #2: ");
                    float number1 = scan.nextFloat();
                    scan.nextLine();
                    float number2 = number * number1;
                    String result = Float.toString(number); // преобразование
                    String result1 = Float.toString(number1);
                    String result2 = Float.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "double")) {
                    System.out.println("Введите double число #1: ");
                    double number = scan.nextDouble();
                    System.out.println("Введите double число #2: ");
                    double number1 = scan.nextDouble();
                    scan.nextLine();
                    double number2 = number * number1;
                    String result = Double.toString(number); // преобразование
                    String result1 = Double.toString(number1);
                    String result2 = Double.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "byte")) {
                    System.out.println("Введите double число #1: ");
                    byte number = scan.nextByte();
                    System.out.println("Введите double число #2: ");
                    byte number1 = scan.nextByte();
                    scan.nextLine();
                    byte number2 = (byte) (number * number1);
                    String result = Byte.toString(number); // преобразование
                    String result1 = Byte.toString(number1);
                    String result2 = Byte.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);}
            }case 6 ->{  // деление числа
                String type = Determiant();

                String ID = "Делимое ";
                String ID1 = "Делитель ";
                String ID2 = "Частное ";

                if (Objects.equals(type, "int")) {
                    System.out.println("Введите int число #1: ");
                    int number = scan.nextInt();
                    System.out.println("Введите int число #2: ");
                    int number1 = scan.nextInt();
                    scan.nextLine();
                    int number2 = number / number1;
                    String result = Integer.toString(number);// преобразование
                    String result1 = Integer.toString(number1);
                    String result2 = Integer.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "float")) {
                    System.out.println("Введите float число #1: ");
                    float number = scan.nextFloat();
                    System.out.println("Введите float число #2: ");
                    float number1 = scan.nextFloat();
                    scan.nextLine();
                    float number2 = number / number1;
                    String result = Float.toString(number); // преобразование
                    String result1 = Float.toString(number1);
                    String result2 = Float.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "double")) {
                    System.out.println("Введите double число #1: ");
                    double number = scan.nextDouble();
                    System.out.println("Введите double число #2: ");
                    double number1 = scan.nextDouble();
                    scan.nextLine();
                    double number2 = number / number1;
                    String result = Double.toString(number); // преобразование
                    String result1 = Double.toString(number1);
                    String result2 = Double.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "byte")) {
                    System.out.println("Введите double число #1: ");
                    byte number = scan.nextByte();
                    System.out.println("Введите double число #2: ");
                    byte number1 = scan.nextByte();
                    scan.nextLine();
                    byte number2 = (byte) (number / number1);
                    String result = Byte.toString(number); // преобразование
                    String result1 = Byte.toString(number1);
                    String result2 = Byte.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);}
            }case 7->{ // деление чисел по модулю
                String type = Determiant();

                String ID = "Делимое ";
                String ID1 = "Делитель ";
                String ID2 = "Остаток ";

                if (Objects.equals(type, "int")) {
                    System.out.println("Введите int число #1: ");
                    int number = scan.nextInt();
                    System.out.println("Введите int число #2: ");
                    int number1 = scan.nextInt();
                    scan.nextLine();
                    int number2 = number % number1;
                    String result = Integer.toString(number);// преобразование
                    String result1 = Integer.toString(number1);
                    String result2 = Integer.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "float")) {
                    System.out.println("Введите float число #1: ");
                    float number = scan.nextFloat();
                    System.out.println("Введите float число #2: ");
                    float number1 = scan.nextFloat();
                    scan.nextLine();
                    float number2 = number % number1;
                    String result = Float.toString(number); // преобразование
                    String result1 = Float.toString(number1);
                    String result2 = Float.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "double")) {
                    System.out.println("Введите double число #1: ");
                    double number = scan.nextDouble();
                    System.out.println("Введите double число #2: ");
                    double number1 = scan.nextDouble();
                    scan.nextLine();
                    double number2 = number % number1;
                    String result = Double.toString(number); // преобразование
                    String result1 = Double.toString(number1);
                    String result2 = Double.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "byte")) {
                    System.out.println("Введите double число #1: ");
                    byte number = scan.nextByte();
                    System.out.println("Введите double число #2: ");
                    byte number1 = scan.nextByte();
                    scan.nextLine();
                    byte number2 = (byte) (number % number1);
                    String result = Byte.toString(number); // преобразование
                    String result1 = Byte.toString(number1);
                    String result2 = Byte.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);}
            }case 8->{
                String type = Determiant();

                String ID = "Число ";
                String ID1 = "число 2 ";
                String ID2 = "Модуль ";

                if (Objects.equals(type, "int")) {
                    System.out.println("Введите int число #1: ");
                    int number = scan.nextInt();
                    System.out.println("Введите int число #2: ");
                    int number1 = scan.nextInt();
                    scan.nextLine();
                    int number2 = Math.abs(number);
                    String result = Integer.toString(number);// преобразование
                    String result1 = Integer.toString(number1);
                    String result2 = Integer.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "float")) {
                    System.out.println("Введите float число #1: ");
                    float number = scan.nextFloat();
                    System.out.println("Введите float число #2: ");
                    float number1 = scan.nextFloat();
                    scan.nextLine();
                    int number2 = (int) Math.abs(number);
                    String result = Float.toString(number); // преобразование
                    String result1 = Float.toString(number1);
                    String result2 = Float.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "double")) {
                    System.out.println("Введите double число #1: ");
                    double number = scan.nextDouble();
                    System.out.println("Введите double число #2: ");
                    double number1 = scan.nextDouble();
                    scan.nextLine();
                    double number2 = Math.abs(number);
                    String result = Double.toString(number); // преобразование
                    String result1 = Double.toString(number1);
                    String result2 = Double.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "byte")) {
                    System.out.println("Введите double число #1: ");
                    byte number = scan.nextByte();
                    System.out.println("Введите double число #2: ");
                    byte number1 = scan.nextByte();
                    scan.nextLine();
                    byte number2 = (byte) (Math.abs(number));
                    String result = Byte.toString(number); // преобразование
                    String result1 = Byte.toString(number1);
                    String result2 = Byte.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);}
            }
            case 9->{
                String type = Determiant();

                String ID = "число ";
                String ID1 = "Степень ";
                String ID2 = "Результат возведения ";

                if (Objects.equals(type, "int")) {
                    System.out.println("Введите int число #1: ");
                    int number = scan.nextInt();
                    System.out.println("Введите int число #2: ");
                    int number1 = scan.nextInt();
                    scan.nextLine();
                    int number2 = pow(number, number1);
                    String result = Integer.toString(number);// преобразование
                    String result1 = Integer.toString(number1);
                    String result2 = Integer.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "float")) {
                    System.out.println("Введите float число #1: ");
                    double number = scan.nextDouble();
                    System.out.println("Введите float число #2: ");
                    double number1 = scan.nextDouble();
                    scan.nextLine();
                    double number2 =  Math.pow(number, number1);
                    String result = Double.toString(number); // преобразование
                    String result1 = Double.toString(number1);
                    String result2 = Double.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "double")) {
                    System.out.println("Введите double число #1: ");
                    double number = scan.nextDouble();
                    System.out.println("Введите double число #2: ");
                    double number1 = scan.nextDouble();
                    scan.nextLine();
                    double number2 = Math.pow( number, number1);
                    String result = Double.toString(number); // преобразование
                    String result1 = Double.toString(number1);
                    String result2 = Double.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);
                }if (Objects.equals(type, "byte")) {
                    System.out.println("Введите double число #1: ");
                    byte number = scan.nextByte();
                    System.out.println("Введите double число #2: ");
                    byte number1 = scan.nextByte();
                    scan.nextLine();
                    byte number2 = (byte) (Math.pow(number, number1));
                    String result = Byte.toString(number); // преобразование
                    String result1 = Byte.toString(number1);
                    String result2 = Byte.toString(number2);
                    insertSQL(tablename, ID,ID1, ID2, result, result1, result2);}
                }
            }
        }
        System.out.println("Выход из программы (успешно)");
    }
}

