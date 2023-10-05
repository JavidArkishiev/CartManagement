package com.example.cartmanagment.controller;

import com.example.cartmanagment.model.CartItem;
import com.example.cartmanagment.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartItem")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartItem> createItem(@RequestBody CartItem cartItem) {
        return new ResponseEntity<>(cartService.createItem(cartItem), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCArtItem() {
        return new ResponseEntity<>(cartService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getById(@PathVariable Integer id) {
        CartItem cartItem = cartService.getById(id);
        if (cartItem == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cartService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Integer id, @RequestBody CartItem cartItem) {
        CartItem cartItem1 = cartService.updateCartItem(id, cartItem);
        if (cartItem1 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cartService.updateCartItem(id, cartItem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCartItem(@PathVariable Integer id) {
        return new ResponseEntity<>(cartService.deleteById(id), HttpStatus.OK);
    }
}
