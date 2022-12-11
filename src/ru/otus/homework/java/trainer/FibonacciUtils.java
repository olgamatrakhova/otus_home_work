/*Дано число. Реализуйте метод, который вычисляет числа Фибоначчи (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...), находит их сумму и возвращает её в виде строки.
 Формула расчёта чисел: Fn = Fn-1 + Fn-2 - где n переданное в метод число.
 Например для n=5 сумма будет равна 7, а для n=2 сумма будет равна 1.
 сли в метод передано отрицательное число - он должен вернуть 0.*/

package ru.otus.homework.java.trainer;

import java.math.BigInteger;

public class FibonacciUtils {
    public static String getFibonacciSum(byte limit) {
        if (limit < 0) return "0";

        BigInteger[] arrayFibonacci = new BigInteger[limit];

        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 0; i < limit; i++) {
            if (i == 0) arrayFibonacci[0] = BigInteger.valueOf(0);
            else if (i == 1) arrayFibonacci[1] = BigInteger.valueOf(1);
            else
                arrayFibonacci[i] = arrayFibonacci[i - 1].add(arrayFibonacci[i - 2]);
            sum = sum.add(arrayFibonacci[i]);
        }
        return String.valueOf(sum);
    }


    private FibonacciUtils() {

    }

    public static void main(String[] args) {
        System.out.println("Сумма чисел фибоначчи до 5 должна равняться 7 - " + FibonacciUtils.getFibonacciSum((byte) 127));
    }
}