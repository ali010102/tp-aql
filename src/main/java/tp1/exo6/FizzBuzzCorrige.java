package tp1.exo6;

public class FizzBuzzCorrige {
    // Méthode statique fizzBuzz qui renvoie la chaîne de caractères appropriée
    public static String fizzBuzz(int n) {
        // Vérifie que n est positif (et supérieur à 0)
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        // Si n est divisible par 3 et 5, renvoie "FizzBuzz"
        if (n % 15 == 0) {
            return "FizzBuzz";
        }
        // Si n est divisible par 3, renvoie "Fizz"
        if (n % 3 == 0) {
            return "Fizz";
        }
        // Si n est divisible par 5, renvoie "Buzz"
        if (n % 5 == 0) {
            return "Buzz";
        }
        // Si n n'est divisible ni par 3 ni par 5, renvoie le nombre sous forme de chaîne
        return String.valueOf(n);
    }
}
