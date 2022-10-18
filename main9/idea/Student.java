package com.main9.idea;
import java.util.Scanner;

public class Student
{
        protected static String name;
        private static int age;

        public static String setName()
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Задайте имя: ");
            name = in.nextLine();
            return name;
        }
        public static void getName()
        {
            System.out.println(setName());
        }
        public static int setAge()
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Задайте возраст (только в числовом формате): ");
            age = in.nextInt();
            return age;
        }
        public static void getAge()
        {
            System.out.println(setAge());
        }
}

