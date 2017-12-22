package com.seecs.quizer.model;

/**
 * Created by Nabeel Hussain Syed on 12/21/2017.
 */

public class MCQ {
    private String OptionA;
    private String OptionB;
    private String OptionC;
    private String OptionD;

    public void setOptions(String Option1, String Option2, String Option3, String Option4) {
        this.OptionA=Option1;
        this.OptionB=Option2;
        this.OptionC=Option3;
        this.OptionD=Option4;
    }

    public String getOptionA(){
        return OptionA;
    }

    public String getOptionB(){
        return OptionB;
    }

    public String getOptionC(){
        return OptionC;
    }

    public String getOptionD(){
        return OptionD;
    }
}
