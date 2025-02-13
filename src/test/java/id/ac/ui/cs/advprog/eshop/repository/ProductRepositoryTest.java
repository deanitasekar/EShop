package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bff-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEdit(){
        Product product = new Product();
        product.setProductId("ebb558egf-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product updatedProduct = new Product();
        updatedProduct.setProductName("Sampo Cap Bango");
        updatedProduct.setProductQuantity(250);
        productRepository.edit(product.getProductId(), updatedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product editedProduct = productIterator.next();
        assertEquals(updatedProduct.getProductName(), editedProduct.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), editedProduct.getProductQuantity());
        assertEquals(product.getProductId(), editedProduct.getProductId());
    }

    @Test
    void testEditIfEmpty() {
        Product selectedProduct = new Product();
        selectedProduct.setProductId("abcd58egf-1c39-460e-8860");
        selectedProduct.setProductName("Sampo Cap Kuda");
        selectedProduct.setProductQuantity(400);
        Product result = productRepository.edit(selectedProduct.getProductId(), selectedProduct);
        assertNull(result);
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(50);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("aof9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Agus");
        product2.setProductQuantity(500);
        productRepository.create(product2);

        Product updatedProduct = new Product();
        updatedProduct.setProductId(product1.getProductId());
        updatedProduct.setProductName("Sampo Cap Cecep");
        updatedProduct.setProductQuantity(150);
        productRepository.edit(product1.getProductId(), updatedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product editedProduct1 = productIterator.next();
        assertEquals(updatedProduct.getProductId(), editedProduct1.getProductId());
        assertEquals(updatedProduct.getProductName(), editedProduct1.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), editedProduct1.getProductQuantity());
        Product editedProduct2 = productIterator.next();
        assertEquals(product2.getProductId(), editedProduct2.getProductId());
        assertEquals(product2.getProductName(), editedProduct2.getProductName());
        assertEquals(product2.getProductQuantity(), editedProduct2.getProductQuantity());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(75);
        productRepository.create(product);

        productRepository.delete(product.getProductId());
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteIfEmpty() {
        productRepository.delete("11235-abcdshe1f-1c39-460e-8860");
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Agus");
        product2.setProductQuantity(250);
        productRepository.create(product2);

        productRepository.delete(product1.getProductId());
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }
}