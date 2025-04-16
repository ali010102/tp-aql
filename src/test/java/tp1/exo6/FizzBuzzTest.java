package tp1.exo6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    // ✅ Test pour les entrées valides
    @Test
    public void testFizzBuzz_ValidNumbers() {
        // Cas où n est divisible par 3 et 5 -> "FizzBuzz"
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));

        // Cas où n est divisible uniquement par 3 -> "Fizz"
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));

        // Cas où n est divisible uniquement par 5 -> "Buzz"
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));

        // Cas où n n'est divisible ni par 3 ni par 5 -> renvoie le nombre sous forme de chaîne
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }

    // ❌ Test pour les entrées invalides
    @Test
    public void testFizzBuzz_InvalidNumbers() {
        // Cas où n est 0 -> devrait lever une IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz.fizzBuzz(0);
        });

        // Cas où n est négatif -> devrait lever une IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz.fizzBuzz(-1);
        });

        // Cas où n est 1 -> devrait renvoyer "1" puisque ce n'est ni divisible par 3 ni par 5
        assertEquals("1", FizzBuzz.fizzBuzz(1));
    }

    // ✅ Test pour une valeur minimale valide
    @Test
    public void testFizzBuzz_One() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));  // 1 n'est divisible ni par 3 ni par 5
    }
}
