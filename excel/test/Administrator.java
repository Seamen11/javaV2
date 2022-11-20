package com.excel.test;

import java.sql.*;
public class Administrator extends InformSystems
{
    protected static void main() throws SQLException
    {
        int x = 0;
        String s = "";
        String s1 = "";
        Statement stmt = con.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID int, Dish VARCHAR(255), Tableintheres int, " +
                "Quantity int, Price float, Ingredients varchar(1000))";
        stmt.executeUpdate(query);
        while (!"8".equals(s)) {
            System.out.println("""
                    Привет администратор выбери свое действие:
                    1. добавить блюдо в базу данных
                    2. Обновить блюдо в базе данных
                    3. вывести блюда в их базе данных
                    4. Удалить блюдо из базы данных
                    5. добавить количество свободных столиков на текущей момент
                    6. вывести полную информацию на данный момент
                    7. Экспортировать все блюда и количество свободных столиклв в локальное хранилище
                    8. Выход в главное меню""");
            s = scan.next();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода");
            }
            if (x == 1)
            {
                System.out.println("Добавляем блюдо в базу данных! Продолжить?");
                while (scan.hasNext())
                {
                    s1 = scan.next();
                    if (s1.equals("Выход") || s1.equals("8"))
                    {
                        break;
                    }
                    System.out.print("введите ID блюда: ");
                    int ID = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Введите название блюда: ");
                    String Dish = scan.nextLine();
                    System.out.print("Введите количество блюд в началичии на сегодня: ");
                    int Quantity = scan.nextInt();
                    System.out.print("Ввидите цену данного блюда: ");
                    float Price = scan.nextFloat();
                    scan.nextLine();
                    System.out.print("Введите инградиенты данного блюда: ");
                    String Ingradients = scan.nextLine();
                    String query1 = "INSERT INTO " + tablename + " (ID, Dish, Quantity, Price, Ingredients) " +
                            "VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement stmt1 = con.prepareStatement(query1);
                    stmt1.setInt(1, ID);
                    stmt1.setString(2, Dish);
                    stmt1.setInt(3, Quantity);
                    stmt1.setFloat(4, Price);
                    stmt1.setString(5, Ingradients);
                    stmt1.executeUpdate();
                    System.out.println("Блюдо " + Dish + "успешно внесено в базу данных");
                    System.out.println("Продолжить ввод? Если нет, то введите Выход для перехода в меню администратора ");
                }
            }
            if (x == 2)
            {
                System.out.println("Изменяем блюда в базе данных! Прлодлжить? если нет нажмите выход");
                while (scan.hasNext())
                {
                    s1 = scan.next();
                    if (s1.equals("Выход"))
                    {
                        break;
                    }
                        System.out.print("Введите ID изменяемого блюда: ");
                        int ID = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Введите название нового блюда: ");
                        String Dish = scan.nextLine();
                        System.out.print("Введите новое количество блюд в началичии на сегодня: ");
                        int Quantity = scan.nextInt();
                        System.out.print("Ввидите новую цену данного блюда: ");
                        float Price = scan.nextFloat();
                        scan.nextLine();
                        System.out.print("Введите новые инградиенты данного блюда: ");
                        String Ingradients = scan.nextLine();
                        String query2 = "UPDATE " + tablename + " SET Dish = '" + Dish + "', Quantity = '" + Quantity + "', Price = '" + Price +
                            "', Ingredients = '" + Ingradients +"' WHERE ID = " + ID + "";
                        PreparedStatement stmt1 = con.prepareStatement((query2));
                        stmt1.executeUpdate();
                        System.out.println("Блюдо '" + Dish + "' усепшно добавлено. Хотите еще обновить блюдо? Если нет" +
                                " введите команду 'Выход' для перехода в меню администратора");

                    }
                }

            if (x == 3)
            {
                Statement stmt1 = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + tablename + "");
                System.out.printf("%1s | %-20s | %-5s | %-6s | %-5s \n", "ID", "Название", "Количество", "Цена", "Инградиенты");
                while (rs.next())
                {
                    int ID = rs.getInt("ID");
                    String Dish = rs.getString("Dish");
                    int Quantity = rs.getInt("Quantity");
                    float Price = rs.getFloat("Quantity");
                    String Ingredients = rs.getString("Ingredients");

                    System.out.printf("%2d | %-20s | %-10s | %-2.2f | %-5s \n", ID, Dish, Quantity, Price, Ingredients);
                }
            }
            if (x == 4)
            {
                System.out.println("Удаляем блюдо из базы данных! Продолжить? Если нет, введите 'Выход' ");
                while (scan.hasNext())
                {
                    s1 = scan.next();
                    if (s1.equals("Выход"))
                    {
                        break;
                    }
                    System.out.print("Ввидеите  ID удаляемого блюда: ");
                    int ID = scan.nextInt();
                    String query2 = "SET SQL_SAFE_UPDATES = 0";
                    String query3 = "DELETE FROM " + tablename + " WHERE ID = '" + ID + "'";
                    String query4 = "SET SQL_SAFE_UPDATES = 1";
                    PreparedStatement stmt1 = con.prepareStatement(query2);
                    PreparedStatement stmt2 = con.prepareStatement(query3);
                    PreparedStatement stmt3 = con.prepareStatement(query4);
                    stmt1.executeUpdate();
                    stmt2.executeUpdate();
                    stmt3.executeUpdate();
                    System.out.println("Блюдо с ID " + ID + " успешно удалено из базы данных");
                    System.out.println("Хотите еще удалить блюдо? Если нет, то введите 'Выход' для перехода в меню админисратора");
                }
            }
            if (x == 5)
            {
                System.out.print("Добавьте количество столиков на текущий момент");
                int Tableintheres = scan.nextInt();
                String query2 = "SET SQL_SAFE_UPDATES = 0";
                String query3 = "UPDATE " + tablename + " SET Tableintheres = '" + Tableintheres + "' WHERE Tableintheres IS NULL";
                String query4 = "SET SQL_SAFE_UPDATES = 1";
                PreparedStatement stmt1 = con.prepareStatement(query2);
                PreparedStatement stmt2 = con.prepareStatement(query3);
                PreparedStatement stmt3 = con.prepareStatement(query4);
                stmt1.executeUpdate();
                stmt2.executeUpdate();
                stmt3.executeUpdate();
                System.out.println("Столики успешно добавлены!");
            }
            if (x == 6) // вывести полную информацию на текущий момент
            {
                Statement stmt1 = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + tablename + "");
                System.out.printf("%1s | %-29s | %-5s | %-6s | %-20s | %-5s \n", "ID", "Название", "Количество", "Цена", "Количество свободных столиков", "Инградиенты");
                while (rs.next())
                {
                    int ID = rs.getInt("ID");
                    String Dish = rs.getString("Dish");
                    int Quantity = rs.getInt("Quantity");
                    float Price = rs.getFloat("Price");
                    int Tableintheres = rs.getInt("Tableintheres");
                    String Ingredients = rs.getString("Ingredients");

                    System.out.printf("%2d | %-29s | %-5s | %-2.2f | %-29s | %-5s \n", ID, Dish, Quantity, Price, Tableintheres, Ingredients);
                }
            }
            if (x == 7)
            {
                scan.nextLine();
                System.out.print("Введите название файла с расширением: ");
                String file = scan.nextLine();
                String query1 = "SET SQL_SAFE_UPDATES = 0";
                String query2 = "UPDATE " + tablename + " SET Price = ROUND(Price, 2)";
                String query3 = "SET SQL_SAFE_UPDATES = 1";
                String query4 = "SELECT 'ID', 'Dish', 'Tableintheres', 'Quantity', 'Price', 'Ingredients' UNION ALL SELECT * FROM " +
                        tablename + " INTO OUTFILE '/Users/nikmak/Library/Mobile Documents/com~apple~CloudDocs/javaExcel"
                         + file + "' CHARACTER SET cp1251";
                PreparedStatement stmt1 = con.prepareStatement(query1);
                PreparedStatement stmt2 = con.prepareStatement(query2);
                PreparedStatement stmt3 = con.prepareStatement(query3);
                PreparedStatement stmt4 = con.prepareStatement(query4);
                stmt1.executeUpdate();
                stmt2.executeUpdate();
                stmt3.executeUpdate();
                stmt4.executeQuery();
                System.out.println("Данные усепшно экспортированны! ");

            }

        }
    }
}
