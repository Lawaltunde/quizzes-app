package com.quizzes;

public class QuestionDAO {
    private static Question[] questions = new Question[10];

    static {
        questions = new Question[]{
                new Question(1, "What is the capital of France?", new String[]{"A. Paris", "B. London", "C. Berlin", "D. Madrid"}, "A. Paris"),
                new Question(2, "Which planet is known as the Red Planet?", new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"}, "B. Mars"),
                new Question(3, "Who wrote 'Romeo and Juliet'?", new String[]{"A. Charles Dickens", "B. William Shakespeare", "C. Mark Twain", "D. Jane Austen"}, "B. William Shakespeare"),
                new Question(4, "What is the largest ocean on Earth?", new String[]{"A. Atlantic Ocean", "B. Indian Ocean", "C. Arctic Ocean", "D. Pacific Ocean"}, "D. Pacific Ocean"),
                new Question(5, "What is the chemical symbol for gold?", new String[]{"A. Au", "B. Ag", "C. Fe", "D. Hg"}, "A. Au")
        };
    };


    public Question[] getAllQuestions() {
        return questions;
    }
}
