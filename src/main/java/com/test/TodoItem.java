package com.test;

import java.util.Objects;

public class TodoItem {
    private String description;
    private boolean completed;
    private int priority;
    private Person createdBy;

    // Constructor
    public TodoItem(String description, boolean completed, int priority, Person createdBy) {
        setDescription(description);
        setCompleted(completed);
        setPriority(priority);
        setCreatedBy(createdBy);
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority < 0) {
            throw new IllegalArgumentException("Priority cannot be negative");
        }
        this.priority = priority;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        if (createdBy == null) {
            throw new IllegalArgumentException("CreatedBy cannot be null");
        }
        this.createdBy = createdBy;
    }

    // Override toString(), equals(), and hashCode()
    @Override
    public String toString() {
        return "TodoItem{" +
                "description='" + description + '\'' +
                ", completed=" + completed +
                ", priority=" + priority +
                ", createdBy=" + createdBy +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, completed, priority, createdBy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return completed == todoItem.completed && priority == todoItem.priority && Objects.equals(description, todoItem.description) && Objects.equals(createdBy, todoItem.createdBy);
    }
}
