package com.trunk.cartservice.controller;

import com.trunk.cartservice.dto.CartDto;
import com.trunk.cartservice.model.CartModel;
import com.trunk.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping(value = "/add")
    public ResponseEntity createCart(HttpServletRequest request, HttpServletResponse response, @RequestBody CartDto cartDto){
        List<CartModel> cartModelList = new ArrayList<CartModel>();
        cartDto.getMyCart().forEach(v -> {
            CartModel cartModel = new CartModel();
            cartModel.setUserId(cartDto.getUserId());
            cartModel.setProductId(v.getProductId());
            cartModel.setCartStatus("incart");
            cartModel.setCartDescription(cartDto.getCartDescription());
            cartModelList.add(cartModel);
        });

        try {
            cartService.saveAllToCart(cartModelList);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/myCart/{userId}")
    public ResponseEntity getCartByUserId(HttpServletRequest request, HttpServletResponse response,
                                                             @PathVariable("userId") int userId){
        List<Object> objectList = new ArrayList<Object>();

        // you can define some condition for check size in here or make error handling
        cartService.getCartByUserId(userId).stream().filter(v -> v.getProductStatus().equals("active")).forEach(o -> {
            Map mappingResult = new HashMap<>();
            mappingResult.put("userName", o.getUserName().toUpperCase());
            mappingResult.put("productName", o.getProductName());
            mappingResult.put("productPrice", o.getProductPrice());
            mappingResult.put("productDesc", o.getProductDesc());
            mappingResult.put("productStatus", o.getProductStatus());
            objectList.add(mappingResult);
        });

        return ResponseEntity.status(HttpStatus.OK).body(objectList);
    }
}
