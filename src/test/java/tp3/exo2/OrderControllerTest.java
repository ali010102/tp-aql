package tp3.exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Test
    void createOrder_shouldCallOrderService() { // Renomme le test
        // Arrange
        OrderService orderService = Mockito.mock(OrderService.class);
        OrderController orderController = new OrderController(orderService);
        Order order = new Order(1L, "Laptop");

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderService).createOrder(order);
        // Ne vérifie pas orderDao pour l'instant
    }
}