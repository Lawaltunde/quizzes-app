package com.quizzes;

import java.util.Arrays;
import java.util.Objects;

public class Question {
    private int id;
    private String question;
    private String[] options;
    private String answer;

    public Question(int id, String question, String[] options, String answer)
    {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
    public Question(String question, String[] options, String answer)
    {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return id == question1.id && Objects.equals(question, question1.question) && Objects.deepEquals(options, question1.options) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, Arrays.hashCode(options), answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", options=" + Arrays.toString(options) +'}';
    }
}
