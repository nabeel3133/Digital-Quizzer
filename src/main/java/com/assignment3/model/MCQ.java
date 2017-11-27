package com.assignment3.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("MCQ")
public class MCQ extends Question {
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
