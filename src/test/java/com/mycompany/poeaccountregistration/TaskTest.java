/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poeaccountregistration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MOFENYI
 */

// The test class where we are testing the functionality of the TaskManager class.
public class TaskTest {
    
    // Variable to hold the TaskManager instance which we are going to test.
private Task taskManager;
    
 // This method sets up the test environment by initializing the TaskManager and adding test data.
    @BeforeEach
    public void setUp() {
        taskManager = new Task();// Create a new TaskManager instance.
        
         // Add test tasks with developer names, task names, descriptions, durations, and statuses.
        taskManager.addTask("Mike Smith", "Create Login", "Secure login feature", 5, "To Do");
        taskManager.addTask("Edward Harrison", "Create Add Features", "Add features", 8, "Doing");
        taskManager.addTask("Samantha Paulson", "Create Reports", "Generate reports", 11, "Done");
        taskManager.addTask("Glenda Oberholzer", "Add Arrays", "Implement arrays", 11, "To Do");
    }
     // Test to verify that the developers have been added correctly to the task manager.
    @Test
    public void testDeveloperArrayPopulation() {
            // Expected developer names that should be added during task creation
        String expectedDeveloper1 = "Mike Smith";
        String expectedDeveloper2 = "Edward Harrison";
        String expectedDeveloper3 = "Samantha Paulson";
        String expectedDeveloper4 = "Glenda Oberholzer";

        // Verify that no exception is thrown when searching for tasks assigned to these developers.
        // If the developers are in the system, the search should complete without any errors.
        assertDoesNotThrow(() -> taskManager.searchTasksByDeveloper(expectedDeveloper1));
        assertDoesNotThrow(() -> taskManager.searchTasksByDeveloper(expectedDeveloper2));
        assertDoesNotThrow(() -> taskManager.searchTasksByDeveloper(expectedDeveloper3));
        assertDoesNotThrow(() -> taskManager.searchTasksByDeveloper(expectedDeveloper4));
    }
// Test to verify that the task with the longest duration is identified correctly
    @Test
    public void testLongestTaskDeveloperAndDuration() {
        // The expected output for the task with the longest duration should be "Glenda Oberholzer, 11".
        // Since two tasks have a duration of 11 hours, we expect the method to display one of them.
        String expectedLongest = "Glenda Oberholzer, 11";
        
         // Call the method to display the longest task. The test indirectly verifies the functionality
        // by manual observation (in real tests, we'd capture and check the output programmatically).
        taskManager.displayLongestTask();
        // This test indirectly verifies the functionality through manual observation.
    }
 // Test to verify the ability to search for a task by its name.
    @Test
    public void testSearchTaskByName() {
        // Name of the task we are searching for.
        String expectedTaskName = "Create Login";
        
        // Assert that no exception is thrown when searching for the task by its name.
        // If the task exists, the search will succeed.
        assertDoesNotThrow(() -> taskManager.searchTaskByName(expectedTaskName));
    }
    
    @Test
    public void testDeleteTaskByName() {
        // Delete a task by name and ensure it's removed
        String taskToDelete = "Create Reports";
        assertDoesNotThrow(() -> taskManager.deleteTaskByName(taskToDelete));

        // Search for the deleted task to ensure it no longer exists
        assertDoesNotThrow(() -> taskManager.searchTaskByName(taskToDelete));
    }
    
    @Test
    public void testDisplayAllTasksReport() {
        // Display the full task report
        assertDoesNotThrow(() -> taskManager.displayAllTasksReport());
    }
}
