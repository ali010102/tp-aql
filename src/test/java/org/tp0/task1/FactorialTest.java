package org.tp0.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FactorialTest {

    @Test
    void testFactorialZero() {
        assertEquals(1, Factorial.factorial(0), "factorial(0) doit être 1");
    }

    @Test
    void testFactorialOne() {
        assertEquals(1, Factorial.factorial(1), "factorial(1) doit être 1");
    }

    @Test
    void testFactorialSmallNumbers() {
        assertEquals(2, Factorial.factorial(2), "factorial(2) doit être 2");
        assertEquals(6, Factorial.factorial(3), "factorial(3) doit être 6");
        assertEquals(24, Factorial.factorial(4), "factorial(4) doit être 24");
        assertEquals(120, Factorial.factorial(5), "factorial(5) doit être 120");
    }

    @Test
    void testFactorialLargerNumber() {
        assertEquals(3628800, Factorial.factorial(10), "factorial(10) doit être 3628800");
    }

    @Test
    void testNegativeInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-5), "factorial(-5) doit lancer IllegalArgumentException");
    }
}
