package org.tp0.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void testFibonacciZero() {
        assertEquals(0, Fibonacci.fibonacci(0), "fibonacci(0) doit être 0");
    }

    @Test
    void testFibonacciOne() {
        assertEquals(1, Fibonacci.fibonacci(1), "fibonacci(1) doit être 1");
    }

    @Test
    void testFibonacciSmallNumbers() {
        assertEquals(1, Fibonacci.fibonacci(2), "fibonacci(2) doit être 1");
        assertEquals(2, Fibonacci.fibonacci(3), "fibonacci(3) doit être 2");
        assertEquals(3, Fibonacci.fibonacci(4), "fibonacci(4) doit être 3");
        assertEquals(5, Fibonacci.fibonacci(5), "fibonacci(5) doit être 5");
    }

    @Test
    void testFibonacciLargerNumber() {
        assertEquals(21, Fibonacci.fibonacci(8), "fibonacci(8) doit être 21");
        assertEquals(55, Fibonacci.fibonacci(10), "fibonacci(10) doit être 55");
    }

    @Test
    void testNegativeInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1), "fibonacci(-1) doit lancer IllegalArgumentException");
    }
}
