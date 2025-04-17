package tp2.exo3;

public class UserService {
    private final UtilisateurApi utilisateurApi;
    private tp2.exo2.Utilisateur Utilisateur;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException, tp2.exo2.ServiceException {
        // Vérification simple de la validité
        if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty() ||
                utilisateur.getNom() == null || utilisateur.getNom().isEmpty() ||
                utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Champs utilisateur invalides");
        }

        boolean creation = utilisateurApi.creerUtilisateur(Utilisateur);
        if (!creation) {
            throw new ServiceException("Création de l'utilisateur échouée");
        }

        // L’attribution de l’ID se fait côté mock dans les tests (via doAnswer)
    }
}

