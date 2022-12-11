package ru.java.hw4;

public class Main {
    public static void main(String[] args) {
        Question question1 = new Question("Какое животное обитает только в Китае", new String[]{"Коала", "Верблюд", "Панда", "Слон", "Носорог"}, 3);
        Question question2 = new Question("Чем питаются колибри", new String[]{"Нектаром и мелкими насекомыми", "Мелкой рыбой", "Семенами трав", "Лягушками"}, 1);
        Question question3 = new Question("Как называются молодые рога марала, изюбря и пятнистого оленя", new String[]{"Пуанты", "Пенаты", "Панты"}, 3);
        Question question4 = new Question("Какая наука изучает ископаемых животных", new String[]{"Сейсмология", "Орнитология", "Психология", "Палеонтология", "Геология", "География"}, 4);
        RunTest run = new RunTest(new Question[]{question1, question2, question3, question4});
        run.runTest();
    }
}
