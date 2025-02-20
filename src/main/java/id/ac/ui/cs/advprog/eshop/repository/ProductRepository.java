package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product getProductById(String productId) {
        Product selectedProduct = null;
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                selectedProduct = product;
            }
        }
        return selectedProduct;
    }

    public Product edit(String productId, Product selectedProduct) {
        String newName = selectedProduct.getProductName();
        int newQuantity = selectedProduct.getProductQuantity();

        Product editedProduct = getProductById(productId);
        if (editedProduct != null) {
            editedProduct.setProductName(newName);
            editedProduct.setProductQuantity(newQuantity);
        }
        return editedProduct;
    }

    public void delete(String productId) {
        productData.remove(getProductById(productId));
    }
}