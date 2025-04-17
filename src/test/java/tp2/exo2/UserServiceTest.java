package tp2.exo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    // 1. Exception lors de la création
    @Test(expected = ServiceException.class)
    public void testCreationUtilisateurEchoue() throws ServiceException {
        Utilisateur user = new Utilisateur("Samir", "Fail", "fail@email.com");

        doThrow(new ServiceException("Échec de la création")).when(utilisateurApiMock)
                .creerUtilisateur(any(Utilisateur.class));

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(user);
    }

    // 2. Erreur de validation
    @Test(expected = IllegalArgumentException.class)
    public void testErreurValidationUtilisateur() throws ServiceException {
        Utilisateur user = new Utilisateur("Ali", "", ""); // Invalide

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(user);

        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    // 3. Vérification de l’ID après appel
    @Test
    public void testAttributionIdUtilisateur() throws ServiceException {
        Utilisateur user = new Utilisateur("Nadia", "Lounis", "nadia@email.com");
        int idUtilisateur = 123;

        doAnswer(invocation -> {
            Utilisateur arg = invocation.getArgument(0);
            arg.setId(idUtilisateur);
            return true;
        }).when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(user);

        assertEquals(idUtilisateur, user.getId());
    }

    // 4. Capture des arguments envoyés
    @Test
    public void testCaptorArgumentsUtilisateur() throws ServiceException {
        Utilisateur user = new Utilisateur("Karim", "Ziani", "kziani@email.com");

        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(user);

        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals("Karim", utilisateurCapture.getPrenom());
        assertEquals("Ziani", utilisateurCapture.getNom());
        assertEquals("kziani@email.com", utilisateurCapture.getEmail());
    }
}
