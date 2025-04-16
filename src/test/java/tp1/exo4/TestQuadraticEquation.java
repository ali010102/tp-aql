package tp1.exo4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestQuadraticEquation {

    // ✅ Tests pour la version corrigée de la méthode solve
    @Test
    public void testSolve_CorrectRoots() {
        // Cas avec deux racines réelles distinctes
        double[] result1 = QuadraticEquationCorrige.solve(1, -3, 2);
        assertArrayEquals(new double[]{2.0, 1.0}, result1);

        // Cas avec une seule racine réelle
        double[] result2 = QuadraticEquationCorrige.solve(1, 2, 1);
        assertArrayEquals(new double[]{-1.0}, result2);
    }

    @Test
    public void testSolve_NoRealRoots() {
        // Cas sans racines réelles (delta < 0)
        double[] result3 = QuadraticEquationCorrige.solve(1, 0, 1);
        assertNull(result3);
    }

    @Test
    public void testSolve_aZero_ShouldThrowException() {
        // Cas où a = 0, doit lancer une exception
        assertThrows(IllegalArgumentException.class, () -> {
            QuadraticEquationCorrige.solve(0, 2, 1);
        });
    }

    // ❌ Tests pour la version fautive (si elle existait)
    // Ajouter des tests pour une version incorrecte de la méthode solve si besoin
}
