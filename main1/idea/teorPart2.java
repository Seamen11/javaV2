package com.main1.idea;

public class teorPart2 {
    public static void main(String[] test)
    {
        // string buffer class экономичнее по памяти и изменяемые строки
        StringBuffer cat = new StringBuffer("Котик");
        System.out.println(cat);

        System.out.println("Длина строки 'cat' равна: " + cat.length());
        System.out.println("Выделенный объем памяти, под строку cat: "+ cat.capacity());

        // можем заранее определеить сколько отводить памяти
        cat.ensureCapacity(28);
        System.out.println(cat.capacity());

        // соединить в одну строку любые типы данных

        String str1 = "У котика/собачки ";
        String str2 = " есть лапки";
        int number2 = 4;
        StringBuffer cat1 = new StringBuffer(30);
        cat1.append(str1).append(number2).append(str2);
        System.out.println(cat1);

        // вставляем нудный фрагмент куда нам надо
        StringBuffer str3 = new StringBuffer("Сегодня хорошая погода!");
        str3.insert(7, " очень");
        System.out.println(str3);

        System.out.println(str3.reverse());

        // удаление
        StringBuffer str4 = new StringBuffer("Сегодня хорошая погода!");
        str4.delete(3, 5); // удаляется с 3-5, при этом 5 не включается
        System.out.println("Строка с учетом удаленных символов: " + str4);
        System.out.println("Строка с учетом одного удаленного символа" + str4.deleteCharAt(4));

        // заменить диапазон символов

        StringBuffer str5 = new StringBuffer("Сегодня хорошая погода!");
        str5.replace(8, 15, "Хорошеечная");
        System.out.println(str5);

        StringBuffer str6 = new StringBuffer("Всем привет!");
        System.out.println("Диапазон обозначения символов: " + str6.substring(0,5));

        // StringBuilder - немного эффективнее

        StringBuilder cats = new StringBuilder("Котик");
        System.out.println(cat);
        
    }

}
