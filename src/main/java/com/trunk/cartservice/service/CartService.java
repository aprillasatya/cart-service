package com.trunk.cartservice.service;

import com.trunk.cartservice.dto.CartMapping;
import com.trunk.cartservice.model.CartModel;
import com.trunk.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<CartModel> saveAllToCart(List<CartModel> cartModel){
        return cartRepository.saveAll(cartModel);
    }

    public List<CartMapping> getCartByUserId(int userId){
        return cartRepository.getCartByUserId(userId);
    }
}
