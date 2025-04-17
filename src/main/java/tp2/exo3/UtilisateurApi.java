package tp2.exo3;

import tp2.exo2.ServiceException;
import tp2.exo2.Utilisateur;

public interface UtilisateurApi {
    boolean creerUtilisateur(Utilisateur utilisateur) throws ServiceException;

    Boolean creerUtilisateur(tp2.exo3.Utilisateur capture);
}
