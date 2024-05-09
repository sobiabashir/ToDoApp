package com.test;

import DAOInterface.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.user1;

public class App {
    public static void main(String[] args) {
        AppUserDAO appUserDAO = AppUserDAOImpl.getInstance();
        PersonDAO personDAO = PersonDAOImpl.getInstance();
        TodoItemDAO todoItemDAO = TodoItemImpl.getInstance();
       AppUser user1 = new AppUser("user1", "user1", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("user2", "user2", AppRole.ROLE_APP_ADMIN);
        AppUser user3 = new AppUser("user3", "user3", AppRole.ROLE_APP_ADMIN);
        appUserDAO.persist(user1);
        appUserDAO.persist(user2);
        appUserDAO.persist(user3);


       // System.out.println(appUserDAO.findByUsername("user2"));
        //appUserDAO.remove(user1);
        //System.out.println(appUserDAO.findAll());//System.out.println(user2);


        Person person1 = new Person("Sobia", user1, "<sobia@hotmail.com>");
        Person person2 = new Person("Sadia", user2, "<sad@hotmail.com>");
        Person person3 = new Person("Mohamed", user3, "<mohamed@hotmail.com>");
        personDAO.persist(person1);
        personDAO.persist(person2);
        personDAO.persist(person3);

       // System.out.println(personDAO.findAll());
        //System.out.println(personDAO.findByEmail("<sobia@hotmail.com>"));
        //System.out.println(personDAO.findById(1));


        TodoItem todoItem1 = new TodoItem("Buy milk", person1, true, 1,LocalDate.now(), LocalDate.now().plusDays(15));
        TodoItem todoItem2 = new TodoItem("Buy bread", person1, false, 2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(10));
        TodoItem todoItem3 = new TodoItem("Buy eggs", person2, false, 3, LocalDate.now().minusDays(10), LocalDate.now());
        TodoItem todoItem4 = new TodoItem("sell bread", person3, true, 4, LocalDate.now().minusDays(50), LocalDate.now());
        todoItemDAO.persist(todoItem1);
        todoItemDAO.persist(todoItem2);
        todoItemDAO.persist(todoItem3);
        todoItemDAO.persist(todoItem4);

        System.out.println("==================================");
        System.out.println(todoItemDAO.findByDeadlineAfter(LocalDate.ofEpochDay(2024-5-30)));
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println(todoItemDAO.findAllByDoneStatus(true));
        System.out.println(todoItemDAO.findByPersonId(2));

    }

}

