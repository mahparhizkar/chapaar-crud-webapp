package com.chapaar.crud.service;

import com.chapaar.crud.exception.NotFoundException;
import com.chapaar.crud.model.Product;
import com.chapaar.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product getProduct(long id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("ProductId " + id + " doesn't exist"));
    }

    @Transactional
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void delete(long orderItemId) {
        productRepository.deleteById(orderItemId);
    }
}
