package com.test;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    private int todoId;
    private String title;
    private boolean completed=false;
    private int priority;
    private Person createdBy;
    private LocalDate AssignedDate;
    private LocalDate deadline;




    public void setAssignedDate(LocalDate assignedDate) {
        AssignedDate = LocalDate.now();
    }

    public LocalDate getAssignedDate() {
        return AssignedDate;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = getAssignedDate().plusDays(14);
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    // Constructor
    public TodoItem(String description,Person createdBy, boolean completed, int priority, LocalDate assignedDate,LocalDate deadline) {
        setTitle(description);
        setCompleted(completed);
        setPriority(priority);
        setCreatedBy(createdBy);
        setAssignedDate(assignedDate);
        setDeadline(deadline);
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.title = title;
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
                "description='" + title + '\'' +
                ", completed=" + completed +
                ", priority=" + priority +
                ", createdBy=" + createdBy +
                ", AssignedDate=" + AssignedDate +
                ", deadline=" + deadline +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, completed, priority, createdBy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return completed == todoItem.completed && priority == todoItem.priority && Objects.equals(title, todoItem.title) && Objects.equals(createdBy, todoItem.createdBy);
    }
}
