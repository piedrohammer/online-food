package com.hammer.online.food.repository;

import com.hammer.online.food.model.IngredientsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientsCategory, Long> {

    List<IngredientsCategory> findRestaurantId(Long id);
}
