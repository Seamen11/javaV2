package com.main8.idea;

import java.util.Scanner;

public class ArrayPI2
{
    static int index = 3;
    public static Integer[] CreateTable()
    {
        Scanner in = new Scanner(System.in);
        Integer[] array = new Integer[index];
        for (int i = 0; i < index; i++)
        {
            System.out.println("Введите элемент массива с индексом столбца: " + i);
            array[i] = in.nextInt();
        }
        return array;
    }
    Integer[] arr = CreateTable();
}
