package com.main9.idea;

import java.util.Scanner;

public final class Worker extends Student {
    private static int salary;

    public static int setSalary() {
        Scanner in = new Scanner(System.in);
        System.out.println("Задайте возраст (только в числовом формате): ");
        salary = in.nextInt();
        return salary;
    }

    public static void getSalary() {
        System.out.println(salary);
    }

    public static void main(String[] args) {
        System.out.println("Имя студента: ");
        getName();
        System.out.println("Возвраст студента: ");
        getAge();
        System.out.println("Зарплата студента: ");
        getSalary();
    }
}
