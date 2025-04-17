package tp2.exo3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UtilisateurApi utilisateurApiMock;
    private UserService userService;

    @BeforeEach
    void setUp() {
        utilisateurApiMock = Mockito.mock(UtilisateurApi.class);
        userService = new UserService(utilisateurApiMock);
    }

    // 1. Test d’exception lors de la création (mock retour false)
    @Test
    void testCreationUtilisateurEchoue() throws ServiceException, tp2.exo2.ServiceException {
        Utilisateur user = new Utilisateur("Samir", "Fail", "fail@email.com");

        when(utilisateurApiMock.creerUtilisateur(any(tp2.exo3.Utilisateur.class))).thenReturn(false);

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(user);
        });

        assertEquals("Création de l'utilisateur échouée", exception.getMessage());
    }

    // 2. Test de validation échouée (champs vides)
    @Test
    void testErreurValidationUtilisateur() throws tp2.exo2.ServiceException, ServiceException {
        Utilisateur user = new Utilisateur("Ali", "", ""); // nom et email invalides

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.creerUtilisateur(user);
        });

        assertEquals("Champs utilisateur invalides", exception.getMessage());
        verify(utilisateurApiMock, never()).creerUtilisateur((tp2.exo3.Utilisateur) any());
    }

    // 3. Test d’attribution d’ID par l’API mockée
    @Test
    void testAttributionIdUtilisateur() throws ServiceException, tp2.exo2.ServiceException {
        Utilisateur user = new Utilisateur("Nadia", "Lounis", "nadia@email.com");

        int idUtilisateur = 123;
        doAnswer(invocation -> {
            Utilisateur u = invocation.getArgument(0);
            u.setId(idUtilisateur);
            return true;
        }).when(utilisateurApiMock).creerUtilisateur(any(tp2.exo3.Utilisateur.class));

        userService.creerUtilisateur(user);

        assertEquals(idUtilisateur, user.getId());
    }

    // 4. Test avec ArgumentCaptor pour vérifier les bons champs
    @Test
    void testCaptorArgumentsUtilisateur() throws ServiceException, tp2.exo2.ServiceException {
        Utilisateur user = new Utilisateur("Karim", "Ziani", "kziani@email.com");

        when(utilisateurApiMock.creerUtilisateur(any(tp2.exo3.Utilisateur.class))).thenReturn(true);

        userService.creerUtilisateur(user);

        ArgumentCaptor<Utilisateur> captor = ArgumentCaptor.forClass(Utilisateur.class);
        verify(utilisateurApiMock).creerUtilisateur(captor.capture());

        Utilisateur captured = captor.getValue();
        assertEquals("Karim", captured.getPrenom());
        assertEquals("Ziani", captured.getNom());
        assertEquals("kziani@email.com", captured.getEmail());
    }
}
