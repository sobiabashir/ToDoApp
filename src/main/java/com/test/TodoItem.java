package com.test;

import java.util.Date;

public class TodoItem {
    private int toDoItem_id;
    private String title;
    private String taskDescription;
    private Date deadline;
    private boolean done;
    private Person creatorOfTask;

    ////to add constructor

    public TodoItem(int toDoItem_id, String title, String description, Date deadline, Person creator) {
        if (title == null || title.isEmpty() || deadline == null) {
            throw new IllegalArgumentException("Title and deadline cannot be null or empty");
        }
        this.toDoItem_id = toDoItem_id;
        this.title = title;
        this.taskDescription = description;
        this.deadline = deadline;
        this.creatorOfTask = creator;
    }
    /////////////

    ///////getter setter////////////


    public int getToDoItem_id() {
        return toDoItem_id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Person getCreatorOfTask() {
        return creatorOfTask;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setDone(boolean done) {
       this.done = done;
    }

    public void setCreatorOfTask(Person creatorOfTask) {
        this.creatorOfTask = creatorOfTask;
    }


    ////////// methods///////
    public boolean isOverdue() {
        Date currentDate = new Date();
        return currentDate.after(deadline);
    }
    public boolean isDone() {
        return done;
    }


    public String getSummary(){
        return "{id: " + toDoItem_id + ", Title: " + title + " "  + ", Description: " + taskDescription + ", Completed: " + done + ", Creator: " + (creatorOfTask != null ? creatorOfTask.getSummary() : "None") + "}";
    }
}
