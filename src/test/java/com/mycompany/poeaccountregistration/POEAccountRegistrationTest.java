/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poeaccountregistration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MOFENYI
 */
public class POEAccountRegistrationTest {
 /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        Login login = new Login();
        String validUsername = "user_";
        String validPassword = "Pass123!";
        login.registerUser("John", "Doe", validUsername, validPassword);
        assertTrue(login.isLoggedIn());
    }
    
    @Test
    public void testInvalidUsername() {
        Login login = new Login();
        String invalidUsername = "user";
        String validPassword = "Pass123!";
        login.registerUser("John", "Doe", invalidUsername, validPassword);
        assertFalse(login.isLoggedIn());
    }
    
    @Test
    public void testInvalidPassword() {
        Login login = new Login();
        String validUsername = "user_";
        String invalidPassword = "password";
        login.registerUser("John", "Doe", validUsername, invalidPassword);
        assertFalse(login.isLoggedIn());
    }
}
