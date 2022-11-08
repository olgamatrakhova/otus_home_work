import java.util.Scanner;
import java.lang.Integer;

public class TestSystem {
    public static final String[] QUESTION = {"Какое животное обитает только в Китае",
            "Чем питаются колибри",
            "Как называются молодые рога марала, изюбря и пятнистого оленя",
            "Какая наука изучает ископаемых животных"
    };
    public static final String[][] ANSWER = {
            {"Коала", "Верблюд", "Панда", "Слон", "Носорог"},
            {"Нектаром и мелкими насекомыми", "Мелкой рыбой", "Семенами трав", "Лягушками"},
            {"Пуанты", "Пенаты", "Панты"},
            {"Сейсмология", "Орнитология", "Психология", "Палеонтология", "Геология", "География"}
    };
    public static final int[][] TRUE_ANSWER = {{0, 0, 1, 0, 0}, {1, 0, 0, 0}, {0, 0, 1}, {0, 0, 0, 1, 0, 0}};

    public static void main(String[] args) {
        int[][] personAnswer = {{0, 0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        String inputAnswer;
        int cntTrueAnswer = 0;
        int answerToInt = 0;
        Scanner inputStr = new Scanner(System.in);
        System.out.println("""
                Здравствуйте.
                Перед Вами вопросы, на которые есть только один вариант ответа.
                Чтобы ответить введите цифру соответсвующую номеру выбронного вами ответа и нажмите Enter.
                """);
        for (int i = 0; i < QUESTION.length; i++) {
            System.out.println("Вопрос " + (i + 1) + ": " + QUESTION[i] + "?");
            for (int j = 0; j < ANSWER[i].length; j++) {
                System.out.println("  " + (j + 1) + ") " + ANSWER[i][j]);
            }
            System.out.println("Введите ваш ответ:");
            inputAnswer = inputStr.nextLine();
            boolean trueAns = false;
            while (!trueAns) {
                try {
                    answerToInt = Integer.parseInt(inputAnswer);

                    System.out.println("Ваш ответ: " + answerToInt);
                    if (answerToInt != 0 && answerToInt <= ANSWER[i].length) {
                        trueAns = true;
                        personAnswer[i][answerToInt - 1] = 1;

                    } else {
                        System.err.println("Ответа с таким номером нет!\nВведите цифту от 1 до " + ANSWER[i].length + ".\nВведите ваш ответ:");

                        inputAnswer = inputStr.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("К ответу принимаются только цифры!\nВведите цифту от 1 до " + ANSWER[i].length + ".\nВведите ваш ответ:");
                    inputAnswer = inputStr.nextLine();
                }
            }
            if (personAnswer[i][answerToInt - 1] == TRUE_ANSWER[i][answerToInt - 1]) {
                System.out.println("Верно!\n");
                cntTrueAnswer++;
            } else System.out.println("Не верно!\n");
        }
        System.out.println("Количество правильных ответов: " + cntTrueAnswer + " из " + QUESTION.length);
    }
}
