package com.seecs.quizer.model;

/**
 * Created by Nabeel Hussain Syed on 12/21/2017.
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String type;
    private int marks;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}
