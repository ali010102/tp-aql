package tp1.exo5;

public class RomanNumeralCorrige {
    // Méthode statique pour convertir un entier en chiffre romain
    public static String toRoman(int n) {
        // Vérifie que n est dans l'intervalle acceptable
        if (n < 1 || n > 3999) {
            throw new IllegalArgumentException("n must be between 1 and 3999");
        }

        // Tableau des symboles romains et leurs valeurs correspondantes
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();

        // Conversion du nombre en chiffre romain
        for (int i = 0; i < symbols.length; i++) {  // Boucle corrigée : i < symbols.length
            while (n >= values[i]) {  // Tant que n est supérieur ou égal à la valeur
                sb.append(symbols[i]);  // Ajoute le symbole romain
                n -= values[i];  // Soustrait la valeur de n
            }
        }

        return sb.toString();  // Retourne le chiffre romain
    }
}
