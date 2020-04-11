package com.tatacliq.interview.productservice.repository;

import com.tatacliq.interview.productservice.model.Product;
import com.tatacliq.interview.productservice.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
                .requiresShipping(true)
                .sellerId(3L)
                .title("Some Tile")
                .workflow(Product.Workflow.builder().status("new").build())
                .build();

        List<Product.KeyValuePair> metafields = product.getMetafields();
        metafields.get(0).setProduct(product);

        productRepository.save(product);
        List<Product> all = productRepository.findAll();
        Assertions.assertThat(all).isNotEmpty();

        Product actualProduct = all.get(0);

        Assertions.assertThat(actualProduct.getPrice()).isEqualTo(product.getPrice());
        Assertions.assertThat(actualProduct.getWorkflow()).isEqualTo(product.getWorkflow());

        Assertions.assertThat(all.stream().findFirst().get()).isEqualTo(product);

    }

}