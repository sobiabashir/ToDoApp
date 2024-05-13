package com.test;

import java.util.Objects;

public class Person {
   // Fields
   private int personID;
   private String firstName;
   private String lastName;

   public Person(int personID, String firstName, String lastName) {
      this.personID = personID; // Use the provided personID
      this.firstName = firstName;
      this.lastName = lastName;
   }

   // Constructor
   public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;

   }


   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public int getId() {
      return personID;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Person)) return false;
      Person person = ( Person ) o;
      return personID == person.personID && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName());
   }

   @Override
   public int hashCode() {
      return Objects.hash(personID, getFirstName(), getLastName());
   }

   @Override
   public String toString() {
      return "Person{" +
              "personID=" + personID +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              '}';
   }



   public void setId(int id) {
      this.personID = getId();
   }
}
