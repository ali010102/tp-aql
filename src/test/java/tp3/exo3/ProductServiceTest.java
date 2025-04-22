package tp3.exo3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Test
    void getProduct_shouldReturnProductFromApiClient() {
        // Arrange
        ProductApiClient productApiClient = Mockito.mock(ProductApiClient.class);
        ProductService productService = new ProductService(productApiClient);
        Product expectedProduct = new Product("123", "Laptop", 1200.00);
        when(productApiClient.getProduct("123")).thenReturn(expectedProduct);

        // Act
        Product actualProduct = productService.getProduct("123");

        // Assert
        assertEquals(expectedProduct, actualProduct);
        verify(productApiClient).getProduct("123");
    }

    @Test
    void getProduct_shouldThrowException_whenApiCallFails() {
        // Arrange
        ProductApiClient productApiClient = Mockito.mock(ProductApiClient.class);
        ProductService productService = new ProductService(productApiClient);
        when(productApiClient.getProduct("456")).thenThrow(new RuntimeException("API call failed"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.getProduct("456"));
        verify(productApiClient).getProduct("456");
    }

    @Test
    void getProduct_shouldHandleInvalidDataFormat() {
        // Arrange
        ProductApiClient productApiClient = Mockito.mock(ProductApiClient.class);
        ProductService productService = new ProductService(productApiClient);
        when(productApiClient.getProduct("789")).thenReturn(new Product("789", null, 0.0)); // Simulate invalid data

        // Act
        Product actualProduct = productService.getProduct("789");

        // Assert
        assertNull(actualProduct.getName());
        assertEquals(0.0, actualProduct.getPrice());
        verify(productApiClient).getProduct("789");
    }
}