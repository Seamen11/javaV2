package com.main6.idea;

import java.util.Scanner;

public class seminar5
{
    public static StringBuffer PutTheString(int index)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ввидеите строку номер " + index + " (длина строка должна быть не менее 50 символов): ");
        String str = in.nextLine();
        while (str.length() > 50)
        {
            System.out.println("Введенная строка противоречит условию, повторите ввод: ");
            str = in.nextLine();
        }
        return new StringBuffer(str);
    }
    public static void main(String args[])
    {
        int index = 1;
        StringBuffer str1 = PutTheString(index);
        index++;
        StringBuffer str2 = PutTheString(index);
        System.out.println("Введенная строка 1: " + str1 + "\nВведенная строка 2: " + str2 +
                "\nПервернутая строка 1: " + str1.reverse() + "\nПервернутая строка 2: " + str2.reverse() +
                "\nДобавление одной строки в другую: " + str1 + str2);
    }
}
