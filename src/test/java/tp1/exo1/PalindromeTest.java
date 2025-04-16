package tp1.exo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    public void testIsPalindrome_shouldFailWithOriginal() {
        assertTrue(Palindrome.isPalindrome("abcba")); // 5 caractères → boucle tourne 2 fois
    }

    @Test
    public void testIsPalindrome_shouldPassWithCorrection() {
        assertTrue(PalindromCorrige.isPalindrome("abcba"));
    }
}
