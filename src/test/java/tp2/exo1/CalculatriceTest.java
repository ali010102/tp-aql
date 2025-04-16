package tp2.exo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Arrange : on définit le comportement du mock
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // Act : appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // Assert : vérification du résultat
        assertEquals(5, resultat);

        // Vérification que la méthode "additionner" a été appelée avec les bons arguments
        verify(calculatrice).additionner(2, 3);

        // Vérification qu'aucune autre méthode n'a été appelée sur l'objet mocké
        verifyNoMoreInteractions(calculatrice);

        // ⚠️ Note : La méthode getState() n'existe pas dans la classe Calculatrice.
        // Si elle existait, on l'aurait vérifiée ici, par exemple :
        // verify(calculatrice).getState();
    }
}

