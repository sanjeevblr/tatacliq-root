package com.tatacliq.interview.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tatacliq.interview.productservice.model.Product;
import com.tatacliq.interview.productservice.model.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldSaveAProduct() throws Exception {

        ProductDTO productDTO = ProductDTO.builder()
                .description("Some Description")
                .isBackorder(true)
                .isLowQuantity(true)
                .isSoldOut(true)
                .isVisible(true)
                .manufacturer("Samsung")
                .metafields(Arrays.asList(ProductDTO.KeyValuePairDTO.builder().key("key1").value("value").build()))
                .pageTitle("Some Page Title")
                .price(ProductDTO.PriceDTO.builder().max(5).min(1).range(4).build())
                .product_id(2L)
                .requiresShipping(true)
                .sellerId(3L)
                .title("Some Tile")
                .workflow(ProductDTO.WorkflowDTO.builder().status("new").build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(productDTO);


        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(valueAsString)
        ).andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }
}