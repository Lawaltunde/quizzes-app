package com.quizzes;

import java.util.Arrays;
import java.util.Scanner;

public class QuestionService {
    private QuestionDAO questionDAO;
    private String[] answers;

    {
        questionDAO = new QuestionDAO();
        answers = new String[questionDAO.getAllQuestions().length];
    }

    public void displayQuestions(){
        Question[] questions = questionDAO.getAllQuestions();
        int index = 0, correctAnswers = 0;
        for(Question q : questions){
            System.out.println("-------------------------");
            System.out.println("Question: " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println("Options:" + Arrays.toString(q.getOptions()));
            System.out.println("Your Answer: ");
            Scanner sc = new Scanner(System.in);
            String userAnswer = sc.nextLine();
            answers[index] = userAnswer;
            if (answers[index].equals(questions[index].getAnswer())){
                correctAnswers++;
            }
            index++;
        }

        System.out.println("You got " + correctAnswers + " out of " + questions.length + " correct!");
    }

    public void printAnswer()
    {
        System.out.println(Arrays.toString(answers));
    }

    public Question[] getAllQuestions(){
        return questionDAO.getAllQuestions();
    }
}
