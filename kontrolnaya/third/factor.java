package com.kontrolnaya.third;

public class factor extends kontrolnaya
{
    public static int Factorial(int f)
    {

        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}
