package com.kontrolnaya;
import java.util.Scanner;

public class kr
{
    public static boolean CheckInt(String str) {
        try {
            int Str = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Введеенное значение невозомжно преобразовать, повторите вввод: ");
        }
        return false;
    }

    public static String PutTheString(int numberOfAppliance) {
        Scanner in = new Scanner(System.in);
        System.out.println("Пожалуйста введите " + numberOfAppliance + " строку до 50 символов: ");
        String str1 = in.nextLine(); // mark 1
        while (str1.length() < 50) {
            System.out.println("Строка должна быть не менее 50 символов, повторите ввод: ");
            str1 = in.nextLine();
        }
        return str1;
    }

    public static int Cuts(int indexx)
    {
        Scanner in = new Scanner(System.in);
        if (indexx == 1)
        {
            System.out.println("Введите срез (начало), по умолчанию 0: ");
        }else{
            System.out.println("Введите срез (конец), по умолчанию 0: ");
        }

        String kol = in.next();
        if (kol.length() != 0)
        {
            while(!CheckInt(kol))
            {
                kol = in.next();
            }
        }
        return Integer.parseInt(kol);
    }

    public static void main(String[] args) {
        // mark 2
        String s1 = PutTheString(1);
        String s2 = PutTheString(2);


        int kol1 = Cuts(1);
        while (kol1 > s1.length() || kol1 > s2.length())
        {
            System.out.println("Введенное значение НАЧАЛЬНОЙ границы среза превышает колчественное значение символов строк");
            kol1 = Cuts(1);
        }

        int kol2 = Cuts(2);
        while (kol2 > s1.length() || kol2 > s2.length())
        {
            System.out.println("Введенное значение КОНЕЧНОЙ границы среза превышает колчественное значение символов строк");
            kol2 = Cuts(1);
        }
        while (kol1 > kol2)
        {
            System.out.println("э Введенное значение КОНЕЧНОЙ границы среза превышает значение НАЧАЛЬНОЙ границы среза");
            kol2 = Cuts(2);
        }

        System.out.println("Первая строка: " + s1);
        System.out.println("Вторая строка: " + s2 + "\n");

        System.out.println("Начало среза: " + kol1 + "\nКонец среза: " + kol2 + "\n");
        System.out.println("Возвращаем готовый срез ПЕРВОЙ строки: " + s1.substring(kol1, kol2) +
                "\nВозвращаем готовый срез ВТОРОЙ строки: " + s2.substring(kol1, kol2) + "\n" +
                "\n Первая строка в верхнем регистре: " + s1.toUpperCase() +
                "\n Вторая строка в верхнем регистре: " + s2.toUpperCase() + "\n" +
                "\n Первая строка в нижнем регистре: " + s1.toLowerCase() +
                "\n Вторая строка в нижнем регистре: " + s2.toLowerCase() + "\n");

        System.out.println("Введите Подстроку, опредеелим кончается ли этой подстрокой наши строки: ");
        Scanner in = new Scanner(System.in);
        String podstr = in.next();

        while (podstr.length() > 50)
        {
            System.out.println("Подстрока не должна превышать 50 символов, повторите ввод: ");
            podstr = in.nextLine();
        }

        System.out.println("Оканчивается ли первая строка, введенной подстрокой? " + s1.endsWith(podstr) +
                "\nОканчивается ли вторая строка, введенной подстрокой? " + s2.endsWith(podstr));

    }
}

