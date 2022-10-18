package com.main4.idea;
import java.util.Arrays;
import java.util.Scanner;

public class seminar3
{

    public static boolean ProverkaNaInt(String arguement)
    {
        try
        {
            int Value = Integer.parseInt(arguement);
            return true;
        } catch (NumberFormatException e)
        {
            System.out.println("Введенное значение невозможно преобразовать в целочисленное, повторите ввод: ");
        }
        return false;
    }

    public static boolean ProverkaNaChetnost(int arguement)
    {
        return arguement % 2 == 0;
    }

    public static void Zad3()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество чисел которые хотите задатть: ");
        String kol = in.next();
        while(!ProverkaNaInt(kol))
        {
            kol = in.next();
        }

        int koll = Integer.parseInt(kol);
        int[] ArrayOfInts = new int[koll];
        int[] ArrayOfChet = new int[koll];

        for (int i = 0; i < koll; i++)
        {
            System.out.println("Введите число под номером " + i);
            String value = in.next();
            while (!ProverkaNaInt(value))
            {
                value = in.next();
            }
            int valueU = Integer.parseInt(value);
            if (ProverkaNaChetnost(valueU))
            {
                ArrayOfChet[i] = valueU;
            }
            ArrayOfInts[i] = valueU;
            //System.out.println(Arrays.toString(ArrayOfInts) + "   " + Arrays.toString(ArrayOfChet));
        }

        System.out.println("Полученные значения: " + Arrays.toString(ArrayOfInts) + ", Четные значения из этого численности: ");
        for (int i = 0; i < ArrayOfChet.length; i++)
        {
            if (ArrayOfChet[i] != 0)
            {
                System.out.println(ArrayOfChet[i]);
            }
        }

}
    public static void main(String[] args)
    {
        System.out.println("Задание 3");
        Zad3();
    }
}
