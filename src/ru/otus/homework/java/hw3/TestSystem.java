package ru.otus.homework.java.hw3;

import java.util.Scanner;
import java.lang.Integer;

public class TestSystem {
    public static final String[][][] QUESTION = {
            {
                    {"Какое животное обитает только в Китае"},
                    {"Коала", "Верблюд", "Панда", "Слон", "Носорог"},
                    {"3"}
            },
            {
                    {"Чем питаются колибри"},
                    {"Нектаром и мелкими насекомыми", "Мелкой рыбой", "Семенами трав", "Лягушками"},
                    {"1"}
            },
            {
                    {"Как называются молодые рога марала, изюбря и пятнистого оленя"},
                    {"Пуанты", "Пенаты", "Панты"},
                    {"3"}
            },
            {
                    {"Какая наука изучает ископаемых животных"},
                    {"Сейсмология", "Орнитология", "Психология", "Палеонтология", "Геология", "География"},
                    {"4"}
            }
    };
    public static String INPUT_NO_NUMBER_ERROR = "К ответу принимаются только цифры!";
    public static String INPUT_ANSWER_MSG = "Введите ваш ответ:";
    public static String INPUT_NUMBER_ANSWER_MSG = "Введите цифту от 1 до ";
    public static String INPUT_NUMBER_ERROR_MSG = "Ответа с таким номером нет!";
    public static String CNT_TRUE_ANSWER_MSG = "Количество правильных ответов: ";
    public static String HELLO_MSG = """
            Здравствуйте.
            Перед Вами вопросы, на которые есть только один вариант ответа.
            Чтобы ответить введите цифру соответсвующую номеру выбронного вами ответа и нажмите Enter.
            """;
    public static String TRUE_MSG = "Верно!";
    public static String FALSE_MSG = "Не верно!";

    public static void main(String[] args) {
        String inputAnswer;
        int cntTrueAnswer = 0;
        Scanner inputStr = new Scanner(System.in);
        System.out.println(HELLO_MSG);
        for (int i = 0; i < QUESTION.length; i++) {
            System.out.println("Вопрос " + (i + 1) + ": " + QUESTION[i][0][0] + "?");
            for (int j = 0; j < QUESTION[i][1].length; j++) {
                System.out.println("  " + (j + 1) + ") " + QUESTION[i][1][j]);
            }
            System.out.println(INPUT_ANSWER_MSG);
            inputAnswer = inputStr.nextLine();
            boolean trueAns = false;
            while (!trueAns) {
                try {
                    System.out.println("Ваш ответ: " + inputAnswer);
                    if (Integer.parseInt(inputAnswer) != 0 && Integer.parseInt(inputAnswer) <= QUESTION[i][1].length) {
                        trueAns = true;
                        if (QUESTION[i][2][0].equals(inputAnswer)) {
                            System.out.println(TRUE_MSG + "\n");
                            cntTrueAnswer++;
                        } else System.out.println(FALSE_MSG + "\n");

                    } else {
                        System.err.println(INPUT_NUMBER_ERROR_MSG + "\n" + INPUT_NUMBER_ANSWER_MSG + QUESTION[i][1].length + ".\n" + INPUT_ANSWER_MSG);
                        inputAnswer = inputStr.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.err.println(INPUT_NO_NUMBER_ERROR + "\n" + INPUT_NUMBER_ANSWER_MSG + QUESTION[i][1].length + ".\n" + INPUT_ANSWER_MSG);
                    inputAnswer = inputStr.nextLine();
                }
            }
        }
        System.out.println(CNT_TRUE_ANSWER_MSG + cntTrueAnswer + " из " + QUESTION.length);
    }
}
