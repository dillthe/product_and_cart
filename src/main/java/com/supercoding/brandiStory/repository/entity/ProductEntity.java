package com.supercoding.brandiStory.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@EqualsAndHashCode(of = "id")
@Entity
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "product_id")
    private Integer productId;

    @Column(name = "product_name", length =255)
    private String productName;

    @Column(name= "price")
    private Integer price;

    @Column(name= "quantity")
    private Integer quantity;

    @Column(name = "company_name", length =255)
    private String companyName;

    @OneToMany(mappedBy = "productEntity")
    private List<CartItemEntity> cartItems;


    @OneToMany(mappedBy = "productEntity", fetch = FetchType.LAZY)
    private List<ImageEntity> imageList;
}
