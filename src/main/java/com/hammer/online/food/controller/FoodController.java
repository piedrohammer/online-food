package com.hammer.online.food.controller;

import com.hammer.online.food.model.Food;
import com.hammer.online.food.model.Restaurant;
import com.hammer.online.food.model.User;
import com.hammer.online.food.request.CreateFoodRequest;
import com.hammer.online.food.service.FoodService;
import com.hammer.online.food.service.RestaurantService;
import com.hammer.online.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name, @RequestHeader("Authorization") String jwt) throws Exception{

        User user = userService.findUserByJwtToken(jwt);

        List<Food> foods = foodService.searchFood(name);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    public ResponseEntity<List<Food>> getRestaurantFood(@RequestParam boolean vegetarian,
                                                        @RequestParam boolean seasonal,
                                                        @RequestParam boolean noveg,
                                                        @RequestParam(required = false) String food_category,
                                                        @PathVariable Long restaurantId,
                                                        @RequestHeader("Authorization") String jwt) throws Exception{

        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.getRestaurantFood(restaurantId, vegetarian, noveg, seasonal, food_category);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
}
