package com.kontrolnaya.third;

public class kontrolnaya
{
    public static int perimetr(int a, int b, int c)
    {
        return a+b+c;
    }
    public static int ploshad(int a, int b,  int c)
    {
        int p = perimetr(a, b, c);
        return (int) (p*(p-a)*(p-b)*(p-c)) / (p*(p-a)*(p-b)*(p-c) * p*(p-a)*(p-b)*(p-c));
    }
}
