package com.main11.idea;

import java.util.Scanner;

public class leha
{
    public static int st1 = 0;
    public static int st2 = 0;
    public static int st3 = 0;

    public static int[] zapolnenie()
    {
        Scanner forin1 = new Scanner(System.in);
        System.out.println("введите сторону 1: ");
        st1 = forin1.nextInt();
        System.out.println("введите сторону 2: ");
        st2 = forin1.nextInt();
        System.out.println("введите сторону 3: ");
        st3 = forin1.nextInt();

        int maxst = 0;
        if (st1 > maxst){
            maxst = 0;
        }
        if (st2 > maxst){
            maxst = 0;
        }
        if (st3 > maxst){
            maxst = 0;
        }
        return new int[]{st1, st2, maxst, st3};
    }
}


class Pryamoug extends leha
{
    public static int[] aa = zapolnenie();
    public static int St1 = aa[0];
    public static int St2 = aa[1];
    public static int St3 = aa[2];
    public static int Maxst = aa[3];


    public static void main(String[] args)
    {
        System.out.println(St1);
    }
}

