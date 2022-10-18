package com.main7testOfSql.idea;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ArrayPI
{
        public static String test(Object value) // используем суперкласс для передачи значений
    {
        if (value instanceof Integer) {
            System.out.println("Это Integer");
            return "int";
        } else if (value instanceof String) {
            System.out.println("Это String");
            return "string";
        } else if (value instanceof Float) {
            System.out.println("Это Float");
            return "float";
        } else if (value instanceof Double) {
            System.out.println("Это Double");
            return "double";
        }
        return "None";
    }

        public static void CreateArray() {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите тип воодимых значений (int, float, byte, double, str): ");
            String str = in.next();
            Object value;

            if (Objects.equals(str, "float"))
            {
                value = in.nextInt();
            }if (Objects.equals(str, "byte"))
            {
                value = in.nextByte();
            }if (Objects.equals(str, "double"))
            {
                value = in.nextDouble();
            }if (Objects.equals(str, "str"))
            {
                value = in.next();
            }else{
                value = in.nextInt();
            }


            System.out.println("Введите массив состоящий из 35 значений типа: ");
            System.out.println("Введите значение массива с индексом 0: ");
            System.out.println(test(value));
            for (int i = 0; i <= 35; i++) {
                System.out.println("Введите значение с индексом " + i + ": ");
            }
        }

        public static void main(String[] args)
        {
            CreateArray();
        }


}
