package com.ferreteria.api.controller;

import com.ferreteria.api.model.Product;
import com.ferreteria.api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> findAll() throws Exception {
        return service.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) throws Exception {
        return service.save(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) throws Exception {
        Product product = service.findById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product product) throws Exception {
        Product updated = service.update(id, product);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws Exception {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
