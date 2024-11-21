/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeaccountregistration;
import javax.swing.JOptionPane;
/**
 *
 * @author ST10444429 MOFENYI NGWAKO MALULEKE GR01
 */
public class Login {

    private String firstName; // Stores the user's first name
    private String lastName; // Stores the user's last name
    private String username; // Stores the user's username
    private String password; // Stores the user's password
    private boolean isLoggedIn = false; // Tracks whether the user is logged in or not
    
    // This method is responsible for registering a new user
    public void registerUser(String firstName, String lastName, String username, String password) {
        // Store the user's first name and last name
        this.firstName = firstName;
        this.lastName = lastName;
        
    // Check if the username and password are valid using helper methods
        if (checkUsername(username) && checkPasswordComplexity(password)) {
            this.username = username; // If valid, store the username
            this.password = password; // If valid, store the password
            JOptionPane.showMessageDialog(null, "User successfully registered!"); // Show success message
        } else {
            JOptionPane.showMessageDialog(null, "Registration failed due to invalid username or password."); // Show failure message
        }
    }
      // This helper method checks if the username is formatted correctly
    private boolean checkUsername(String username) {
        boolean isValid = username.contains("_") && username.length() <= 5;
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Username incorrectly formatted. It should contain an underscore and be no more than 5 characters.");
        }
        return isValid;  // Return true if valid, false otherwise
    }
   // This helper method checks if the password meets certain complexity requirements
    public boolean checkPasswordComplexity(String password) {
        // Check if the password is at least 8 characters long
        boolean hasLength = password.length() >= 8;

        // Check if the password contains at least one uppercase letter
        boolean hasUpperCase = password.matches(".*[A-Z].*");

        // Check if the password contains at least one number
        boolean hasNumber = password.matches(".*\\d.*");

        // Check if the password contains at least one special character
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        // Password is valid if it meets all the conditions
        if (hasLength && hasUpperCase && hasNumber && hasSpecialChar) {
            System.out.println("Password successfully captured");
            return true;
        } else {
             // Print a message to the console with the password requirements
            System.out.println("Password is incorrectly formatted. " +
                "Please ensure the password is at least 8 characters, " +
                "contains a capital letter, a number, and a special character.");
            return false; // Return false if password does not meet the requirements
        }
    }
    // This method handles the user login process
    public boolean loginUser(String username, String password) {
        
        // If the entered username and password match the registered details
        if (this.username.equals(username) && this.password.equals(password)) {
            isLoggedIn = true; // Set loggedIn to true, indicating that the user is now logged in
            // Display a welcome message with the user's full name
            JOptionPane.showMessageDialog(null, "Welcome, " + firstName + " " + lastName + ". It is great to see you again.");
            return true; // Return true indicating successful login
        } else {
            // If username and/or password is incorrect, show an error message
            JOptionPane.showMessageDialog(null, "Username and/or password is incorrect.");
            return false; // Return false indicating failed login attempt
        }
    }
    // This method returns whether the user is currently logged in or not
    public boolean isLoggedIn() {
        return isLoggedIn; // Return the value of isLoggedIn
    }
}
