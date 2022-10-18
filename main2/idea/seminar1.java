package com.main2.idea;
import java.util.Scanner;

public class seminar1 // целочисленные, байтовые, вещественные
{
    public static int test = 0;
    public static void Summ(String determiant, int a, int b, byte a1, byte b1, float a2, float b2, double a3, double b3)
    {
        if(determiant.equalsIgnoreCase("int"))
        {
            System.out.println(a + b);
        }
        if(determiant.equalsIgnoreCase("float"))
        {
            System.out.println(a2 + b2);
        }
        if(determiant.equalsIgnoreCase("double"))
        {
            System.out.println(a3 + b3);
        }
        if(determiant.equalsIgnoreCase("byte"))
        {
            System.out.println(a1 + b1);
        }
    }

    public static void Umnozh(String determiant, int a, int b, byte a1, byte b1, float a2, float b2, double a3, double b3)
    {
        if(determiant.equalsIgnoreCase("int"))
        {
            System.out.println(a * b);
        }
        if(determiant.equalsIgnoreCase("float"))
        {
            System.out.println(a2 * b2);
        }
        if(determiant.equalsIgnoreCase("double"))
        {
            System.out.println(a3 * b3);
        }
        if(determiant.equalsIgnoreCase("byte"))
        {
            System.out.println(a1 * b1);
        }
    }

    public static void Del(String determiant, int a, int b, byte a1, byte b1, float a2, float b2, double a3, double b3)
    {
        if(determiant.equalsIgnoreCase("int"))
        {
            System.out.println(a / b);
        }
        if(determiant.equalsIgnoreCase("float"))
        {
            System.out.println(a2 / b2);
        }
        if(determiant.equalsIgnoreCase("double"))
        {
            System.out.println(a3 / b3);
        }
        if(determiant.equalsIgnoreCase("byte"))
        {
            System.out.println(a1 / b1);
        }
    }

    public static void DelOst(String determiant, int a, int b, byte a1, byte b1, float a2, float b2, double a3, double b3)
    {
        if(determiant.equalsIgnoreCase("int"))
        {
            System.out.println(a % b);
        }
        if(determiant.equalsIgnoreCase("float"))
        {
            System.out.println(a2 % b2);
        }
        if(determiant.equalsIgnoreCase("double"))
        {
            System.out.println(a3 % b3);
        }
        if(determiant.equalsIgnoreCase("byte"))
        {
            System.out.println(a1 % b1);
        }
    }

    public static void modul(String determiant, int a, int b, byte a1, byte b1, float a2, float b2, double a3, double b3)
    {
        if(determiant.equalsIgnoreCase("int"))
        {
            System.out.println(Math.abs(a) + Math.abs(b));
        }
        if(determiant.equalsIgnoreCase("float"))
        {
            System.out.println(Math.abs(a2) + Math.abs(b2));
        }
        if(determiant.equalsIgnoreCase("double"))
        {
            System.out.println(Math.abs(a3) + Math.abs(b3));
        }
        if(determiant.equalsIgnoreCase("byte"))
        {
            System.out.println(Math.abs(a1) + Math.abs(b1));
        }
    }

    public static void Stepen(String determiant, int a, int b, byte a1, byte b1, float a2, float b2, double a3, double b3)
    {
        if(determiant.equalsIgnoreCase("int"))
        {
            System.out.println(Math.pow(a, b));
        }
        if(determiant.equalsIgnoreCase("float"))
        {
            System.out.println(Math.pow(a2, b2));
        }
        if(determiant.equalsIgnoreCase("double"))
        {
            System.out.println(Math.pow(a3, b3));
        }
        if(determiant.equalsIgnoreCase("byte"))
        {
            System.out.println(Math.pow(a1, b1));
        }
    }

    public static void main(String[] args) // основной метод джава, является точкой входа  любой программы, синтаксис не меняется, менять модем можем только имя входного аругмента string[]
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать в программу математических операций");
        int a = 0; int b = 0; byte a1 = 0; byte b1 = 0; float a2 = 0; float b2 = 0; double a3 = 0; double b3 = 0;
        System.out.println("Введите тип, с которым будете работать. (int, byte, float, double)");
        String determiant = in.nextLine();
        System.out.println(determiant);
        String[] ListOfTypes = {"int", "byte", "float", "double"};
        String[] ListOfOperations = {"Summ", "Umnozh", "Del", "DelOst", "Modul", "Stepen"};
        int index = 0;
        //String[] ListOfIndex = {"a", "b", "a1", "b1", "a2", "b2", "a3", "b3"};
        for (int i = 0; i < 4; i++)
        {
            if (ListOfTypes[i].equalsIgnoreCase(determiant))
            {
                index = i;
                break;
            }
        }
        for (int i = 0; i < 4; i++)
        {
            if (i == index)
            {
                if (i == 0)
                {
                    System.out.println("Введите целочисленные значения для 2 переменных: ");
                    a = in.nextInt();
                    b = in.nextInt();
                }
                if (i == 1)
                {
                    System.out.println("Введите байтовые значения для 2 переменных: ");
                    a1 = in.nextByte();
                    b1 = in.nextByte();
                }
                if (i == 2)
                {
                    System.out.println("Введите числа с плавающей точкой значения для 2 переменных: ");
                    a2 = in.nextFloat();
                    b2 = in.nextFloat();
                }
                if (i == 3)
                {
                    System.out.println("Введите большие числа с плавающей точкой значения для 2 переменных: ");
                    a3 = in.nextDouble();
                    b3 = in.nextDouble();
                }
            }
        }
        System.out.println("Введите операцию которую хотите сделать Summ, Umnozh, Del, DelOst, Modul, Stepen: ");
        String oper = in.next();
        for (int ii = 0; ii < ListOfOperations.length; ii++)
        {
            if (oper.equalsIgnoreCase(ListOfOperations[ii]))
            {
                if (ii == 0)
                {
                    Summ(determiant, a,b,a1,b1,a2,b2,a3,b3);
                }
                if (ii == 1)
                {
                    Umnozh(determiant, a,b,a1,b1,a2,b2,a3,b3);
                }
                if (ii == 2)
                {
                    Del(determiant, a,b,a1,b1,a2,b2,a3,b3);
                }
                if (ii == 3)
                {
                    DelOst(determiant, a,b,a1,b1,a2,b2,a3,b3);
                }
                if (ii == 4)
                {
                    modul(determiant, a,b,a1,b1,a2,b2,a3,b3);
                }
                if (ii == 5)
                {
                    Stepen(determiant, a,b,a1,b1,a2,b2,a3,b3);
                }
            }
        }
        /*Summ(determiant, a,b,a1,b1,a2,b2,a3,b3);
        Umnozh(determiant, a,b,a1,b1,a2,b2,a3,b3);
        Del(determiant, a,b,a1,b1,a2,b2,a3,b3);
        DelOst(determiant, a,b,a1,b1,a2,b2,a3,b3);
        modul(determiant, a,b,a1,b1,a2,b2,a3,b3);
        Stepen(determiant, a,b,a1,b1,a2,b2,a3,b3);*/
    }
}
