package tp3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tp3.exo1.User;
import tp3.exo1.UserRepository;
import tp3.exo1.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void getUserById_shouldReturnUserFromRepository() {
        // Arrange
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);
        User expectedUser = new User(1L, "John Doe");
        when(userRepository.findUserById(1L)).thenReturn(expectedUser);

        // Act
        User actualUser = userService.getUserById(1L);

        // Assert
        assertEquals(expectedUser, actualUser);
        verify(userRepository).findUserById(1L); // Verify method call with argument
    }
}