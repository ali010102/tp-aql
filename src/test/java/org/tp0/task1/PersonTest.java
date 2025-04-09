package org.tp0.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testGetFullName() {
        Person person = new Person("John", "Doe", 25);
        assertEquals("John Doe", person.getFullName(), "Le nom complet devrait être 'John Doe'");
    }

    @Test
    void testIsAdultWhenAdult() {
        Person person = new Person("Ali", "ilhem", 20);
        assertTrue(person.isAdult(), "La personne de 20 ans devrait être adulte");
    }

    @Test
    void testIsAdultWhenMinor() {
        Person person = new Person("Bob", "Brown", 17);
        assertFalse(person.isAdult(), "La personne de 17 ans ne devrait pas être adulte");
    }
}