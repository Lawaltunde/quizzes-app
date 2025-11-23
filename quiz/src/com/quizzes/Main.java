package com.quizzes;

public class Main {
    public static void main(String[] args) {
        Question question = new Question("What is 2+2?", new String[]{"A. 3", "B. 4", "C. 5", "D. 6"}, "4");
        QuestionService questionService = new QuestionService();
        questionService.addQues(question);
        questionService.displayQuestions();
        questionService.printAnswer();
    }
}