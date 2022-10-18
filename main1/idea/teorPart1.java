package com.main1.idea;// идет пакет внутри которого мы будем работать

public class teorPart1 {
    public static void main(String[] args) // основной метод джава, является точкой входа  любой программы, синтаксис не меняется, менять модем можем только имя входного аругмента string[]
    {

        byte a = -8;
        byte b = 0;
        byte c = 82;

        System.out.println("байтово значение а: " + a);
        System.out.println("байтово значение b: " + b);
        System.out.println("байтово значение c: " + c);

        System.out.println("ffff"); // cmd + option + L выравнивание соответвенно табуляции

        // тип short применяется также редко, в основном для экономии Оперативной памяти

        short d = 255;
        System.out.println("Короткое значение d: " + d); // запятая не работает для вывода нескольких переменных, только +
        System.out.println("d" + a + "c");

        int e = 453;
        System.out.println("Интовое значение е: " + e);

        String[] strings = new String[126];
        int arrayLenghts = strings.length;
        System.out.println("Длина массива: " + arrayLenghts);

        long f = 9898989898989898L; //используется для работы с очень большими числами L in the end
        System.out.println("Длинное значение f: " + f);

        // основные математические операции
        byte x = (byte) (a + b + c);
        System.out.println("Сумма байтов: " + x);

        byte x1 = (byte) (a + b + c);
        System.out.println("разность байтов: " + x1);

        byte x2 = (byte) (a * b * c);
        System.out.println("произведение байтов: " + x2);

        byte x3 = (byte) (a / c);
        System.out.println("частное байтов: " + x3);

        byte x4 = (byte) (a % c);
        System.out.println("остаток от деления а и с байтов: " + x4);

        byte x5 = (byte) (Math.abs(a));
        System.out.println("мудль числа а байтов: " + x5);

        byte x6 = (byte) (Math.pow(a, 2));
        System.out.println("число " + a + "в степени 2 равно" + x6);

        System.out.println("Результат операции сравнения " + (a == b));

        int n  = 90;
        n = -n;
        System.out.println("Результат после первого минуса " + n);
        n = -n;
        System.out.println("Результат после второго минуса");

        // инкремент дикремент
        n++;
        System.out.println("Итоговые рузультат инкремента " + n);
        n--;
        System.out.println("итоговый результат дикремент " + n);

        // вещественные числа
        float test1 = 12.5f;
        float test2 = (float) 901.54;
        double test3 = 17.9898989989898;
        System.out.println("Полученные значения: " + test1 + " " + test2 + " " +  test3);

        boolean test4 = true;
        boolean test5 = false;

        System.out.println("Полученные значения: " + test4 + " " + test5);

        char symbol = 1087;
        // http://foxtools.ru/Unicode
        char symbol2 = 'п';
        char symbol3 = '\u043F';

        System.out.println(symbol );

        // Сложные объекты

        Cat cotik = new Cat();
        cotik.number = 1;
        cotik.sound = 1;
        cotik.onoff = false;

        System.out.println("Номер котика: " + cotik.number + "\nКотик мурлыкает или нет " + cotik.sound + "\n" +
                "Котик спит? " + cotik.onoff);

        Cat cotik1 = new Cat();
        Cat cotik2 = new Cat();
        cotik1 = cotik2; // ссылки

        System.gc(); // мусорщик, объект может подлежать утилизации в двух случаях
        // 1) переменная ссылочного типа, установлена в положении 0, подлежит утилизации, только если на
        // него нет других ссылок
        // 2) если переменная ссылочнеого типа, создана для ссылки на другой объект,
        // если на него нет других ссылок, подлежит утилизации
        // 3) объекты, созданные в локальном методе, подлежат утилизации, когда метод завершает работы,
        // если они не экспортируются из этого метода
        // 4) объекты, которые ссылаются друг на друга, подлежат утилизации,
        // если один из них недоступен никакому живому потоку


        // работа со string

        String str1 = "Всем привет!";
        String str2 = new String();
        String str3 = new String(new char[] {'H', 'e', 'l', 'l'});
        String str4 = new String(new char[] {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'}, 0, 3);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);

        //метод нахождения длины строки

        /*Scanner in = new Scanner(System.in); // ввод с клавиатуры
        System.out.println("Введите строку: ");
        String str5 = in.nextLine();
        System.out.println("Длина строки: " + str5.length());*/

        //nextLine - считывает всю строку
        //next - считывает введенную строку до первого пробела
        //nextInt - считывает число int
        //nextDouble - считывает число double
        //и так далее по всем типам до short

        // Метод преобразования массива символов в строку
        System.out.println(str3.toCharArray());
        //Символьное сравнение
        String str6 = "";
        if (str6.length() == 0)
            System.out.println("Пустая строка");
        else
            System.out.println("Строка не пустая");

        String str7 = "22";
        if (str7.isEmpty())
            System.out.println("Пустая строка");
        else
            System.out.println("Строка не пустая");

        // присваивание строке значение null
        String str8 = "hfkjehwfjkekf";
        if (str8 == null)
            System.out.println("В строке только null");
        else
            System.out.println("В строке не null");

        // конкетенация (метод объедениня строк
        String str9 = "Я люблю Москву! ";
        str9 = str9.concat("А я очень люблю Санкт-Петербург");
        System.out.println(str9);

        char[] str10 = new char[] {'М', 'о', 'с', 'к', 'в', 'а'};
        Integer test10 = Integer.valueOf("1B", 16);
        System.out.println("Преобразованная строка: " + String.valueOf(str10));
        System.out.println("Значение из 16 в 10: " + test10);

        String str11 = String.join(" ", str1, str9); // первый аргумент - разделитель между указанными строками
        System.out.println("Объединенная строка: " + str11);

        // Метод сравнения двух строк
        System.out.println(str1.compareTo(str9)); // если число положительное значит строка больше
        // Если отрицательное значит строка меньше

        System.out.println("Первые символ по индексу 0: " + str9.charAt(0));

        String str12 = "Всем привет!";
        char[] str13 = new char[10];

        try{
            str12.getChars(0, 10, str13, 0);
            System.out.println("Итоговое (скопированное) значение: " + str13); // здесь будет выводить место в памяти
            System.out.println(str13);
        }catch(Exception exception){
        System.out.println("Исключение");
        }

        //Метод сравнения строки с регистром

        System.out.println("Сравнение строк: " +  str1.equals(str9));
        String str14 = "Всем привет!";
        System.out.println("Сравнение номер 2: " + str1.equals(str14)); // если мы ссылаемся на какой либо объект,
        // то значение False, так как знчения в памяьи будут разные

        // Сравнение строк без учета регистра
        System.out.println("Результат сравнения строк нлмер 3: " + str1.equalsIgnoreCase(str14));
        System.out.println("Результат сравнения строк нлмер 3: " + str1.equalsIgnoreCase(str8));

        // Метод сравнения подстрок в строках
        String str15 = new String("Сегодня прохладно!");
        String str16 = new String("прохладно!");
        String str17 = new String("прОхлАднО!");
        System.out.println("Подстрока найдена?");
        System.out.println(str15.regionMatches(true, 8, str16, 0, 10));
        System.out.println(str15.regionMatches(true, 8, str17, 0, 10));
        System.out.println(str15.regionMatches(false, 8, str17, 0, 10));

        // индекс первого вхождения подстроки в строку
        int indexof = str15.indexOf('п');
        System.out.println("Значение индекса 'п' в строке str15: " + indexof);

        // Метод нахождение индекса последнего вхождения подстроки в строку

        int indexof1 = str15.lastIndexOf('о');
        System.out.println("Значение индекса 'о' в строке str15: " + indexof1);
        int indexof2 = str15.lastIndexOf('o', 4); // поиск букв о, до индекса 4
        System.out.println("Значение индкса 'о' в строке str15, до 4 элемента: " + indexof2);

        // нахождение подстроки
        int indexof3 = str15.lastIndexOf(str16);
        System.out.println("Первый символ подстроки str15в строке str14: " + indexof3);

        // метод определения, является подстрока началом строки, возвращает true or false
        System.out.println("Строка начинается с подстроки? " + str15.startsWith(str16));
        System.out.println("Строка начинается с подстроки? " + str15.startsWith("Сегодня"));

        // метод определения, является подстрока концом строки, возвращает true or false
        System.out.println("Строка начинается с подстроки? " + str15.endsWith(str16));
        System.out.println("Строка начинается с подстроки? " + str15.endsWith("Сегодня"));

        // Метод замены replace

        String str18 = new String("Сегодня прохладно. хочу домой!").replace(".", "!");
        System.out.println(str18);

        // замена первого попавшегося слова

        String str19 = new String("Сегодня прохладно. Сегодня хочу домой!").replaceFirst("Сегодня", "Затвра");
        System.out.println(str19);

        // Метод удаления начальных и конечных пробелов

        String str20 = new String("     Сегодня прохладно. хочу домой!    ");
        System.out.println("Оригинал строки: " + str20);
        System.out.println("Итоговая строка: " + str20.trim());

        // Метод возвращения подстроки, начиная с определенного индекса до конца ( или до определенного индекса)

        System.out.println("Полученная подстрока: " + str15.substring(3, 10));

        // Метод перевода всех символов в нижний регистр
        System.out.println("Подстрока с изменненым регистром: " + str15.toLowerCase() + "\n" + str15.toUpperCase());



















    }
}
