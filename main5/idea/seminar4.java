package com.main5.idea;
import java.util.Scanner;


public class seminar4
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

    public static void BazaZad4()
    {
        System.out.println("Задание 4");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую строку до 50 символов");
        String s1 = in.nextLine();
        int NachaloSreza = 0;
        int KonetsSreza = 0;

        while (s1.length() > 50) {
            System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
            s1 = in.nextLine();
        }
        System.out.println("Введите вторую строку до 50 символов");
        String s2 = in.nextLine();
        while (s2.length() > 50) {
            System.out.println("Строка не должна превышать 50 символов, повторите ввод: ");
            s2 = in.nextLine();
        }

        System.out.println("Введите срез (начало), по умолчанию 0: ");
        String kol = in.next();
        if (kol.length() != 0)
        {
            while(!ProverkaNaInt(kol))
            {
                kol = in.next();
            }
        }

        System.out.println("Введите срез (конец), по умолчанию 0: ");
        String kol1 = in.next();
        if (kol1.length() != 0)
        {
            while(!ProverkaNaInt(kol1))
            {
                kol1 = in.next();
            }
        }

        System.out.println("Строка 1: " + s1 + ", Строка 2: " + s2 + "\nСрез: " + s1.substring(NachaloSreza, KonetsSreza) +
                "  " + s2.substring(NachaloSreza, KonetsSreza) +
                "\nПеревод в верхний регистр: " + s1.toUpperCase() + " " + s2.toUpperCase() +
                "\nПеревод в нижний регистр: " + s1.toLowerCase() + " " + s2.toLowerCase());

        System.out.println("Введите Подстроку, опредеелим кончается ли этой подстрокой наши строки: ");
        String podstr = in.next();

        while (podstr.length() > 50)
        {
            System.out.println("Подстрока не должна превышать 50 символов, повторите ввод: ");
            podstr = in.nextLine();
        }

        System.out.println("Оканчивается ли первая строка, введенной подстрокой? " + s1.endsWith(podstr) +
                "\nОканчивается ли вторая строка, введенной подстрокой? " + s2.endsWith(podstr));
    }
        public static void main (String[] args)
        {
            BazaZad4();
        }
}
