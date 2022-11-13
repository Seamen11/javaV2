package com.kontrolnaya.second;

import java.util.Scanner;

public class worker extends Student
{
    public static String salary;

    public static String setSalary()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("введите зарплату:");
        salary = in.next();
        return salary;
    }

    public static void format(String s, String s2, String s3)
    {
        System.out.printf("%20s | %-20s | %-20s \n", "ИМЯ", "ВОЗРАСТ", "ЗП");
        System.out.printf("%20s | %-20s | %-20s \n", s, s2, s3);
    }


    public static void main(String[] args)
    {
        format(setName(), setAge(), setSalary());
    }
}

