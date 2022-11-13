package com.main10.idea;

import java.util.Scanner;

public class ArrayPi
{
    static int index = 7;
    public static int[][] CreateMassive(int index1)
    {
        Scanner in = new Scanner(System.in);
        int[][] a = new int[index][index];
        for (int i = 0; i < index; i++)
        {
            for (int j = 0; j < index; j++)
            {
                a[i][j] = in.nextInt();
            }
        }
        System.out.println("Создали массив номер " + index1);
        return a;
    }
}
