package com.whack.janson.mindfulmatters;

/**
 * Created by Jason on 11/10/2017.
 */

public class Question {
    private String question;
    private int score;

    public Question(String question) {
        this.question = question;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public int getScore() {
        return score;
    }
}
