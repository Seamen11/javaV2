package com.main7testOfSql.idea;

import java.util.Scanner;

public class ArrayPi1
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
