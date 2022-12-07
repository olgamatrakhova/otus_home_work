/*Дано число. Реализуйте метод, который принимает число и возвращает в виде строки все чётные числа от 1 до переданного числа включительно.
Если передано отрицательное число метод должен вернуть пустую строку.
Если передан 0, то метод должен вернуть 1. Пример вывода для числа 5: 1245*/
package ru.java.trainer;

public class MathUtilArray {

    public static String getEvenNumbersUpTo(byte number) {
        String result = "1";
        if (number < 0) return "";
        if (number == 0) return result;
        for (int i = 1; i < number; i++) {
            if (i % 2 == 0) result += i;
        }
        result += number;
        return result;
    }

    private MathUtilArray() {

    }

    public static void main(String[] args) {
        System.out.println("Если передать число 5, то метод должен вернуть строку 1245 - " + MathUtilArray.getEvenNumbersUpTo((byte) 9));
    }
}