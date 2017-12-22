package com.seecs.quizer.model;

/**
 * Created by Nabeel Hussain Syed on 12/21/2017.
 */

public class Quiz {
    private int id;
    private String title;
    private String description;
    private int marks;
    private int total_questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTotalQuestions(int totalQuestions)
    {
        this.total_questions = totalQuestions;
    }

    public int getTotalQuestions()
    {
        return total_questions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
