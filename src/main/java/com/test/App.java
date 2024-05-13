package com.test;

import DAOInterface.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.user1;

public class App {
    public static void main(String[] args) {


        PersonDAO personDAO = PersonDAOImpl.getInstance();
        TodoItemDAO todoItemDAO = TodoItemImpl.getInstance();



       // System.out.println(appUserDAO.findByUsername("user2"));
        //appUserDAO.remove(user1);
        //System.out.println(appUserDAO.findAll());//System.out.println(user2);


        Person person1 = new Person("Sobia", "Bashir");
        Person person2 = new Person("Sadia", "Rasheed");
        Person person3 = new Person("Sobia", "Sardar");
        Person person4 = new Person("Asim", "Bashir");
        Person person5 = new Person("ssd", "Sardar");

        //personDAO.persist(person5);


      // System.out.println(personDAO.findAll());
       //System.out.println("_________________________________________");
        //System.out.println(personDAO.findByLastName("Bashir"));
        //System.out.println(personDAO.findById(1));


      TodoItem todoItem1 = new TodoItem("developing","do it soon",LocalDate.of(2024,06,23),false,1);
        TodoItem todoItem2 = new TodoItem("testing","anaylsis",LocalDate.now(),true,3);
        TodoItem todoItem3 = new TodoItem("developing","do it soon",LocalDate.now(),true,1);
        TodoItem todoItem4 = new TodoItem("testing","anaylsis",LocalDate.now(),true,4);
        //todoItemDAO.persist(todoItem4);



        System.out.println("==================================");
        System.out.println(todoItemDAO.findById(2));
        //personDAO.persist(person1);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        //System.out.println(todoItemDAO.findAllByDoneStatus(true));
        //System.out.println(todoItemDAO.findByPersonId(1));

    }

}

