package com.test;
import java.util.Date;
public class TodoItemTask{
    private int todoTask_Id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    // Constructor
    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this.todoTask_Id = id;
        this.todoItem = todoItem;
        this.assignee = assignee;
        this.assigned = (assignee != null);
    }

    // Getters and setters
    public int getId() {
        return todoTask_Id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = (assignee != null);
    }

    // getSummary method

    public String getSummary() {
        String assigneeSummary = assignee != null ? assignee.getSummary() : "None";
        return "{id: " + todoTask_Id + ", assigned: " + assigned + ", todoItem: {id: " + todoItem.getToDoItem_id() + ", Title: " + todoItem.getTitle() + ", Description: " + todoItem.getTaskDescription() + ", Completed: " + todoItem.isDone() + "}, assignee: " + assigneeSummary + "}";
    }


}