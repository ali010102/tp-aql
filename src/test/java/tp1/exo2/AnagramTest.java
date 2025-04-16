package tp1.exo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    // ✅ Tests de la version corrigée
    @Test
    public void testAnagramCorrige_ValidAnagram() {
        assertTrue(AnagramCorrige.isAnagram("chien", "niche"));
        assertTrue(AnagramCorrige.isAnagram("Clint Eastwood", "Old West Action"));
    }

    @Test
    public void testAnagramCorrige_InvalidAnagram() {
        assertFalse(AnagramCorrige.isAnagram("chien", "chienne"));
        assertFalse(AnagramCorrige.isAnagram("abc", "abd"));
    }

    @Test
    public void testAnagramCorrige_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            AnagramCorrige.isAnagram(null, "test");
        });
    }

    // ❌ Tests sur la classe fautive
    @Test
    public void testAnagramOriginal_Exception() {
        // Utilise une chaîne simple pour forcer le dépassement d'indice
        String s1 = "abc";
        String s2 = "cab";

        Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Anagram.isAnagram(s1, s2);
        });

        System.out.println("Exception message (Anagram Original): " + exception.getMessage());
    }

    @Test
    public void testAnagramOriginal_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            Anagram.isAnagram(null, "test");
        });
    }
}
