package com.test;

import java.util.Objects;

public class TodoItemTask {
    private String task;
    private boolean completed;
    private Person assignedTo;

    // Constructor

   public TodoItemTask(String task, boolean completed, Person assignedTo) {
        setTask(task);
        setCompleted(completed);
        setAssignedTo(assignedTo);
    }
    // Getters and Setters
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        if (task == null || task.isEmpty()) {
            throw new IllegalArgumentException("Task cannot be null or empty");
        }
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Person getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(AppUser assignedTo) {
        if (assignedTo == null) {
            throw new IllegalArgumentException("AssignedTo cannot be null");
        }
        this.assignedTo = (Person) assignedTo;
    }

    // Override toString(), equals(), and hashCode()



    @Override
    public String toString() {
        String assignedToName = (assignedTo != null) ? assignedTo.getCredentials().getUsername() : "Unassigned";
        return "TodoItemTask{" +
                "task='" + task + '\'' +
                ", completed=" + completed +
                ", assignedTo=" + assignedToName +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(task, completed, assignedTo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return completed == that.completed && Objects.equals(task, that.task) && Objects.equals(assignedTo, that.assignedTo);
    }
    public boolean isAssignedToUser(AppUser user) {
        return assignedTo != null && assignedTo.equals(user);
    }
}
