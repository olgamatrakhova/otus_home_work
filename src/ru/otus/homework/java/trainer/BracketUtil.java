/*Дана строка, состоящая из скобок, а также открывающий и закрывающий символ скобок.
Необходимо реализовать метод, который проверяет что в строке у каждой открывающей скобки есть соответствующая ей закрывающая скобка.
Строка в которой закрывающая скобка идёт впереди открывающей является некорректной. Например (()) - корректная строка, ()) - некорректная строка*/
package ru.otus.homework.java.trainer;

public class BracketUtil {
    public static boolean isCorrectBrackets(String input,
                                            char bracketOpenSymbol,
                                            char bracketCloseSymbol) {
        int cntOpen = 0;
        int cntClose = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == bracketOpenSymbol) cntOpen++;
            if (input.charAt(i) == bracketCloseSymbol) cntClose++;
        }
        if (cntOpen != cntClose)
            return false;
        return true;
    }
    private BracketUtil() {
    }
    public static void main(String[] args) {
        System.out.println("Ввод равного поличества открывающих и закрывающих скобок - "
                + BracketUtil.isCorrectBrackets("{{}}", '{', '}'));
        System.out.println("Ввод неравного поличества открывающих и закрывающих скобок - "
                + BracketUtil.isCorrectBrackets("{{}}}", '{', '}'));
    }
}