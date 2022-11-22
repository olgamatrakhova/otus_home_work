/*Дана строка, состоящая из слов, разделенных пробелами.
Необходимо реализовать метод, который возвращает строку, слова в которой записаны в обратном порядке.
Например, для строки "test abc" необходимо получить строку "abc test".*/

package ru.java.trainer;

public class WordUtils {
    public static String reverseChar(String inputText) {
        String outputText = "";
        for (int i = inputText.length() - 1; i >= 0; i--) {
            outputText = outputText + inputText.charAt(i);
        }
        return outputText;
    }

    public static String reverseWords(String inputText) {
        String outputText = "";
        int end = inputText.length();
        for (int i = inputText.length() - 1; i >= 0; i--) {
            if (inputText.charAt(i) == ' ') {
                outputText = outputText + inputText.substring(i+1, end)+" ";
                end = i;
            }
            if (i ==0){
                outputText = outputText+ inputText.substring(i,end);
            }
        }
        return outputText;
    }

    private WordUtils() {

    }

    public static void main(String[] args) {
        System.out.println("Ввод пустой строки - " + WordUtils.reverseWords(""));
        System.out.println("Ввод одного слова - " + WordUtils.reverseWords("word"));
        System.out.println("Ввод двух слов - " + WordUtils.reverseWords("два слова"));
        System.out.println("Ввод трех слов - " + WordUtils.reverseWords("три новых слова"));
    }
}