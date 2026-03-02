package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public Product findById(String id) {
        List<Product> products = productRepository.findAll();
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Product not found: " + id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void update(String id, String name, int quantity) {
        // simple in-memory style update by replacing in repo list
        List<Product> products = productRepository.findAll();
        for (Product p : products) {
            if (p.getId().equals(id)) {
                p.setName(name);
                p.setQuantity(quantity);
                return;
            }
        }
        throw new IllegalArgumentException("Product not found: " + id);
    }
}