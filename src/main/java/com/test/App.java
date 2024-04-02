package com.test;
public class App {
    public static void main(String[] args) {
        // Creating user1 and user2 instances of Person
        Person user1 = new Person(new AppUser("David", "password123", AppRole.ROLE_APP_USER));
        Person user2 = new Person(new AppUser("Sobia", "password223", AppRole.ROLE_APP_ADMIN));

        // Creating TodoItemTask objects and passing the Person instances
        TodoItemTask task1 = new TodoItemTask("Research topic", false, user1);
        TodoItemTask task2 = new TodoItemTask("Tester", true, user1);
        TodoItemTask task3 = new TodoItemTask("Developer", true, user2);

        // Display tasks assigned to user1
        displayTasksForUser(user1, task1, task2);

        // Display tasks assigned to user2
        displayTasksForUser(user2, task3);
    }

    // Method to display tasks assigned to a specific user
   private static void displayTasksForUser(Person user, TodoItemTask... tasks) {
        System.out.println("Tasks assigned to " + user.getCredentials().getUsername() + ":");
        for (TodoItemTask task : tasks) {
            if (task.isAssignedToUser(user)) {
                System.out.println(task);
            }
        }
        System.out.println();
    }

}

