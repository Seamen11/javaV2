package com.main10.idea;

import java.util.Arrays;

public class itog extends stepen
{
    public static void main(String[] args)
    {
        int[][] a = new int[index][index];
        int[][] a1 = new int[index][index];
        int a2 = 0;
        int a3 = 0;
        int[][] a4 = new int[index][index];
        System.out.println("Виидеите массив");
        a = CreateMassive(1);
        a1 = multiple(a);
        a2 = Slozhenie(a);
        a3 = vich(a);
        a4 = Stepen(a);
        System.out.println("наш массив " + Arrays.deepToString(a) +
                "\n Умножение: " + Arrays.deepToString(a1) +
                "\n Сложение: " + a2 +
                "\n Вычитание: " + a3 +
                "\n степень: " + Arrays.deepToString(a4) +
                "\n конец"
        );
    }
}
