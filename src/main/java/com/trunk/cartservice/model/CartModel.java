package com.trunk.cartservice.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "carts")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int cartId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "cart_status", columnDefinition = "enum('incart','inorder')")
    private String cartStatus;
    @Type(type = "text")
    @Column(name = "cart_description")
    private String cartDescription;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public String getCartDescription() {
        return cartDescription;
    }

    public void setCartDescription(String cartDescription) {
        this.cartDescription = cartDescription;
    }
}