package com.test;

import junit.framework.TestCase;
import java.util.Date;

public class TodoItemTest extends TestCase {

    public void testIsOverdue() {
        // Create a TodoItem with a past deadline
        Date pastDeadline = new Date(System.currentTimeMillis() - 100000);
        TodoItem todoItem = new TodoItem(1, "Task", "Description", pastDeadline, new Person());

        assertTrue(todoItem.isOverdue());
    }

    public void testIsNotOverdue() {
        // Create a TodoItem with a future deadline
        Date futureDeadline = new Date(System.currentTimeMillis() + 100000);
        TodoItem todoItem = new TodoItem(1, "Task", "Description", futureDeadline, new Person());

        assertFalse(todoItem.isOverdue());
    }

    public void testIsDone() {
        // Create a TodoItem that is marked as done
        TodoItem todoItem = new TodoItem(1, "Task", "Description", new Date(), new Person());
        todoItem.setDone(true);

        assertTrue(todoItem.isDone());
    }

    public void testIsNotDone() {
        // Create a TodoItem that is not marked as done
        TodoItem todoItem = new TodoItem(1, "Task", "Description", new Date(), new Person());

        assertFalse(todoItem.isDone());
    }

    public void testGetSummary() {
        // Create a TodoItem and check its summary
        Date deadline = new Date(System.currentTimeMillis() + 100000);
        TodoItem todoItem = new TodoItem(1, "Task", "Description", deadline, new Person());

        assertEquals("{id: 1, Title: Task , Description: Description, Completed: false}", todoItem.getSummary());
    }
}