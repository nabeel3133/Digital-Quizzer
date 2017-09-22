/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nabeel Hussain Syed
 */
public class InstructorTest {
    /**
     * Test of MCQPanel method, of class Instructor.
     */
    @Test
    public void testMCQPanel() {
        System.out.println("MCQPanelCheck");
        Instructor instance = new Instructor("Title","Description");
        instance.MaxScore.setText("10");       
        boolean result = instance.MCQPanel();
        assertTrue(result);        
    }

    /**
     * Test of NumericPanel method, of class Instructor.
     */
    
    @Test
    public void testNumericPanel() {
        System.out.println("NumericPanelCheck");
        Instructor instance = new Instructor("Title","Description");
        instance.MaxScore.setText("10");       
        boolean result = instance.NumericPanel();
        assertTrue(result); 
    }

    /**
     * Test of TrueFalsePanel method, of class Instructor.
     */    
    @Test
    public void testTrueFalsePanel() {
        System.out.println("TrueFalseCheck");
        Instructor instance = new Instructor("Title","Description");
        instance.MaxScore.setText("10");       
        boolean result = instance.TrueFalsePanel();
        assertTrue(result); 
    }

    /**
     * Test of showPanel method, of class Instructor.
     */    
    @Test    
    public void testshowPanel()
    {
        System.out.println("PanelCheck");
        Instructor instance = new Instructor("Title","Description");
        instance.MaxScore.setText("10");     
        instance.QuestionType = 1;
        boolean result = instance.showPanel();
        assertTrue(result);         
    }
    
     /**
     * Test of MCQNextButton method, of class Instructor.
     */    
    @Test    
    public void testMCQNextButton()
    {
        System.out.println("MCQ Next Button Check");
        Instructor instance = new Instructor("Title","Description");
        instance.MaxScore.setText("10");     
        instance.MCQQuestion.setText("Some MCQ Question");     
        instance.SecondOption.setSelected(true);
        instance.QuestionType=1;
        boolean result = instance.showPanel();
        assertTrue(result);         
    } 

     /**
     * Test of TrueFalseNextButton method, of class Instructor.
     */    
    @Test    
    public void testTrueFalseNextButton()
    {
        System.out.println("True False Next Button Check");
        Instructor instance = new Instructor("Title","Description");
        instance.MaxScore.setText("10");     
        instance.MCQQuestion.setText("Some True False Question");     
        instance.SecondOption.setSelected(true);
        instance.QuestionType=2;
        boolean result = instance.showPanel();
        assertTrue(result);         
    }  

     /**
     * Test of TrueFalseNextButton method, of class Instructor.
     */    
    @Test    
    public void testNumericNextNextButton()
    {
        System.out.println("Numeric Next Button Check");
        Instructor instance = new Instructor("Title","Description");
        instance.MaxScore.setText("10");     
        instance.MCQQuestion.setText("Some Numeric Question");     
        instance.SecondOption.setSelected(true);
        instance.QuestionType=3;
        boolean result = instance.showPanel();
        assertTrue(result);         
    }  
    
}
