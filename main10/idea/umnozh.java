package com.main10.idea;

public class umnozh extends ArrayPi
{
    public static int[][] multiple(int[][] massive)
    {
        int[][] array2 = new int[index][index];
        for (int i = 0; i < index; i++)
        {
            for (int j = 0; j < index; j++)
            {
                for (int u = 0; u < index; u++)
                {
                    array2[i][u] += massive[i][j] * massive[j][u];
                }
            }
        }
        return array2;
    }
}
