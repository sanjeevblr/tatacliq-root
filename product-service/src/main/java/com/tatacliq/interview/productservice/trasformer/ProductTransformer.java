package com.tatacliq.interview.productservice.trasformer;

import com.tatacliq.interview.productservice.model.Product;
import com.tatacliq.interview.productservice.model.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class ProductTransformer {

    public Product toProduct(ProductDTO productDTO){
        List<Product.KeyValuePair> metafields = productDTO.getMetafields().stream()
                .map(keyValuePairDTO -> Product.KeyValuePair.builder().key(keyValuePairDTO.getKey()).value(keyValuePairDTO.getValue()).build())
                .collect(toList());

        ProductDTO.PriceDTO priceDTO = productDTO.getPrice();

        ProductDTO.WorkflowDTO workflowDTO = productDTO.getWorkflow();

        return Product.builder()
                .description(productDTO.getDescription())
                .isBackorder(productDTO.getIsBackorder())
                .isLowQuantity(productDTO.getIsLowQuantity())
                .isSoldOut(productDTO.getIsSoldOut())
                .isVisible(productDTO.getIsVisible())
                .manufacturer(productDTO.getManufacturer())
                .metafields(metafields)
                .pageTitle(productDTO.getPageTitle())
                .price(Product.Price.builder().max(priceDTO.getMax()).min(priceDTO.getMin()).range(priceDTO.getRange()).build())
                .product_id(productDTO.getProduct_id())
                .requiresShipping(productDTO.getRequiresShipping())
                .sellerId(productDTO.getSellerId())
                .title(productDTO.getTitle())
                .workflow(Product.Workflow.builder().status(workflowDTO.getStatus()).build())
                .build();
    }

    public ProductDTO toProductDTO(Product product){
        List<ProductDTO.KeyValuePairDTO> metafields = product.getMetafields().stream()
                .map(keyValuePair -> ProductDTO.KeyValuePairDTO.builder().key(keyValuePair.getKey()).value(keyValuePair.getValue()).build())
                .collect(toList());

        Product.Price price = product.getPrice();

        Product.Workflow workflow = product.getWorkflow();

        return ProductDTO.builder()
                .description(product.getDescription())
                .isBackorder(product.getIsBackorder())
                .isLowQuantity(product.getIsLowQuantity())
                .isSoldOut(product.getIsSoldOut())
                .isVisible(product.getIsVisible())
                .manufacturer(product.getManufacturer())
                .metafields(metafields)
                .pageTitle(product.getPageTitle())
                .price(ProductDTO.PriceDTO.builder().max(price.getMax()).min(price.getMin()).range(price.getRange()).build())
                .product_id(product.getProduct_id())
                .requiresShipping(product.getRequiresShipping())
                .sellerId(product.getSellerId())
                .title(product.getTitle())
                .workflow(ProductDTO.WorkflowDTO.builder().status(workflow.getStatus()).build())
                .build();
    }
}
