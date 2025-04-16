package tp1.exo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    // ✅ Tests pour la version corrigée
    @Test
    public void testBinarySearchCorrige_ElementFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearchCorrige.binarySearch(array, 5));
        assertEquals(0, BinarySearchCorrige.binarySearch(array, 1));
        assertEquals(4, BinarySearchCorrige.binarySearch(array, 9));
    }

    @Test
    public void testBinarySearchCorrige_ElementNotFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearchCorrige.binarySearch(array, 2));
        assertEquals(-1, BinarySearchCorrige.binarySearch(array, 10));
    }

    @Test
    public void testBinarySearchCorrige_NullArray() {
        assertThrows(NullPointerException.class, () -> {
            BinarySearchCorrige.binarySearch(null, 5);
        });
    }

    // ❌ Tests pour la version fautive
    @Test
    public void testBinarySearchOriginal_IncorrectResult() {
        int[] array = {1, 3, 5, 7, 9};
        // Devrait retourner 2, mais la boucle peut manquer l’élément
        assertNotEquals(2, BinarySearch.binarySearch(array, 5));
    }

    @Test
    public void testBinarySearchOriginal_NullArray() {
        assertThrows(NullPointerException.class, () -> {
            BinarySearch.binarySearch(null, 5);
        });
    }
}
