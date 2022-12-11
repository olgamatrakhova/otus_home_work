package ru.otus.homework.java.hw5;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
       /*int[][] data = {
                {},
                {1},
                {5, 4, 3, 2},
                {2, 0, 12, 56, 27},
                {36, -8, 4432, 123, 85, 4, 1, 782, 0, 9, 87},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " => ");
            SortSelection.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " => ");
            BubbleSorter.sort(arr);
            System.out.println(Arrays.toString(arr));
        }*/

        long startTime = 0;
        long endTime = 0;
        ArrayUtils myArray = new ArrayUtils(new int[]{0}, 10000, -7496, 9442);
        int[] randomArray = myArray.createArray();
        int[] copyRandomArray1 = Arrays.copyOf(randomArray, randomArray.length);
        int[] copyRandomArray2 = Arrays.copyOf(randomArray, randomArray.length);

        System.out.print(Arrays.toString(randomArray) + " => " + "\n");
        startTime = System.currentTimeMillis();
        SortSelection.sort(randomArray);
        endTime = myArray.getTimeSort(startTime);
        //System.out.println(Arrays.toString(randomArray));
        System.out.println("Время сортировки выбором " + endTime + " миллиcекунд");

        //System.out.print(Arrays.toString(copyRandomArray1) + " => " + "\n");
        startTime = System.currentTimeMillis();
        BubbleSorter.sort(copyRandomArray1);
        endTime = myArray.getTimeSort(startTime);
        //System.out.println(Arrays.toString(copyRandomArray1));
        System.out.println("Время сортировки пузырьком " + endTime + " миллиcекунд");

        startTime = System.currentTimeMillis();
        Collections.sort(myArray.getListArray(copyRandomArray2));
        endTime = myArray.getTimeSort(startTime);
        System.out.println("Время сортировки коллекции " + endTime + " миллиcекунд");
    }
}