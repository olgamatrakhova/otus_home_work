package ru.otus.homework.java.hw3;

public class AddElementToArray {
    public static Integer[] addElement(Integer[] myArray, int elementToAdd) {
        Integer[] newArray = new Integer[myArray.length + 1];

        for (int i = 0; i < myArray.length; i++) {
            newArray[i] = myArray[i];
        }
        newArray[newArray.length - 1] = elementToAdd;
        return newArray;
    }

    public static String[] addElement(String[] myArray, String elementToAdd) {
        String[] newArray = new String[myArray.length + 1];

        for (int i = 0; i < myArray.length; i++) {
            newArray[i] = myArray[i];
        }

        newArray[newArray.length - 1] = elementToAdd;
        return newArray;
    }

    public static void main(String[] args) {
        System.out.println("__________Числа_________");
        Integer[] arrayInt = {0};
        System.out.println("Изначальная длина массива " + arrayInt.length);
        System.out.println("Изначальный массив");
        for (Integer value : arrayInt) {
            System.out.println(value);
        }
        for (int i = 1; i <= 30; i++) {
            arrayInt = addElement(arrayInt, i);
            //System.out.println("Длина массива "+arrayInt.length);

        }
        System.out.println("Новая длина массива " + arrayInt.length);
        System.out.println("Массив который получился");
        for (Integer integer : arrayInt) {
            System.out.println(integer);
        }
        System.out.println("__________Строки__________");
        String[] arrayStr = {"a"};
        System.out.println("Изначальная длина массива " + arrayStr.length);
        System.out.println("Изначальный массив");
        for (String value : arrayStr) {
            System.out.println(value);
        }
        for (char i = 'b'; i <= 'z'; i++) {
            arrayStr = addElement(arrayStr, String.valueOf(i));
            //System.out.println("Длина массива "+arrayStr.length);
        }
        System.out.println("Новая длина массива " + arrayStr.length);
        System.out.println("Массив который получился");
        for (String s : arrayStr) {
            System.out.println(s);
        }
    }
}
