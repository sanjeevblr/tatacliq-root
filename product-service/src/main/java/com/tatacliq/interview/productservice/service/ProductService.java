package com.tatacliq.interview.productservice.service;

import com.tatacliq.interview.productservice.model.Product;
import com.tatacliq.interview.productservice.model.ProductDTO;
import com.tatacliq.interview.productservice.repository.ProductRepository;
import com.tatacliq.interview.productservice.trasformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductTransformer productTransformer;

    @Autowired
    ProductRepository productRepository;

    public void save(ProductDTO productDTO){
        Product product = productTransformer.toProduct(productDTO);
        productRepository.save(product);
    }

    public void update(ProductDTO productDTO){
        productRepository.save(productTransformer.toProduct(productDTO));
    }

    public Optional<ProductDTO> get(Long productId){
        return Optional.of(productTransformer.toProductDTO(productRepository.getOne(productId)));
    }
}
