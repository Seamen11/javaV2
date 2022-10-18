package com.main7testOfSql.idea;

import java.util.Arrays;

public final class Matrix extends ArrayPi1
{
    public static void main(String[] args)
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
    }
}
