package com.seecs.quizer.model;

/**
 * Created by Nabeel Hussain Syed on 12/21/2017.
 */

public class TrueFalse {
    private String OptionTrue;
    private String OptionFalse;

    public void setOptions(String Option1, String Option2) {
        this.OptionTrue=Option1;
        this.OptionFalse=Option2;
    }

    public String getOptionTrue(){
        return OptionTrue;
    }

    public String getOptionFalse(){
        return OptionFalse;
    }
}
