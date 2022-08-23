package com.kurly.delivery.domain.product.model;

import com.kurly.delivery.domain.common.enumerable.Status;
import com.kurly.delivery.domain.common.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTS")
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private ProductCategory productCategory;

    private String name;

    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private Status status;
}
