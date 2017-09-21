/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.List;

/**
 *
 * @author Nabeel Hussain Syed
 */
public class Quiz implements java.io.Serializable{
    public String Title;
    public String Description;
    public List<String> Questions;
    public List<String> Options;
    public List<String> CorrectOptions;
    public List<String> QuestionsMarks;
    public List<String> QuestionType;
    public int QuizMarks;    
}
