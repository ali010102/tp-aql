package org.tp0.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MatrixTest {

    @Test
    void testSetAndGet() {
        Matrix matrix = new Matrix(3);
        matrix.set(1, 2, 7);
        assertEquals(7, matrix.get(1, 2));
    }

    @Test
    void testAddMatricesSuccessfully() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);

        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(1, 0, 3);
        m1.set(1, 1, 4);

        m2.set(0, 0, 5);
        m2.set(0, 1, 6);
        m2.set(1, 0, 7);
        m2.set(1, 1, 8);

        m1.add(m2);

        assertEquals(6, m1.get(0, 0));
        assertEquals(8, m1.get(0, 1));
        assertEquals(10, m1.get(1, 0));
        assertEquals(12, m1.get(1, 1));
    }

    @Test
    void testAddNullMatrixThrowsException() {
        Matrix m1 = new Matrix(2);
        assertThrows(NullPointerException.class, () -> m1.add(null));
    }

    @Test
    void testAddDifferentSizeMatrixThrowsException() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.add(m2));
    }

    @Test
    void testMultiplyMatricesSuccessfully() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);

        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(1, 0, 3);
        m1.set(1, 1, 4);

        m2.set(0, 0, 2);
        m2.set(0, 1, 0);
        m2.set(1, 0, 1);
        m2.set(1, 1, 2);

        m1.multiply(m2);

        assertEquals(4, m1.get(0, 0));
        assertEquals(4, m1.get(0, 1));
        assertEquals(10, m1.get(1, 0));
        assertEquals(8, m1.get(1, 1));
    }

    @Test
    void testMultiplyNullMatrixThrowsException() {
        Matrix m1 = new Matrix(2);
        assertThrows(NullPointerException.class, () -> m1.multiply(null));
    }

    @Test
    void testMultiplyDifferentSizeMatrixThrowsException() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.multiply(m2));
    }

    @Test
    void testTransposeMatrix() {
        Matrix m = new Matrix(2);
        m.set(0, 0, 1);
        m.set(0, 1, 2);
        m.set(1, 0, 3);
        m.set(1, 1, 4);

        m.transpose();

        assertEquals(1, m.get(0, 0));
        assertEquals(3, m.get(0, 1));
        assertEquals(2, m.get(1, 0));
        assertEquals(4, m.get(1, 1));
    }

    @Test
    void testToStringMatrix() {
        Matrix m = new Matrix(2);
        m.set(0, 0, 1);
        m.set(0, 1, 2);
        m.set(1, 0, 3);
        m.set(1, 1, 4);

        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, m.toString());
    }
}
