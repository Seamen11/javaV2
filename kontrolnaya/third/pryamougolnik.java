package com.kontrolnaya.third;

import java.util.*;

public class pryamougolnik extends factor
{
    public static boolean pryamougol(Integer a, Integer b, Integer c)
    {
        int[] a1 = {a, b, c};
        OptionalInt ma = Arrays.stream(a1).max();

        String aS = Integer.toString(a);
        String bS = Integer.toString(b);
        String cS = Integer.toString(c);

        String[] a2 = {aS, bS, cS};

        List<String> list = new ArrayList<>(Arrays.asList(a2));
        list.remove(ma.toString());

        String aaa = list.get((0));
        String bbb = list.get(1);

        int aI = Integer.parseInt(aaa);
        int bI = Integer.parseInt(bbb);
        return ma.getAsInt() * ma.getAsInt() == aI*aI + bI*bI;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Числа вводим только в целочисленном формате: ");
        System.out.println("Сторона 1: ");
        int a = in.nextInt();
        System.out.println("Сторона 2: ");
        int b = in.nextInt();
        System.out.println("Сторона 3: ");
        int c = in.nextInt();

        boolean o = pryamougol(a, b, c);
        System.out.println("Введенные стороны треугольника. Сторона а: " + a + "\nСторона b: " + b + " Сторона c: "
         + c + "\nПлощадь введенного треугольника ( если не существует NaN) " + ploshad(a, b, c) +
                " Пермитр введенного треугольника ( если не существует NaN) " + perimetr(a, b, c));

         System.out.println("Введите число которое хотите посчитать факториал ");
         int f = in.nextInt();
         int fact = Factorial(f);
         System.out.println("Факториал числа " + f + " равен " + fact);

    }



}
