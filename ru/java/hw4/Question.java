package ru.java.hw4;

import java.util.Scanner;

class Question {
    private String question;
    private String[] answer;
    private int trueAnswer;

    public boolean errAnswer = false;

    public Question(String question, String[] answer, int trueAnswer) {
        this.question = question;
        this.answer = answer;
        this.trueAnswer = trueAnswer;
    }

    public int askQuestion(int number) {
        if (!errAnswer) printQuestion(number);
        int inputAnswer;
        Scanner inputStr = new Scanner(System.in);
        System.out.println("Введите ваш ответ:");
        inputAnswer = getAnswer(inputStr);
        if (inputAnswer != -1) {
            System.out.println("Ваш ответ: " + inputAnswer);
            return inputAnswer;
        } else {
            System.err.println("К ответу принимаются только цифры от 1 до " + answer.length);
            return -1;
        }
    }

    private void printQuestion(int i) {
        System.out.println("Вопрос " + (i + 1) + ": " + this.question);
        for (int j = 0; j < this.answer.length; j++) {
            System.out.println("  " + (j + 1) + ") " + this.answer[j]);
        }
    }

    private int getAnswer(Scanner inputStr) {
        if (inputStr.hasNextInt()) {
            int n = inputStr.nextInt();
            if (n > 0 && n <= this.answer.length) {
                errAnswer = false;
                return n;
            } else {
                errAnswer = true;
                return -1;
            }
        } else {
            errAnswer = true;
            return -1;
        }
    }

    public int checkAnswer(int persAnswer) {
        if (persAnswer == this.trueAnswer) {
            System.out.println("Верно!\n");
            return 1;

        } else {
            System.out.println("Не верно!\n");
            return 0;
        }
    }
}
