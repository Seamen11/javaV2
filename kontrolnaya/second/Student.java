package com.kontrolnaya.second;

import java.util.Scanner;

public class Student
{
    private static String name;

    public static String setName()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("введите имя:");
        name = in.next();
        return name;
    }public static void getName()
    {
        System.out.println(name);
    }

    public static String setAge()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("введите возраст:");
        return in.next();
    }
}
