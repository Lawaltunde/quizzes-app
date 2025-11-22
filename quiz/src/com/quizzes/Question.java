package com.quizzes;

import java.util.Arrays;
import java.util.Objects;

public class Question {
    private int id;
    private String question;
    private String[] options;

    public Question(int id, String question, String[] options)
    {
        this.id = id;
        this.question = question;
        this.options = options;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return id == question1.id && Objects.equals(question, question1.question) && Objects.deepEquals(options, question1.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, Arrays.hashCode(options));
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }
}
