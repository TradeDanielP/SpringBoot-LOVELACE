package com.riwi.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.products.entities.Product;
import com.riwi.products.services.abstract_service.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    
    @Autowired
    private final IProductService objIProductService;

    @GetMapping
    // Response Entity lo utilizamos para responder con los metodos y los status HTTP
    public ResponseEntity<List<Product>> getAll(){
        
        return ResponseEntity.ok(this.objIProductService.getAll());
    }

}
