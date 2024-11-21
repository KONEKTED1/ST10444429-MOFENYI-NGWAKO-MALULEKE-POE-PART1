/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeaccountregistration;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author MOFENYI
 */

// This class manages tasks by storing data such as task names, developers, durations, and statuses.
// It includes methods for adding tasks, searching for tasks, deleting tasks, and generating reports.

public class Task {
  
// Arrays to store task-related information for each task.
    private final ArrayList<String> developerNames = new ArrayList<>(); // List of developers assigned to tasks
    private final ArrayList<String> taskNames = new ArrayList<>(); // List of task names
    private final ArrayList<String> taskIDs = new ArrayList<>(); // List of task IDs
    private final ArrayList<Integer> taskDurations = new ArrayList<>(); // List of task durations (in hours)
    private final ArrayList<String> taskStatuses = new ArrayList<>(); // List of task statuses (To Do, Doing, Done)
    
    // Method to add a task to the system and store all the task details
    public void addTask(String developerName, String taskName, String taskDescription, int taskDuration, String taskStatus) {
        // // Generate a unique Task ID based on the task name, task number, and developer's name
        
        int taskNumber = taskIDs.size();// Task number is based on how many tasks are already added
        String taskID = generateTaskID(taskName, taskNumber, developerName);  // Create a unique Task ID

        // Add the task details to the respective lists
        developerNames.add(developerName); // Add developer name to the list
        taskNames.add(taskName); // Add task name to the list
        taskIDs.add(taskID); // Add task ID to the list
        taskDurations.add(taskDuration); // Add task duration to the list
        taskStatuses.add(taskStatus); // Add task status to the list

        // Show a message with the task details to the user
        JOptionPane.showMessageDialog(null, """
                                            Task successfully captured:
                                            Status: """ + taskStatus + "\n" +
                "Developer: " + developerName + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Name: " + taskName + "\n" +
                "Description: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Duration: " + taskDuration + " hours");
    }

    // Method to generate a unique Task ID for each task
    private String generateTaskID(String taskName, int taskNumber, String developerName) {
         // Create Task ID by using the first two letters of the task name, the task number, and the last three letters of the developer's name
        String firstTwoLetters = taskName.substring(0, 2).toUpperCase(); // First 2 letters of task name
        String lastThreeLetters = developerName.substring(developerName.length() - 3).toUpperCase();// Last 3 letters of developer's name
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters; // Combine to form the Task ID
    }
    
    // Method to display all tasks that have the status "Done"
    public void displayDoneTasks() {
        StringBuilder result = new StringBuilder("Tasks with 'Done' status:\n");
        
        // Loop through the tasks and check which ones have the status "Done"
        for (int i = 0; i < taskStatuses.size(); i++) {
            if ("Done".equalsIgnoreCase(taskStatuses.get(i))) { // If the task is marked as "Done"
                result.append("Developer: ").append(developerNames.get(i))
                      .append(", Task Name: ").append(taskNames.get(i))
                      .append(", Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }
         // Show a message with all tasks that are marked as "Done"
        JOptionPane.showMessageDialog(null, result.toString());
    }
    
    // Method to display the task with the longest duration
    public void displayLongestTask() {
        // Check if there are no tasks
        if (taskDurations.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }
        int maxDurationIndex = 0;// Start by assuming the first task has the longest duration
        
        // Loop through the tasks and find the one with the longest duration
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxDurationIndex)) {
                maxDurationIndex = i; // Update the index if a longer task is found
            }
        }
        // Show a message with the task that has the longest duration
        JOptionPane.showMessageDialog(null, """
                                            Task with the longest duration:
                                            Developer: """ + developerNames.get(maxDurationIndex) +
                ", Duration: " + taskDurations.get(maxDurationIndex) + " hours");
    }
    
    // Method to search for a task by its name
    public void searchTaskByName(String name) {
        // Find the index of the task with the specified name
        int index = taskNames.indexOf(name);
        if (index != -1) {
            // If the task is found, show its details
            JOptionPane.showMessageDialog(null, """
                                                Task Found:
                                                Task Name: """ + taskNames.get(index) +
                    "\nDeveloper: " + developerNames.get(index) +
                    "\nStatus: " + taskStatuses.get(index));
        } else {
            // If the task is not found, show an error message
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }
    
         // Method to search for tasks assigned to a specific developer
    public void searchTasksByDeveloper(String developerName) {
        StringBuilder result = new StringBuilder("Tasks for Developer: " + developerName + "\n");
        boolean found = false; // Flag to track if any tasks are found for the developer
        
        // Loop through all tasks and check if they belong to the specified developer
        for (int i = 0; i < developerNames.size(); i++) {
            if (developerNames.get(i).equalsIgnoreCase(developerName)) {
                found = true;// If a task is found, set found to true
                result.append("Task Name: ").append(taskNames.get(i))
                      .append(", Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        // Show a message with all tasks found for the specified developer, or an error message if no tasks are found
        if (found) {
            JOptionPane.showMessageDialog(null, result.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for this developer.");
        }
    }
    
    // Method to delete a task by its name
    public void deleteTaskByName(String taskName) {
        // Find the index of the task with the specified name
        int index = taskNames.indexOf(taskName);
        if (index != -1) {
            // If the task is found, remove it from all lists
            developerNames.remove(index);
            taskNames.remove(index);
            taskIDs.remove(index);
            taskDurations.remove(index);
            taskStatuses.remove(index);
            
            // Show a confirmation message that the task was deleted
            JOptionPane.showMessageDialog(null, "Task '" + taskName + "' has been deleted.");
        } else {
            // If the task is not found, show an error message
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }
    
    // Method to display a full report of all tasks
    public void displayAllTasksReport() {
        StringBuilder report = new StringBuilder("All Tasks Report:\n");
        
       // Loop through all tasks and compile their details into a report
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task ").append(i + 1).append(":\n")
                  .append("Developer: ").append(developerNames.get(i)).append("\n")
                  .append("Task Name: ").append(taskNames.get(i)).append("\n")
                  .append("Task ID: ").append(taskIDs.get(i)).append("\n")
                  .append("Duration: ").append(taskDurations.get(i)).append(" hours\n")
                  .append("Status: ").append(taskStatuses.get(i)).append("\n\n");
        }
        // Show the full report of all tasks
        JOptionPane.showMessageDialog(null, report.toString());
    }
}
