package com.tatacliq.interview.productservice.repository;

import com.tatacliq.interview.productservice.model.Product;
import com.tatacliq.interview.productservice.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldSaveAProduct(){
        Product product = Product.builder()
                .createdAt(new Date())
                .description("Some Description")
                .isBackorder(true)
                .isLowQuantity(true)
                .isSoldOut(true)
                .isVisible(true)
                .manufacturer("Samsung")
                .metafields(Arrays.asList(Product.KeyValuePair.builder().key("key1").value("value").build()))
                .pageTitle("Some Page Title")
                .price(Product.Price.builder().max(5).min(1).range(4).build())
                .product_id(2L)
                .publishedAt(new Date())
                .requiresShipping(true)
                .sellerId(3L)
                .title("Some Tile")
                .updatedAt(new Date())
                .workflow(Product.Workflow.builder().status("new").build())
                .build();

        productRepository.save(product);
        List<Product> all = productRepository.findAll();
        Assertions.assertThat(all).isNotEmpty();
        Assertions.assertThat(all.stream().findFirst()).isEqualTo(product);

    }

}