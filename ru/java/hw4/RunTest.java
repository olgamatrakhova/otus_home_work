package ru.java.hw4;


public class RunTest {
    private final Question[] questions;

    public RunTest(Question[] questions) {
        this.questions = questions;
    }

    public void runTest() {
        int cntTrueAnswer = 0;
        for (int i = 0; i < questions.length; i++) {
            int res = questions[i].askQuestion(i);
            while (res == -1)
                res = questions[i].askQuestion(i);
            if (res != -1) cntTrueAnswer += questions[i].checkAnswer(res);
        }
        getMainResult(cntTrueAnswer, questions.length);
    }

    public void getMainResult(int res, int cntQuest) {
        System.out.println("Количество правильных ответов: " + res + " из " + cntQuest);
    }
}
