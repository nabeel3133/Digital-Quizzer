package com.seecs.quizer.model;

/**
 * Created by Nabeel Hussain Syed on 12/21/2017.
 */

public class Question {
    private int id;
    private String question;
    private int marks;
    private int correct;
    private Quiz quiz;

    public void setId(int ID)
    {
        this.id = ID;
    }


    public void setQuestion(String str) {
        this.question=str;
    }

    public void setCorrectAnswer(int correct) {
        this.correct=correct;
    }

    public void setMarks(int str) {
        this.marks=str;
    }

    public void setQuiz(Quiz quiz)
    {
        this.quiz = quiz;
    }

    public Quiz getQuiz()
    {
        return quiz;
    }

    public String getQuestion(){
        return question;
    }

    public int getCorrectAnswer() {
        return correct;
    }

    public int getMarks() {
        return marks;
    }

    public int getId()
    {
        return id;
    }
}
