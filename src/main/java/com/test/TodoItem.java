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

    private String description;
    private LocalDate deadline;
    private boolean done = false;

    private int AssigneeId;

    public void setDeadline(LocalDate deadline) {
        this.deadline = LocalDate.now().plusDays(14);
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    // Constructor
    public TodoItem(String title,String description , LocalDate deadline, boolean done,int AssigneeId) {
        setTitle(title);
        setDescription(description);
        setDeadline(deadline);
        setCompleted(done);
        setAssigneeId(AssigneeId);

    }
    public TodoItem(int id,String title,String description , LocalDate deadline, boolean done,int AssigneeId) {
        setTodoId(id);
        setTitle(title);
        setDescription(description);
        setDeadline(deadline);
        setCompleted(done);
        setAssigneeId(AssigneeId);

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
        return done;
    }

    public void setCompleted(boolean completed) {

        this.done = completed;
    }

    public int getAssigneeId() {
        return AssigneeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", Assignee=" + AssigneeId +
                '}';
    }

    public void setAssigneeId(int AssigneeId) {
        this.AssigneeId = AssigneeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem)) return false;
        TodoItem todoItem = ( TodoItem ) o;
        return getTodoId() == todoItem.getTodoId() && done == todoItem.done && Objects.equals(getTitle(), todoItem.getTitle()) && Objects.equals(getDescription(), todoItem.getDescription()) && Objects.equals(getDeadline(), todoItem.getDeadline()) && Objects.equals(getAssigneeId(), todoItem.getAssigneeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTodoId(), getTitle(), getDescription(), getDeadline(), done, getAssigneeId());
    }
}