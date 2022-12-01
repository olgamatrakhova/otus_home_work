/*Даны 2 числа. Реализуйте метод, который вычисляет все чётные числа между переданными числами и выводит из них среднее значение.
Если получается дробное значение метод должен округлить число до целого в меньшую сторону.
Если хотя бы одно число из переданных является отрицательным метод должен вернуть 0.
Первое переданное число должно быть всегда меньше второго иначе метод должен вернуть 0.*/
package ru.java.trainer;

import static java.lang.Math.round;

public class MathUtilAvg {
    public static int getPrimeNumbersSum(byte lowEdge, byte highEdge) {
        int cnt = 0;
        int sum = 0;
        int result = 0;
        if (lowEdge < highEdge) {
            if (lowEdge >= 0 && highEdge > 0) {
                for (int i = lowEdge; i <= highEdge; i++) {
                    if (i % 2 == 0) {
                        cnt++;
                        sum = sum + i;
                    }
                }
                result = sum / cnt;
            }
        }
        return round(result);
    }

    private MathUtilAvg() {

    }

    public static void main(String[] args) {
        System.out.println("avg четных чисел у ряда с 1 до 10 должен равняться 6 - "
                + MathUtilAvg.getPrimeNumbersSum((byte) 1, (byte) 10.5));
    }

}