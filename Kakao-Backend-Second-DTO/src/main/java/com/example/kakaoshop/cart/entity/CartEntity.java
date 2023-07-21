package com.example.kakaoshop.cart.entity;

import com.example.kakaoshop.product.entity.ProductOptionEntity;
import com.example.kakaoshop.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cart_entity",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "product_option_id"})
        })
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id")
    private ProductOptionEntity productOption;

    private int quantity;

    @Builder
    public CartEntity(Long id, User user, ProductOptionEntity productOptionEntity, int quantity) {
        this.cartId = id;
        this.user = user;
        this.productOption = productOptionEntity;
        this.quantity = quantity;
    }
}

