package org.tp0.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrimeTest {

    @Test
    void testPrimes() {
        assertTrue(Prime.isPrime(2), "2 est premier");
        assertTrue(Prime.isPrime(3), "3 est premier");
        assertTrue(Prime.isPrime(5), "5 est premier");
        assertTrue(Prime.isPrime(7), "7 est premier");
        assertTrue(Prime.isPrime(11), "11 est premier");
        assertTrue(Prime.isPrime(13), "13 est premier");
        assertTrue(Prime.isPrime(17), "17 est premier");
    }

    @Test
    void testNonPrimes() {
        assertFalse(Prime.isPrime(0), "0 n'est pas premier");
        assertFalse(Prime.isPrime(1), "1 n'est pas premier");
        assertFalse(Prime.isPrime(4), "4 n'est pas premier");
        assertFalse(Prime.isPrime(6), "6 n'est pas premier");
        assertFalse(Prime.isPrime(8), "8 n'est pas premier");
        assertFalse(Prime.isPrime(9), "9 n'est pas premier");
        assertFalse(Prime.isPrime(12), "12 n'est pas premier");
    }

    @Test
    void testLargePrime() {
        assertTrue(Prime.isPrime(97), "97 est premier");
    }

    @Test
    void testLargeNonPrime() {
        assertFalse(Prime.isPrime(100), "100 n'est pas premier");
    }
}
