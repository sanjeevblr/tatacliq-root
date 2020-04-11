package com.tatacliq.interview.productservice.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"publishedAt", "createdAt","updatedAt", "metafields"})
@ToString(exclude = {"publishedAt", "createdAt","updatedAt","metafields"})
@Entity
public class Product {

    @Id
    Long product_id;

    Long sellerId;

    String title;

    String pageTitle;

    String description;

    String manufacturer;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "price_id")
    Price price;

    Boolean isLowQuantity;

    Boolean isSoldOut;

    Boolean isBackorder;

    @OneToMany(mappedBy = "product")
    List<KeyValuePair> metafields;

    Boolean requiresShipping;

    Boolean isVisible;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "workflow_id")
    Workflow workflow;

    LocalDateTime publishedAt;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        publishedAt = createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    @Entity
    @ToString(exclude = {"id"})
    @EqualsAndHashCode(exclude = {"id"})
    public static class Price {

        @Id
        @GeneratedValue
        Integer id;

        Integer range;

        Integer min;

        Integer max;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    @Entity
    @ToString(exclude = {"product","id"})
    @EqualsAndHashCode(exclude = {"product","id"})
    public static class KeyValuePair {
        @Id
        @GeneratedValue
        Integer id;

        String key;

        String value;

        @ManyToOne
        @JoinColumn(name="product_id", nullable=false)
        Product product;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    @Entity
    @ToString(exclude = {"id"})
    @EqualsAndHashCode(exclude = {"id"})
    public static class Workflow {

        @Id
        @GeneratedValue
        Integer id;

        String status;
    }
}
