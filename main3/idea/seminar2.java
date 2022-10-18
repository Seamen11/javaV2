package com.main3.idea;
import java.util.Scanner;

public class seminar2
{
    public static void BazaZad()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую строку до 50 символов");
        String s1 = in.nextLine();
        while (s1.length() > 50)
        {
            System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
            s1 = in.nextLine();
        }
        System.out.println("Введите вторую строку до 50 символов");
        String s2 = in.nextLine();
        while (s2.length() > 50)
        {
            System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
            s2 = in.nextLine();
        }

        String sum = s1 + s2;

        System.out.println("Строка 1: " + s1 + ", Строка 2: " + s2 + "\nРазмер первой строки: " + s1.length() +
                ",  Размер второй строки: " + s2.length() + "\nОбъединение двух строк: " + sum +
                "\nСравнения двух строк (одинаковы ли они или нет?): " + s1.equals(s2));

    }

    public static void main(String[] args)
    {
        System.out.println("Задание 2");
        BazaZad();
    }
}
