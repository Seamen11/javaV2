package com.main1.idea;

import javax.management.timer.TimerNotification;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class teorPart3massivwAndCicle
{
    public static void main(String[] args)
    {
        // как можно задавать массивы
        int[] Example1 = new int[10];
        int[] Example2 = new int[]{1, 2, 3, 4, 5}; // в данном случае мы возвращаем ссылку на вновь созданный объект
        int[] Example3 = {1, 2, 3, 4, 5};

        // вывод массивов
        System.out.println("Элементы первого массива: " + Arrays.toString(Example1) +
                "\nЭлементы второго массива: " + Arrays.toString(Example2) +
                "\nЭлементы третьего массива: " + Arrays.toString(Example3));

        // изменения значения по индексу
        Example1[0] = 2;
        System.out.println("\n Измененный массив" + Arrays.toString(Example1));

        // массив с клавиатуры
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + " Введимте длину массива: ");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++)
        {
            array[i] = input.nextInt();
        }
        System.out.println("Элементы первого массива, введенного с клавиатурф: " + Arrays.toString(array));

        System.out.println("\n");

        // Другой пример ввода массива с клавиатуры
        System.out.println("Заполните массив: ");
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++)
        {
            mas[i] = input.nextInt();
        }
        System.out.println("Элементы второго массива, введенного с клавиатуры: " + Arrays.toString(mas));


        // Работа с многомерными массивами
        int[][] ArrayPi1 = new int[4][5];
        ArrayPi1[0][0] = 1;   // Обновление значений массива
        System.out.println("\nВывод многомерного массива: " + Arrays.deepToString(ArrayPi1));

        // Другой способ

        int[][] ArrayPi2 = {{1,2,3,4}, {5,6,7,8}, {1,2,3,4}};
        System.out.println("\nМногомерный массив номер 2:" + Arrays.deepToString(ArrayPi2));

        // как сделать красивый вывод двумерного массива
        System.out.println("\n" + ArrayPi2.length + " " + ArrayPi2[0].length);
        for (int i = 0; i < ArrayPi2.length; i++)
        {
            for (int j = 0; j < ArrayPi2[i].length; j++)
            {
                System.out.print("\t" + ArrayPi2[i][j]);  // \t - табуляция
            }
            System.out.println();  // Для визуального формата представления
        }

        // Ввод многомерных массивов с клавиатуры
        int a, b;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество строк массива: ");
        a = in.nextInt();

        System.out.println("Введите колчество столбцов массива: ");
        b = in.nextInt();

        int[][] arr = new int[a][b];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Введите значение массива [" + i + "] [" + j + "]: ");
                arr[i][j] = in.nextInt();
            }

        }
        in.close(); // после ввода целочисленных значений, лучше закрывать наш ввод с клавиатуры,
            // чтобы не было проблем с переносом
        for (int i = 0; i < arr.length;i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }



        // задача перемножения матриц

        int Pi, Pi1, st2;
        System.out.print("ВВЕДИТЕ КОЛИЧЕСТВО СТРОК ПЕРВОЙ МАТРИЦЫ: ");
        Pi = in.nextInt();
        System.out.print("Введите количесвто строк второй матрицы и столбцов первой матрицы: ");
        Pi1 = in.nextInt();
        System.out.print("Введите колчиесвто столбцов второй матрицы: ");
        st2  = in.nextInt();

        int[][] matrix1 = new int[Pi][Pi1];
        int[][] matrix2 = new int[Pi1][st2];
        int[][] matrix3 = new int[Pi][st2];

        for (int i = 0; i < Pi; i ++)
        {
            for (int j = 0; j < Pi1; j++)
            {
                System.out.print("Введите элемент первой матрицы: [" + i + "] [" + j + "]: ");
                matrix2[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < Pi; i++)
        {
            for (int u = 0; u < st2; u++)
            {
                for (int j = 0; j < Pi1; j++)
                {
                    matrix3[i][u] += matrix1[i][j] * matrix2[j][u];
                }
            }
        }
        System.out.println("Результат перемножения двух матрицы: ");
        for (int i = 0; i < Pi; i++)
        {
            for (int j = 0; j < st2; j++)
            {
                System.out.print(matrix3[i][j] + "\t");
            }
            System.out.println();
        }


        // ОСНОВНЫЕ ОПЕРАЦИИ В МАССИВЕ
        // 1 операция - обновление данных в массиве

        int[] array1 = new int[]{10, 13, 18, 123, 313, 329, 567};
        System.out.println("Исходный массив данных: " + Arrays.toString(array1));

        Arrays.fill(array1, 0, 2,5); // невключительно
        for (int i = 0; i < array1.length; i++)
        {
            System.out.println(i + " элемент массива: " + array1[i]);
        }


        // 2 сортировка нашего массива ( в порядке возрастания)
        Arrays.sort(array1); // сортировка по возрастанию
        System.out.println(array1);


        // 3 сортировка по убыванию, особенность, изначально необходимо преобразовать массив Int
        // в Integer, по причине того, стандартные методы сортировки, работают с объектами,
        // а объекты формируются в Integer
        // массив интов в коллекцию

        Integer[] inArray = new Integer[array1.length];
        for (int i = 0; i < array1.length; i++)
        {
            inArray[i] = array1[i];
        }
        Arrays.sort(inArray, Collections.reverseOrder());
        for (int i = 0; i < array1.length; i++)
        {
            System.out.println(i + " элемент массива: " + inArray[i]);
        }

        // работа алгоритма со строками
        String[] arraystring = {"Java", "the", "best"};
        Arrays.sort(arraystring, Comparator.naturalOrder());
        System.out.println(Arrays.toString(arraystring));


        // 3 Копирование массива
        // copyOf - до указанной длины
        int[] newArraya = Arrays.copyOf(array1, 5);
        System.out.println("Наш новый массив: " + Arrays.toString(newArraya));

        // copyOfRange - копирует в заданном диапазоне (неыключительно поселднего элемента)
        int[] newArray2 = Arrays.copyOfRange(array, 1, 5);
        System.out.println("Новый массив данных №2: " + Arrays.toString(newArray2));


        // 4 Поиск индекса элемента в массиве
        int index = Arrays.binarySearch(array1, 13);
        System.out.println("Индекс элемента 13: " + index);

        // работа алгоритма со строками
        String[] strr = new String[]{"hi", "all", "java", "stradat"};
        Arrays.sort(strr);
        int seacrchIndex = Arrays.binarySearch(strr, 0, 4, "stradat");
        System.out.println("Индекс нашего элемента 'stradat' равен: " + seacrchIndex);


        // 5 пузырьеовая сортировка
        Scanner input1 = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int sizee = input1.nextInt();
        int[] arrayss1 = new int[size];
        System.out.print("Введите элеменеты массива (соответсвуеют длине массива): ");
        for (int i = 0; i < size; i++)
        {
            arrayss1[i] = input.nextInt();
        }

        boolean ArraySorted = false; // Флаг который смотрит сортированные ли массив или нет
        int tesst1;
        while(!ArraySorted)
        {
            ArraySorted = true;
            for (int i = 0; i < arrayss1.length - 1; i++) // чтобы не получить ошибку при сравнении
            {
                if (arrayss1[i] > arrayss1[i + 1])
                {
                    ArraySorted = false;
                    tesst1 = arrayss1[i];
                    arrayss1[i] = arrayss1[i + 1];
                    arrayss1[i + 1] = tesst1;
                }
            }
        }
        System.out.println("Отсортированные элементы массива, введенного с клавиатуры: " + Arrays.toString(arrayss1));
        System.out.println("Длина массива arrayss1: " + arrayss1.length);


        // 6 как вывести индекс элемента

        Integer[] inArray1 = new Integer[arrayss1.length];
        for (int i = 0; i < arrayss1.length; i++)
        {
            inArray1[i] = arrayss1[i];
        }
        List<Integer> Arraylist = Arrays.asList(inArray1);
        System.out.println("Индекс элемента 2: " + Arraylist.indexOf(2));


        // 7  Найти максимальный и минимальный элемент массива
        int max = arrayss1[0];
        for(int i = 1; i < arrayss1.length; i++)
        {
            if (arrayss1[i] > max)
            {
                max = arrayss1[i];
            }
        }
        System.out.println("Максимальный элемент массива arrayss1: " + max);


        // другой способ поиска max

        int max1 = 0;
        for(int i = 1; i < arrayss1.length; i++)
        {
            max1 = Math.max(max1, arrayss1[i]);
        }
        System.out.println("Максимальный элемент массива №2: " + max1);


        // Минимальный элемент массива

        int min = MAX_VALUE;
        for(int i = 1; i < arrayss1.length; i++)
        {
            if (arrayss1[i] < min)
            {
                min = arrayss1[i];
            }
        }
        System.out.println("Минимальный элемент массива №2: " + min);


        // Второй способ нахлждения минимального элемента массива

        int min1 = MAX_VALUE;
        for(int i = 1; i < arrayss1.length; i++)
        {
            min1 = Math.min(min1, arrayss1[i]);
        }
        System.out.println("Минимальный элемент массива №2: " + min);


        // 8 Сумма элементов массива

        int summ = 0;
        for (int element: arrayss1)
        {
            summ += element;
        }
        System.out.println("Сумма элементов массива: " + summ);


        // 9 Вывод четных и нечетных элементов массива

        System.out.println("Четные элементы массива arrayss1: ");
        for(int j : arrayss1)
        {
            if (j % 2 == 0)
            {
                System.out.println(j + "\t");
            }
        }

        // Вывод нечетных элементов массива

        System.out.println("\nНечетные элементы массива arrayss1: ");
        for(int j : arrayss1)
        {
            if (j % 2 != 0)
            {
                System.out.println(j + "\t");
            }
        }
    }
}
