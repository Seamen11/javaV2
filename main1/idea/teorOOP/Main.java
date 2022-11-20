package com.main1.idea.teorOOP;

public final class Main {
    public static void main(String[] args) {
        Pi216 obj = new Pi216();
        System.out.println(obj.s);
        obj.s = "Изменение строки";
        System.out.println(obj.s);
        System.out.println(obj.getPI21());
        System.out.println(obj.setPI216("Новая тестовая строка 1!"));
    }
}
