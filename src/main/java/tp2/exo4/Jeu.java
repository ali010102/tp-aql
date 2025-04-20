// Jeu.java
package tp2.exo4;

public class Jeu {

    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque banque) {
        this.banque = banque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) throw new JeuFermeException();

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            return;
        }

        banque.crediter(mise);

        int total = de1.lancer() + de2.lancer();
        if (total == 7) {
            int gain = 2 * mise;
            joueur.crediter(gain);
            banque.debiter(gain);
            if (!banque.est_solvable()) fermer();
        }
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}
