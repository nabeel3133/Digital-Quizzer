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
public class LoginTest {
    

    /**
     * Test of LoginFunction method, of class Login.
     */
    @Test
    public void testLoginFunction() {
        System.out.println("LoginFunction");
        Login instance = new Login();
        instance.usernameField.setText("nabeel3133");     
        instance.passwordField.setText("123");
        instance.role = 1;       

        boolean b1 = instance.LoginFunction("nabeel3133","123","Instructor");
        assertTrue(b1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of main method, of class Login.
     */
}
