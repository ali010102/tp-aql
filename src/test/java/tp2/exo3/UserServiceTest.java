package tp2.exo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    // 1. Exception lors de la création
    @Test(expected = ServiceException.class)
    public void testCreationUtilisateurEchoue() throws ServiceException, tp2.exo2.ServiceException {
        Utilisateur user = new Utilisateur("Samir", "Fail", "fail@email.com");

        doThrow(new ServiceException("Échec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(user);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(user);
    }

    // 2. Erreur de validation
    @Test(expected = IllegalArgumentException.class)
    public void testErreurValidationUtilisateur() throws ServiceException, tp2.exo2.ServiceException {
        Utilisateur user = new Utilisateur("Ali", "", ""); // invalide

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(user);

        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    // 3. Vérification de l’ID après appel
    @Test
    public void testAttributionIdUtilisateur() throws ServiceException, tp2.exo2.ServiceException {
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

    // 4. Capturer les arguments
    @Test
    public void testCaptorArgumentsUtilisateur() throws ServiceException, tp2.exo2.ServiceException {
        Utilisateur user = new Utilisateur("Karim", "Ziani", "kziani@email.com");

        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(user);

        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals("Karim", utilisateurCapture.getPrenom());
        assertEquals("Ziani", utilisateurCapture.getNom());
        assertEquals("kziani@email.com", utilisateurCapture.getEmail());
    }
}
