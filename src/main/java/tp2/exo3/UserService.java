package tp2.exo3;

public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty() ||
                utilisateur.getNom() == null || utilisateur.getNom().isEmpty() ||
                utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Champs utilisateur invalides");
        }

        boolean creation = utilisateurApi.creerUtilisateur(utilisateur);
        if (!creation) {
            throw new ServiceException("Création de l'utilisateur échouée");
        }
    }
}
