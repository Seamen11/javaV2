package com.main10.idea;

public class stepen extends VICH
{
    public static int[][] Stepen(int[][] massive)
    {
        int[][] array = new int[index][index];
        for (int i = 0; i < index; i++)
        {
            for(int j = 0; j < index; j++)
            {
                array[i][j] = massive[i][j] * massive[i][j];
            }
        }
        return array;
    }
}
