package com.main11.idea;
import java.util.Scanner;


public class kontrol {

    public static int st1 = 0;
    public static int st2 = 0;
    public static int st3 = 0;

    public static int[] zapolnenie() {
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
        int perimetr = st1 + st2 + st3;
        int ploshad = (int) Math.sqrt(perimetr*(perimetr - st1)*(perimetr - st2)*(perimetr - st3));
        System.out.println("Периметр: " + perimetr);
        System.out.println("Площадь: " + ploshad);
        return new int[]{st1, st2, st3, maxst};
    }
}
class proverka extends kontrol
{
    public static int[] aa = zapolnenie();
    public static int st1 = aa[0];
    public static int st2 = aa[1];
    public static int st3 = aa[2];
    public static int maxst = aa[3];

    public static void pif() {
        if ((maxst == st1) && (maxst*maxst == st2*st2 + st3*st3)) {
            System.out.print("Треугольник прямоугольный");
        }
        else {
            if ((maxst == st2) && (maxst*maxst == st1*st1 + st3*st3)) {
                System.out.print("Треугольник прямоугольный");
            }
            else {
                if ((maxst == st3) && (maxst*maxst == st1*st1 + st2*st2)) {
                    System.out.print("Треугольник прямоугольный");
                }
                else {
                    System.out.print("Треугольник не прямоугольный");
                }
            }
        }
    }

    public static void main(String[] args)
    {
        pif();
    }
}