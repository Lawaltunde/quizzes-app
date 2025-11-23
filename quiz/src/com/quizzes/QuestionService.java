package com.quizzes;

import java.util.Arrays;
import java.util.Scanner;

public class QuestionService {
    private QuestionDAO questionDAO;
    private String[] answers;
    // reuse one scanner for System.in
    private final Scanner sc = new Scanner(System.in);

    {
        questionDAO = new QuestionDAO();
        answers = null;
    }

    public void displayQuestions(){
        Question[] questions = questionDAO.getAllQuestions();
        if (questions == null) {
            System.out.println("No questions available.");
            return;
        }

        // ensure answers array matches current number of questions
        if (answers == null || answers.length < questions.length) {
            answers = new String[questions.length];
        }

        int correctAnswers = 0;
        int processed = 0;
        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            if (q == null) continue; // skip null slots (if any)

            System.out.println("-------------------------");
            System.out.println("Question: " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println("Options: " + Arrays.toString(q.getOptions()));
            System.out.print("Your Answer: ");

            String userAnswer = "";
            // safely read a line only if available to avoid NoSuchElementException when input is exhausted
            if (sc.hasNextLine()) {
                userAnswer = sc.nextLine();
            } else {
                // no more input (e.g., piped input exhausted); treat as blank answer
                System.out.println();
                userAnswer = "";
            }

            if (userAnswer == null) userAnswer = "";
            userAnswer = userAnswer.trim();

            // Map single-letter answers (A/B/C/...) to the corresponding option text if possible
            String selectedText = mapLetterToOption(userAnswer, q.getOptions());
            if (selectedText == null || selectedText.isEmpty()) {
                // user may have typed the full option (e.g., "Paris") or the full "A. Paris"
                selectedText = userAnswer;
            }

            // store the answer aligned with the question index
            answers[i] = selectedText;

            // Normalize both sides and compare
            String normalizedSelected = normalizeAnswer(selectedText);
            String normalizedExpected = normalizeAnswer(q.getAnswer());

            if (!normalizedSelected.isEmpty() && normalizedSelected.equals(normalizedExpected)) {
                correctAnswers++;
            }
            processed++;
        }

        System.out.println("You got " + correctAnswers + " out of " + processed + " correct!");
    }

    private String mapLetterToOption(String userAnswer, String[] options) {
        if (userAnswer == null || userAnswer.isEmpty() || options == null) return null;
        String s = userAnswer.trim();
        if (s.length() == 1 && Character.isLetter(s.charAt(0))) {
            char letter = Character.toUpperCase(s.charAt(0));
            for (String opt : options) {
                if (opt == null) continue;
                String t = opt.trim();
                if (t.length() > 0 && Character.toUpperCase(t.charAt(0)) == letter) {
                    // return the option text (without altering it here)
                    return t;
                }
            }
        }
        return null;
    }

    private String normalizeAnswer(String s) {
        if (s == null) return "";
        String t = s.trim();
        if (t.isEmpty()) return "";

        // remove leading letter prefix like "A." or "A)" or "A. " etc.
        if (t.length() >= 2 && Character.isLetter(t.charAt(0)) && (t.charAt(1) == '.' || t.charAt(1) == ')')) {
            t = t.substring(2).trim();
        }
        // also handle prefixes like "A. " (3 chars), already handled by substring(2) then trim

        return t.toLowerCase();
    }

    public void printAnswer()
    {
        System.out.println(Arrays.toString(answers));
    }

    public Question[] getAllQuestions(){
        return questionDAO.getAllQuestions();
    }

    public void addQues(Question question)
    {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }
        questionDAO.addQuestion(question);
    }
}
