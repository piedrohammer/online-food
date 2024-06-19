package com.hammer.online.food.repository;

import com.hammer.online.food.model.Cart;
import com.hammer.online.food.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    public Cart findByCustomerId(Long userId);
}
