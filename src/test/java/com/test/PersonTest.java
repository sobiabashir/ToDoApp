package com.test;


import junit.framework.TestCase;

public class PersonTest extends TestCase {

    public void testPersonConstructor() {
        // Test with valid parameters
        Person person = new Person(1, "John", "Doe", "john@example.com");
        assertEquals(1, person.getIdPerson());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("john@example.com", person.getEmail());
    }

    public void testPersonConstructorNullFirstName() {
        // Test constructor with null first name
        try {
            new Person(1, null, "Doe", "john@example.com");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("First name, last name, and email cannot be null", e.getMessage());
        }
    }

    public void testPersonConstructorNullLastName() {
        // Test constructor with null last name
        try {
            new Person(1, "John", null, "john@example.com");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("First name, last name, and email cannot be null", e.getMessage());
        }
    }

    public void testPersonConstructorNullEmail() {
        // Test constructor with null email
        try {
            new Person(1, "John", "Doe", null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("First name, last name, and email cannot be null", e.getMessage());
        }
    }

    public void testGetSummary() {
        // Test getSummary method
        Person person = new Person(4, "Nisse", "Olsson", "nisse@gmail.com");
        assertEquals("{id: 4, name: Nisse Olsson, email: nisse@gmail.com}", person.getSummary());
    }

    // Add more test methods here to cover other functionalities of the Person class
}