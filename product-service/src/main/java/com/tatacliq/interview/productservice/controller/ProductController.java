package com.tatacliq.interview.productservice.controller;

import com.tatacliq.interview.productservice.model.ProductDTO;
import com.tatacliq.interview.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> getProduct(@RequestParam(name = "product_id") Long productId){
        return ResponseEntity.ok(productService.get(productId).get());
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
