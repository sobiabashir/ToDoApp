package com.test;

import junit.framework.TestCase;
import java.util.Date;

public class TodoItemTaskTest extends TestCase {

    public void testGetId() {
        TodoItem todoItem = new TodoItem(1, "Task", "Description", new Date(), new Person());
        Person assignee = new Person(1, "John", "Doe", "john@example.com");
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        assertEquals(1, todoItemTask.getId());
    }

    public void testIsAssigned() {
        TodoItem todoItem = new TodoItem(1, "Task", "Description", new Date(), new Person());
        Person assignee = new Person(1, "John", "Doe", "john@example.com");
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        assertTrue(todoItemTask.isAssigned());
    }

    public void testSetAssigned() {
        TodoItem todoItem = new TodoItem(1, "Task", "Description", new Date(), new Person());
        Person assignee = new Person(1, "John", "Doe", "john@example.com");
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        todoItemTask.setAssigned(false);

        assertFalse(todoItemTask.isAssigned());
    }

    public void testGetTodoItem() {
        TodoItem todoItem = new TodoItem(1, "Task", "Description", new Date(), new Person());
        Person assignee = new Person(1, "John", "Doe", "john@example.com");
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        assertEquals(todoItem, todoItemTask.getTodoItem());
    }

    public void testSetTodoItem() {
        TodoItem todoItem1 = new TodoItem(1, "Task1", "Description1", new Date(), new Person());
        TodoItem todoItem2 = new TodoItem(2, "Task2", "Description2", new Date(), new Person());
        Person assignee = new Person(1, "John", "Doe", "john@example.com");
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem1, assignee);

        todoItemTask.setTodoItem(todoItem2);

        assertEquals(todoItem2, todoItemTask.getTodoItem());
    }

    public void testGetAssignee() {
        TodoItem todoItem = new TodoItem(1, "Task", "Description", new Date(), new Person());
        Person assignee = new Person(1, "John", "Doe", "john@example.com");
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        assertEquals(assignee, todoItemTask.getAssignee());
    }

    public void testSetAssignee() {
        TodoItem todoItem = new TodoItem(1, "Task", "Description", new Date(), new Person());
        Person assignee1 = new Person(1, "John", "Doe", "john@example.com");
        Person assignee2 = new Person(2, "Alice", "Smith", "alice@example.com");
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee1);

        todoItemTask.setAssignee(assignee2);

        assertEquals(assignee2, todoItemTask.getAssignee());
    }

}