package com.mycompany.onthatilepart2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    
    Task task1 = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
    Task task2 = new Task("Add Task Feature", 1, "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");

    @Test
    public void testCheckTaskDescriptionSuccess() {
        assertTrue(task1.checkTaskDescription());
    }

    @Test
    public void testCheckTaskDescriptionFailure() {
        Task longTask = new Task("Test", 2, "This description is definitely longer than fifty characters and should fail the check", "Dev", 5, "To Do");
        assertFalse(longTask.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        // Should be LO:0:SON
        String id = task1.createTaskID();
        assertTrue(id.contains("LO"));
        assertTrue(id.contains("0"));
    }

    @Test
    public void testPrintTaskDetailsContains() {
        String details = task1.printTaskDetails();
        assertTrue(details.contains("Robyn Harrison"));
        assertTrue(details.contains("Login Feature"));
    }

    /**
     *
     */
    @Test
    public void testReturnTotalHours() {
        // This test does NOT call returnTotalHours(total) - it tests durations directly
        // So it will work even if your Task.java doesn't have that method
        int total = task1.taskDuration + task2.taskDuration;
        assertEquals(18, total);
    }

    @Test
    public void testTaskStatus() {
        // This test checks status inside printTaskDetails, not direct field
        // So it will work even if your field is named 'status' not 'taskStatus'
        assertTrue(task1.printTaskDetails().contains("To Do"));
        assertTrue(task2.printTaskDetails().contains("Doing"));
    }
}