package com.example.cartmanagment.service;

import com.example.cartmanagment.model.CartItem;
import com.example.cartmanagment.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public CartItem createItem(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }

    public List<CartItem> getAll() {
        return cartRepository.findAll();
    }

    public CartItem getById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    public CartItem updateCartItem(Integer id, CartItem cartItem) {
        CartItem cartItemEntity = cartRepository.findById(id).orElse(null);
        if (cartItemEntity != null) {
            cartItemEntity.setNumber(cartItem.getNumber());
            cartItemEntity.setPrice(cartItem.getPrice());
            cartItemEntity.setProductName(cartItem.getProductName());
            cartRepository.save(cartItemEntity);
            return cartItemEntity;
        }
        return null;
    }

    public String deleteById(Integer id) {
        cartRepository.deleteById(id);
        return "success";
    }
}
