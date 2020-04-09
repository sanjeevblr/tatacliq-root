package com.tatacliq.interview.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Product {

    @Id
    @GeneratedValue
    Long id;

    Long product_id;

    Long sellerId;

    String title;

    String pageTitle;

    String description;

    String manufacturer;

    Price price;

    Boolean isLowQuantity;

    Boolean isSoldOut;

    Boolean isBackorder;

    List<KeyValuePair> metafields;

    Boolean requiresShipping;

    Boolean isVisible;

    Workflow workflow;

    Date publishedAt;

    Date createdAt;

    Date updatedAt;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Price {

        Integer range;

        Integer min;

        Integer max;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class KeyValuePair {
        String key;

        String value;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Workflow {

        String status;
    }
}
