package com.tatacliq.interview.productservice.model;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    Long product_id;

    Long sellerId;

    String title;

    String pageTitle;

    String description;

    String manufacturer;

    PriceDTO price;

    Boolean isLowQuantity;

    Boolean isSoldOut;

    Boolean isBackorder;

    List<KeyValuePairDTO> metafields;

    Boolean requiresShipping;

    Boolean isVisible;

    WorkflowDTO workflow;


    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class PriceDTO {

        Integer range;

        Integer min;

        Integer max;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class KeyValuePairDTO {

        String key;

        String value;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class WorkflowDTO {
        String status;
    }
}
