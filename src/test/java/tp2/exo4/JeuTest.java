package tp2.exo4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JeuTest {

    Banque banque;
    Jeu jeu;
    Joueur joueur;
    De de1;
    De de2;

    @BeforeEach
    public void setUp() {
        banque = mock(Banque.class);
        joueur = mock(Joueur.class);
        de1 = mock(De.class);
        de2 = mock(De.class);
        jeu = new Jeu(banque);
    }

    // 1. Test : Jeu fermé -> JeuFermeException
    @Test
    public void testJeuFermeLanceException() {
        jeu.fermer();
        assertThrows(JeuFermeException.class, () -> {
            jeu.jouer(joueur, de1, de2);
        });
    }

    // 2. Test : Joueur insolvable -> DebitImpossibleException
    @Test
    public void testJoueurInsolvableNeJouePas() throws Exception, JeuFermeException {
        when(joueur.mise()).thenReturn(10);
        doThrow(new DebitImpossibleException()).when(joueur).debiter(10);

        jeu.jouer(joueur, de1, de2);

        verify(de1, never()).lancer();
        verify(de2, never()).lancer();
        verify(banque, never()).crediter(anyInt());
        verify(joueur, never()).crediter(anyInt());
    }

    // 3. Test : Lancer ≠ 7 -> joueur perd la mise
    @Test
    public void testPerdQuandLancerDifferentDe7() throws Exception, JeuFermeException {
        when(joueur.mise()).thenReturn(10);
        doNothing().when(joueur).debiter(10);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(2); // total = 5

        jeu.jouer(joueur, de1, de2);

        verify(joueur).debiter(10);
        verify(banque).crediter(10);
        verify(joueur, never()).crediter(anyInt());
        verify(banque, never()).debiter(anyInt());
    }

    // 4. Test : Lancer = 7 et banque solvable
    @Test
    public void testGagneQuandSomme7EtBanqueSolvable() throws Exception, JeuFermeException {
        when(joueur.mise()).thenReturn(10);
        doNothing().when(joueur).debiter(10);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4); // total = 7
        when(banque.est_solvable()).thenReturn(true);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).debiter(10);
        verify(banque).crediter(10);
        verify(joueur).crediter(20); // gain 2x la mise
        verify(banque).debiter(20);
        assertTrue(jeu.estOuvert());
    }

    // 5. Test : Lancer = 7 mais banque insolvable après gain
    @Test
    public void testGagneMaisBanqueInsolvableApresGain() throws Exception, JeuFermeException {
        when(joueur.mise()).thenReturn(15);
        doNothing().when(joueur).debiter(15);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(5); // total = 7
        when(banque.est_solvable()).thenReturn(false);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).crediter(30); // 2 x mise
        verify(banque).debiter(30);
        assertFalse(jeu.estOuvert()); // jeu fermé
    }
}
