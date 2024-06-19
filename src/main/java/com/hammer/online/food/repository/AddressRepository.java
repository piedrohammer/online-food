package com.hammer.online.food.repository;

import com.hammer.online.food.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
