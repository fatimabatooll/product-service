package com.glc.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.product.Model.Product;
import com.glc.product.Repository.ProductRepository;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public void saveProduct(@RequestBody Product product){
        productRepository.save(product);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByid(@PathVariable Long id){
         Product product = productRepository.findById(id).orElse(null);  
         if(product == null){
            return ResponseEntity.status(400).body(null);
         }
         return ResponseEntity.status(200).body(product);  
    }

}