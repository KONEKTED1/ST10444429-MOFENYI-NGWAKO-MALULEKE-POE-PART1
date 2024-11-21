/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poeaccountregistration;
import javax.swing.JOptionPane;
/**
 *
 * @author ST10444429 MOFENYI NGWAKO MALULEKE GR01
 */
public class POEAccountRegistration {
   private static final Login login = new Login();
    private static final Task taskManager = new Task();
     
    
    public static void main(String[] args) {

       
        // Register login calls the method that handles user registration and login process
        registerAndLogin();

        
        // If the user is successfully logged in, show the main menu
        if (login.isLoggedIn()) {
            showMainMenu();
        }
    }
    // This method handles both the registration and login process
    private static void registerAndLogin() {
        
        // Prompt user to enter their first name, last name, username, and password
        // and pass them to the registration method.
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        String username = JOptionPane.showInputDialog("Enter username (max 5 chars, includes '_'):");
        String password = JOptionPane.showInputDialog("Enter password (min 8 chars, includes uppercase, number, special char):");
        login.registerUser(firstName, lastName, username, password);
        
     
         // If the user is not logged in after registration, prompt for login details
        if (!login.isLoggedIn()) {
            String loginUsername = JOptionPane.showInputDialog("Enter username to log in:");
            String loginPassword = JOptionPane.showInputDialog("Enter password:");
            login.loginUser(loginUsername, loginPassword);
        }
    }
    // This method displays the main menu and allows the user to choose an action
    private static void showMainMenu() {
          // This loop will keep showing the menu until the user chooses to quit
        while (true) {
           // These are the available options in the menu
            String[] options = {"1. Add Task", "2. Show Report", "3. Search Task by Name", "4. Delete Task by Name", "5. Search Tasks by Developer", "6. Display Tasks with Status Done", "7. Display Longest Task","8. Quit"};
             // Show a dialog to let the user select an option
            String choice = (String) JOptionPane.showInputDialog(null, "Welcome to EasyKanban! Choose an option:", "Main Menu",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            // If the user chooses to quit, display a message and exit the loop
            if (choice == null || choice.equals("8. Quit")) {
                JOptionPane.showMessageDialog(null, "Exiting the application.");
                break;
            }
            
            // Based on the user's choice, call the appropriate method
         switch (choice) {
                case "1. Add Task" -> addTask(); // Call the method to add a task
                case "2. Show Report" -> taskManager.displayAllTasksReport();// Show all tasks report
                case "3. Search Task by Name" -> searchTaskByName(); // Search a task by name
                case "4. Delete Task by Name" -> deleteTaskByName(); // Delete a task by name
                case "5. Search Tasks by Developer" -> searchTasksByDeveloper(); // Search tasks by developer name
                case "6. Display Tasks with Status Done" -> taskManager.displayDoneTasks(); // Show tasks marked as "Done"
                case "7. Display Longest Task" -> taskManager.displayLongestTask(); // Show the task with the longest duration
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please choose again."); // Show message for invalid options
            }
        }
    }
    
     // This method handles adding a new task
    private static void addTask() {
        // Ask user to input developer's name, task name, task description, and duration
        String developer = JOptionPane.showInputDialog("Enter developer's full name:");
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 chars):");
        // Check if task description exceeds the character limit of 50
        if (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Task description is too long. Must be under 50 characters.");
            return;
        }
    // Ask for the task duration (how many hours the task will take)
     int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
     
     // Offer predefined status options for the task
        String[] statuses = {"To Do", "Doing", "Done"};
        String status = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
        
    // Add the task to the task manager using the provided details
        taskManager.addTask(developer, taskName, taskDescription, duration, status);
    }
    // This method allows the user to search for a task by its name
    private static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter task name to search:");
        taskManager.searchTaskByName(taskName);
    }
     // This method allows the user to delete a task by its name
    private static void deleteTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter task name to delete:");
        taskManager.deleteTaskByName(taskName);
    }
    
     // This method allows the user to search for tasks by the developer's name
    private static void searchTasksByDeveloper() {
        String taskDeveloper = JOptionPane.showInputDialog("Enter task Developer to search for his tasks:");
        taskManager.searchTasksByDeveloper(taskDeveloper);
    }
}

    

