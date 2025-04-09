package org.tp0.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void testNewStackIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty(), "Une nouvelle pile devrait être vide");
        assertEquals(0, stack.size(), "La taille d'une nouvelle pile devrait être 0");
    }

    @Test
    void testPushIncreasesSize() {
        Stack stack = new Stack();
        stack.push(10);
        assertFalse(stack.isEmpty(), "La pile ne devrait plus être vide après un push");
        assertEquals(1, stack.size(), "La taille devrait être 1 après un push");
        assertEquals(10, stack.peek(), "Le sommet de la pile devrait être 10");
    }

    @Test
    void testPopReturnsLastElement() {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(15);
        int popped = stack.pop();
        assertEquals(15, popped, "Pop devrait retourner le dernier élément ajouté");
        assertEquals(1, stack.size(), "La taille devrait être 1 après un pop");
        assertEquals(5, stack.peek(), "Le sommet de la pile devrait être 5 après un pop");
    }

    @Test
    void testPeekDoesNotRemoveElement() {
        Stack stack = new Stack();
        stack.push(20);
        int top = stack.peek();
        assertEquals(20, top, "Peek devrait retourner 20");
        assertEquals(1, stack.size(), "La taille ne devrait pas changer après un peek");
    }

    @Test
    void testPopOnEmptyStackThrowsException() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::pop, "Pop sur une pile vide devrait lancer une exception");
    }

    @Test
    void testPeekOnEmptyStackThrowsException() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::peek, "Peek sur une pile vide devrait lancer une exception");
    }

    @Test
    void testExpandArray() {
        Stack stack = new Stack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size(), "Après avoir ajouté 15 éléments, la taille devrait être 15");
        assertEquals(14, stack.peek(), "Le sommet de la pile devrait être 14");
    }
}
