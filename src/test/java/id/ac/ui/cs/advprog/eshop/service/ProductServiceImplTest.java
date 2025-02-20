package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl service;

    @Mock
    Model model;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndGetProductById() {
        Product product = new Product();
        product.setProductId("f29b2d8e-d734-4bcb-97a1-c9b48c21196f");
        product.setProductName("Kecap Cap Botol");
        product.setProductQuantity(100);
        Product newProduct = service.create(product);

        assertEquals("f29b2d8e-d734-4bcb-97a1-c9b48c21196f", newProduct.getProductId());
        assertEquals("Kecap Cap Botol", newProduct.getProductName());
        assertEquals(100, newProduct.getProductQuantity());

        when(productRepository.getProductById("f29b2d8e-d734-4bcb-97a1-c9b48c21196f")).thenReturn(product);
        Product obtainedProduct = service.getProductById("f29b2d8e-d734-4bcb-97a1-c9b48c21196f");
        assertEquals(product, obtainedProduct);
    }

    @Test
    void testFindAll() {
        List<Product> expectedList = new ArrayList<>();
        expectedList.add(new Product());
        expectedList.add(new Product());

        when(productRepository.findAll()).thenReturn(expectedList.iterator());
        List<Product> actualList = service.findAll();
        assertEquals(expectedList, actualList);
    }

    @Test
    void testFindAllIfEmpty() {
        when(productRepository.findAll()).thenReturn((new ArrayList<Product>()).iterator());
        List<Product> productList = service.findAll();
        assertTrue(productList.isEmpty());
    }

    @Test
    void testEditProduct() {
        String productId = "f29b2d8e-d734-4bcb-97a1-c9b48c21196f";
        Product editedProduct = new Product();
        editedProduct.setProductName("Kecap Cap Gayung");
        editedProduct.setProductQuantity(25);
        service.edit(productId, editedProduct);
        verify(productRepository, times(1)).edit(productId, editedProduct);
    }

    @Test
    void testDeleteProduct() {
        String productId = "f29b2d8e-d734-4bcb-97a1-c9b48c21196f";
        service.delete(productId);
        verify(productRepository, times(1)).delete(productId);
    }
}