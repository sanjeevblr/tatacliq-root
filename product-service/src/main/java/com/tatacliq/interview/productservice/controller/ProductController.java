package com.tatacliq.interview.productservice.controller;

import com.tatacliq.interview.productservice.model.ProductDTO;
import com.tatacliq.interview.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> getProduct(@RequestParam(name = "product_id") Long productId){
        return ResponseEntity.ok(productService.get(productId).get());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
