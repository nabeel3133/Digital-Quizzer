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

public class TitleAndDescriptionTest {

    /**
     * Test of AddTitleAndDescription method, of class Login.
     */
    @Test    
   public void testAddTitleAndDescription()
   {
        System.out.println("Title And Description Function");
        TitleAndDescription instance = new TitleAndDescription();
        instance.setVisible(true);
        instance.TitleField.setText("Some Title");     
        instance.DescriptionField.setText("Some Description");
        boolean b1 = instance.AddTitleAndDescription("Some Title","Some Description");
        System.out.println("Title of the quiz: Some Title");
        System.out.println("Description of the quiz: Some Description");
        assertTrue(b1);
   }    
}
