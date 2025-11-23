package com.quizzes;

public class QuestionDAO {
    private static Question[] questions;

    static {
        questions = new Question[]{
                new Question(1, "What is the capital of France?", new String[]{"A. Paris", "B. London", "C. Berlin", "D. Madrid"}, "Paris"),
                new Question(2, "Which planet is known as the Red Planet?", new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"}, "Mars"),
                new Question(3, "Who wrote 'Romeo and Juliet'?", new String[]{"A. Charles Dickens", "B. William Shakespeare", "C. Mark Twain", "D. Jane Austen"}, "William Shakespeare"),
                new Question(4, "What is the largest ocean on Earth?", new String[]{"A. Atlantic Ocean", "B. Indian Ocean", "C. Arctic Ocean", "D. Pacific Ocean"}, "Pacific Ocean"),
                new Question(5, "What is the chemical symbol for gold?", new String[]{"A. Au", "B. Ag", "C. Fe", "D. Hg"}, "Au")
        };
    }


    public void addQuestion(Question question) {
        if (questions[0] == null) {
            questions[0] = question;
            return;
        }
        int nextSlot = 0;
        for (Question q : questions) {
            if (q == null) {
                questions[nextSlot] = question;
                return;
            }
            nextSlot++;
        }
        if (nextSlot == questions.length) {
            Question[] newQuestions = new Question[questions.length + 1];
            int count = 0;
            for (Question q : questions) {
                newQuestions[count++] = q;
            }
            question.setId(count + 1);
            newQuestions[count] = question;
            questions = newQuestions;
        }
    }
    public Question[] getAllQuestions() {
        return questions;
    }
}
