package com.trunk.cartservice.dto;

import com.google.gson.annotations.SerializedName;
import org.hibernate.annotations.Type;

import java.util.List;

public class CartDto {
    private int userId;
    @Type(type = "text")
    private String cartDescription;
    private List<MyCart> myCart = null;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCartDescription() {
        return cartDescription;
    }

    public void setCartDescription(String cartDescription) {
        this.cartDescription = cartDescription;
    }

    public List<MyCart> getMyCart() {
        return myCart;
    }

    public void setMyCart(List<MyCart> myCart) {
        this.myCart = myCart;
    }
}
