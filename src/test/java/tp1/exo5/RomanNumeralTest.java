package tp1.exo5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralTest {

    // ✅ Tests pour la version corrigée (RomanNumeralCorrige)
    @Test
    public void testRomanNumeralCorrige_ValidNumbers() {
        assertEquals("I", RomanNumeralCorrige.toRoman(1));
        assertEquals("IV", RomanNumeralCorrige.toRoman(4));
        assertEquals("IX", RomanNumeralCorrige.toRoman(9));
        assertEquals("XIII", RomanNumeralCorrige.toRoman(13));
        assertEquals("XXIV", RomanNumeralCorrige.toRoman(24));
        assertEquals("MCMXCIV", RomanNumeralCorrige.toRoman(1994));
        assertEquals("MMXXIII", RomanNumeralCorrige.toRoman(2023));
        assertEquals("MMMCMXCIX", RomanNumeralCorrige.toRoman(3999));
    }

    @Test
    public void testRomanNumeralCorrige_OutOfBounds() {
        // Test pour les valeurs hors de l'intervalle
        assertThrows(IllegalArgumentException.class, () -> {
            RomanNumeralCorrige.toRoman(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RomanNumeralCorrige.toRoman(4000);
        });
    }

    // ❌ Tests pour la version fautive (RomanNumeral)
    @Test
    public void testRomanNumeral_ValidNumbers() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XIII", RomanNumeral.toRoman(13));
        assertEquals("XXIV", RomanNumeral.toRoman(24));
        assertEquals("MCMXCIV", RomanNumeral.toRoman(1994));
        assertEquals("MMXXIII", RomanNumeral.toRoman(2023));
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }

    @Test
    public void testRomanNumeral_OutOfBounds() {
        // Test pour les valeurs hors de l'intervalle
        assertThrows(IllegalArgumentException.class, () -> {
            RomanNumeral.toRoman(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RomanNumeral.toRoman(4000);
        });
    }
}
