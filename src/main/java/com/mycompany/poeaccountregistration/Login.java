/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeaccountregistration;
import java.util.*;
/**
 *
 * @author ST10444429 MOFENYI NGWAKO MALULEKE GR01
 */
public class Login {

    public Login(String kyl_1, String chsecke99, String kyle, String buden) {
    }
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;
    
    //This method checks for username validity and ensures that its characters are of less than 5 
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    // Method to check password complexity and ensure that the length of 8 has UpperCase, Number and a Special character.
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");
        return password.length() >= 8 && hasUpperCase && hasNumber && hasSpecialChar;
    }
    // Method to register the user and store their Username, Password, Firstname and Lastname. 
    public void registerUser(String username, String password, String firstName, String lastName) {
       if (checkUsername(username) && checkPasswordComplexity(password)) {
           this.storedUsername = username;
           this.storedPassword = password;
           this.firstName = firstName;
           this.lastName = lastName;
           System.out.println("Username and Password successfully captured.");
       } 
       else {
           if (!checkUsername(username)) {
                System.out.println("Username incorrectly formatted, please ensure the username contains an underscore and is no more than 5 characters in length");
            }
            if (!checkPasswordComplexity(password)) {
                System.out.println("Password is incorrectly formatted, please ensure the password is at least 8 characters in length, contains a capital letter, contains a number, and contains a special character.");
            }
        }
    }
    // Method to check stored login credentials such as Username and Password.
    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
    // Successful login has been reach and login details acre correctly stored.
    public void returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            System.out.println("Welcome " + firstName + " " + lastName + ". It is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    }
}
