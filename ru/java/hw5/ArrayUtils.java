package ru.java.hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArrayUtils {
    private int[] array;
    private int cntElement;
    private int minElement;
    private int maxElement;

    public ArrayUtils(int[] array, int cntElement, int minElement, int maxElement) {
        this.array = array;
        this.cntElement = cntElement;
        this.minElement = minElement;
        this.maxElement = maxElement;
    }

    private static int[] addElement(int[] array, int elementToAdd) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) newArray[i] = array[i];
        newArray[newArray.length - 1] = elementToAdd;
        return newArray;
    }

    public int[] createArray() {
        for (int i = 1; i <= this.cntElement; i++)
            this.array = addElement(this.array, (int) (Math.random() * (this.maxElement - this.minElement)) + this.minElement);
        return this.array;
    }
    public int[] getArray(){
        return this.array;
    }

    public List<Integer> getListArray(int[] intArray) {
        List<Integer> newList = new ArrayList<Integer>(intArray.length);
        for (int i : intArray) newList.add(i);
        return newList;
    }

    public long getTimeSort(long timeStart) {
        return System.currentTimeMillis() - timeStart;

    }
}