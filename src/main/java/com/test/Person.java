package com.test;

import Sequencer.PersonSequencer;

import java.util.Objects;

public class Person {
   // Fields
   private int personID;
   private String name;

   private String email;

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   private AppUser credentials;

   // Constructor
   public Person(String name, AppUser credentials,String email) {
      this.personID = PersonSequencer.nextId();
      this.name = name;
       this.credentials = credentials;
       this.email = email;
   }



   // Getters and Setters
   public int getId() {
      return personID;
   }

    public void setId(int id) {
        this.personID = getId();
    }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }


   public AppUser getCredentials() {
      return credentials;
   }

   public void setCredentials(AppUser credentials) {
      this.credentials = credentials;
   }

   // Override toString() method


   @Override
   public String toString() {
      return "Person{" +
              "personID=" + personID +
              ", name='" + name + '\'' +
              "Role : " + credentials.getRole() +
              '}';
   }

   // Override equals() method
   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      Person person = (Person) obj;
      return personID == person.personID && Objects.equals(name, person.name);
   }

   // Override hashCode() method
   @Override
   public int hashCode() {
      return Objects.hash(personID, name);
   }
}