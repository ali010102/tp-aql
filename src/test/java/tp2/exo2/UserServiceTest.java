package tp2.exo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

// Utilise le runner de Mockito pour initialiser automatiquement les mocks
@RunWith(MockitoJUnitRunner.class)

public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock; // Le service API mocké

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // --------------------------
        // 🧪 Arrange : Préparation
        // --------------------------
        // Création d'un utilisateur factice
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Création du service à tester avec injection du mock
        UserService userService = new UserService(utilisateurApiMock);

        // --------------------------
        // 🎯 Act : Action
        // --------------------------
        userService.creerUtilisateur(utilisateur);

        // --------------------------
        // ✅ Assert : Vérifications
        // --------------------------
        // Vérifie que l'appel à l'API a bien eu lieu avec le bon utilisateur
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Vérifie qu'aucune autre interaction n'a été faite avec le mock
        verifyNoMoreInteractions(utilisateurApiMock);
    }

    @Test(expected = ServiceException.class)
    public void testCreerUtilisateur_exception() throws ServiceException {
        // --------------------------
        // 🧪 Arrange
        // --------------------------
        Utilisateur utilisateur = new Utilisateur("Erreur", "Test", "erreur@test.com");

        // On configure le mock pour lancer une exception
        doThrow(new ServiceException("Erreur API")).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);

        // --------------------------
        // 🎯 Act
        // --------------------------
        userService.creerUtilisateur(utilisateur); // Doit lever une exception
    }
}