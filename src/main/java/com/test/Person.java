package com.test;

public class Person {
   private int personID;
   private String firstName;
   private String lastName;
   private String email;

   /// to add constructor

   public Person(int id, String firstName, String lastName, String email) {
      if (firstName == null || lastName == null || email == null) {
         throw new IllegalArgumentException("First name, last name, and email cannot be null");
      }
      this.personID = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Person() {

   }

   //////
   public int getIdPerson() {
      return personID;
   }
   public String getFirstName() {
      return firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public String getEmail() {
      return email;
   }
   public String getSummary(){
      return "{id: " + personID + ", name: " + firstName + " " + lastName + ", email: " + email + "}";
  }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setEmail(String email) {
      this.email = email;
   }

}
