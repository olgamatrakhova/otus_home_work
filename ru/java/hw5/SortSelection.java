package ru.java.hw5;

public class SortSelection {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int posMin = i;
            int minEl = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minEl) {
                    posMin = j;
                    minEl = array[j];
                }
            }
            array[posMin] = array[i];
            array[i] = minEl;
        }
    }

}
