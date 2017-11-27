package com.assignment3.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("True/False")
public class TrueFalse extends Question {
	private String OptionTrue;
    private String OptionFalse;
    
    public void setOptions(String Option1, String Option2) {
        OptionTrue=Option1;
        OptionFalse=Option2;
    }
    
    public String getOptionTrue(){
        return OptionTrue;
    }
    
    public String getOptionFalse(){
        return OptionFalse;
    }
}
