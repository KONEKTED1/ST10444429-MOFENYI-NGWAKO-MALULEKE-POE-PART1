/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poeaccountregistration;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ST10444429 MOFENYI NGWAKO MALULEKE GR01
 */
public class POEAccountRegistration {
   
        private static boolean loggedIn = false;
        private static final ArrayList<Task> tasks = new ArrayList<>();
    
    public static void main(String[] args) {
        //Declarations
        String firstName, lastName, username, password;
        Scanner log = new Scanner(System.in);
        //Initiate the class object 
        Login ext = new Login();
        
        //Prompting for user input
        System.out.println("Enter your first name: ");
        firstName = log.next();
        System.out.println("Enter your last name: ");
        lastName = log.next();
        System.out.println("Create a new username: ");
        username = log.next();
        System.out.println("Create a new password: ");
        password = log.next();
        
        //Register user
        ext.registerUser(username, password, firstName, lastName);
        
        // Ask for login
        System.out.println("\nPlease log in to your account.");
        System.out.println("Enter username, please ensure the username contains an underscore and is no more than 5 characters in length : ");
        String loginUsername = log.next();

        System.out.println("Enter password, Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character  : ");
        String loginPassword;
        loginPassword = log.next();
        
        // Check login status
        ext.returnLoginStatus(loginUsername, loginPassword);
          
        
        log.close();
        
         //ADDING TASK FEATURES: POE PART 2 STARTS HERE.............
         
         
         //Method will ensure that the dialog will always appear on top 
          final JDialog dialog = new JDialog();
          dialog.setAlwaysOnTop(true);    
          
          
          // The application will display a welcome message 
        JOptionPane.showMessageDialog(dialog, "Welcome to EasyKanban");
        
       

        while (true) {
            String input = JOptionPane.showInputDialog(dialog,"Choose an option:\n1) Add tasks\n2) Show report\n3) Quit");
             //parseInt is used to convert a string that represents a decimal number into an integer
            int choice = Integer.parseInt(input);
    
            
            // switch case method displaying numeric menu feature

            switch (choice) {
                case 1:
                    addTasks(dialog);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(dialog, "Coming Soon");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(dialog, "Exiting...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(dialog, "Invalid option, please choose again.");
            }
            
              dialog. dispose();
        }
        
    }
    
    
    
         // The application will prompt for task length
    private static void addTasks(JDialog dialog) {
        String numTasksInput = JOptionPane.showInputDialog(dialog,"How many tasks would you like to enter?");
        int numTasks = Integer.parseInt(numTasksInput);
        
        //FOR loop 

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog(dialog,"Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog(dialog,"Enter Task Description:");
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(dialog, "Please enter a task description of less than 50 characters");
                i--; 
                continue;
            }

            String developerDetails = JOptionPane.showInputDialog(dialog,"Enter Developer Details (First and Last Name):");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(dialog,"Enter Task Duration (in hours):"));
            String[] statusOptions = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(dialog, "Select Task Status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus, tasks.size());
            tasks.add(task);

            JOptionPane.showMessageDialog(dialog, task.printTaskDetails());
        }

        int totalHours = tasks.stream().mapToInt(Task::getTaskDuration).sum();
        JOptionPane.showMessageDialog(dialog, "Total Task Duration: " + totalHours + " hours");
        
        
        
       
        
    }
}
