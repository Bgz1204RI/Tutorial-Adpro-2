package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public List<Product> findAll() {
        return productData;
    }

    public Product findbyId(String id) {
        for(Product product : productData) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public void deleteById(String id) {
        productData.removeIf(product -> product.getId().equals(id));
    }

}

