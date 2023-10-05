package com.example.cartmanagment.repository;

import com.example.cartmanagment.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Integer> {
}
