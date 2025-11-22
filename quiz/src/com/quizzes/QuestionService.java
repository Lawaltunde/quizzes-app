package com.quizzes;

import java.util.Arrays;

public class QuestionService {
    private QuestionDAO questionDAO;

    {
        questionDAO = new QuestionDAO();
    }

    public void displayQuestions(){
        Question[] questions = questionDAO.getAllQuestions();
        for(Question q : questions){
            System.out.println("-------------------------");
            System.out.println("Question ID: " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println("Options: ");
            System.out.println(Arrays.toString(q.getOptions()));
        }
    }

    public Question[] getAllQuestions(){
        return questionDAO.getAllQuestions();
    }
}
