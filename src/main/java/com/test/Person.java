package com.test;

import java.util.Objects;

public final class Person extends AppUser {
   private AppUser credentials;

   // Constructor
   public Person(AppUser credentials) {
       super();
       setCredentials(credentials);
   }

   // Getters and Setters
   public AppUser getCredentials() {
      return credentials;
   }

   public void setCredentials(AppUser credentials) {
      if (credentials == null) {
         throw new IllegalArgumentException("Credentials cannot be null");
      }
      this.credentials = credentials;
   }

   // Override equals() and hashCode()
   @Override
   public int hashCode() {
      return Objects.hash(credentials);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Person person = (Person) o;
      return Objects.equals(credentials, person.credentials);
   }

   // Override toString()
   @Override
   public String toString() {
      return "Person{" +
              "credentials=" + credentials +
              '}';
   }
}
