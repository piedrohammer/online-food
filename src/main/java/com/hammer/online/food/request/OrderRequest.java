package com.hammer.online.food.request;

import com.hammer.online.food.model.Address;
import lombok.Data;

@Data
public class OrderRequest {

    private Long restaurantId;
    private Address deliveryAddress;
}
