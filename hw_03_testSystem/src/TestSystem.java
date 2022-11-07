import java.util.Scanner;
import java.lang.Integer;

public class TestSystem {
    public static final String[] QUESTION = {"Какое животное обитает только в Китае", "Чем питаются колибри", "Как называются молодые рога марала, изюбря и пятнистого оленя"};
    public static final String[][] ANSWER = {
            {"Коала", "Верблюд", "Панда"},
            {"Нектаром и мелкими насекомыми", "Мелкой рыбой", "Семенами трав"},
            {"Пуанты", "Пенаты", "Панты"}
    };
    public static final int[][] TRUE_ANSWER = {{0, 0, 1}, {1, 0, 0}, {0, 0, 1}};

    public static void main(String[] args) {

        int[][] personAnswer = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        String inputAnswer;
        int k = 0;
        int cntTrueAnswer = 0;
        Scanner inputStr = new Scanner(System.in);
        System.out.println("Здравствуйте.\nВам будет задано три вопроса, на каждый из которых есть три варанта ответа. \n" +
                "Вам необходимо выбрать только один вариант ответа.\nДля ответа поставьте цифру с номером ответа (1-3).\n");
        for (int i = 0; i < QUESTION.length; i++) {
            System.out.println("Вопрос " + (int) (i + 1) + ": " + QUESTION[i] + "?");
            for (int j = 0; j < ANSWER.length; j++) {
                System.out.println("  " + (int) (j + 1) + ") " + ANSWER[i][j]);
            }
            System.out.println("Введите ваш ответ:");
            inputAnswer = inputStr.nextLine();
            boolean trueAns = false;
            while (!trueAns) {
                try {
                    Integer answerToInt = Integer.valueOf(inputAnswer);
                    System.out.println("Ваш ответ: " + answerToInt);
                    if (answerToInt == 1 || answerToInt == 2 || answerToInt == 3) {
                        trueAns = true;
                        k = answerToInt - 1;
                    } else {
                        System.err.println("Неправильный номер ответа!\nВведите номер ответа 1, 2 или 3");
                        inputAnswer = inputStr.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Неправильный формат ответа!\nВведите числом номер ответа 1, 2 или 3");
                    inputAnswer = inputStr.nextLine();
                }
                if (trueAns) {
                    personAnswer[i][k] = 1;
                    if (personAnswer[i][k] == TRUE_ANSWER[i][k]) {
                        System.out.println("Верно!\n");
                        cntTrueAnswer++;
                    } else System.out.println("Не верно!\n");
                }
            }
        }
        System.out.println("Количество правильных ответов: " + cntTrueAnswer + " из 3");
    }
}
