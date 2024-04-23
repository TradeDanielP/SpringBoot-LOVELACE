package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Product;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.abstract_service.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{

    @Autowired
    private final ProductRepository objRepository;

    @Override
    public Product save(Product objProduct) {
        return this.objRepository.save(objProduct);
    }

    @Override
    public List<Product> getAll() {
        return this.objRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return this.objRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void delete(Long id) {
        Product product = this.objRepository.findById(id).orElseThrow();
        
        this.objRepository.delete(product);
    }

    @Override
    public Product update(Product objProduct) {
        return this.objRepository.save(objProduct);
    }
    


}
