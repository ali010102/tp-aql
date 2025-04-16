package tp1.exo4;

public class QuadraticEquationCorrige {

    // Méthode statique pour résoudre l'équation quadratique ax^2 + bx + c = 0
    public static double[] solve(double a, double b, double c) {
        // Si a est égal à zéro, l'équation n'est pas du second degré
        if (a == 0) {
            throw new IllegalArgumentException("a must not be zero");
        }

        // Calcul du discriminant (delta)
        double delta = (b * b) - (4 * a * c);

        // Si delta est négatif, il n'y a pas de racines réelles
        if (delta < 0) {
            return null;
        }

        // Si delta est nul, il y a une racine réelle
        if (delta == 0) {
            return new double[]{-b / (2 * a)};
        }

        // Si delta est positif, il y a deux racines réelles distinctes
        return new double[]{
                (-b + Math.sqrt(delta)) / (2 * a),
                (-b - Math.sqrt(delta)) / (2 * a)
        };
    }
}
