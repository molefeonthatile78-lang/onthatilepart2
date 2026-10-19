package com.mycompany.onthatilepart2;

public final class Task {
    private final String taskName;
    private final int taskNumber;
    private final String taskDescription;
    private final String developerDetails;
    final int taskDuration;
    private final String taskStatus;
    private final String taskID;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    public boolean checkTaskDescription(){
        return this.taskDescription.length() <= 50;
    }

    public String createTaskID(){
        String namePart = taskName.length() >= 2 ? taskName.substring(0,2).toUpperCase() : taskName.toUpperCase();
        String devPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return namePart + ":" + taskNumber + ":" + devPart;
    }

    public String printTaskDetails(){
        return "Task Status: " + taskStatus +
               "Developer Details: " + developerDetails +
               "Task Number: " + taskNumber +
               "Task Name: " + taskName +
               "Task Description: " + taskDescription +
               "Task ID: " + taskID +
               "Task Duration: " + taskDuration + "h";
    }

    private int getTaskDuration(){
        return taskDuration;
    }
    
    public String getTaskStatus(){
        return taskStatus;
    }
    
    public String getTaskID(){
        return taskID;
    }

    public int returnTotalHours(int totalHours) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
