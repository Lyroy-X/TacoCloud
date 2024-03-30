package com.example.tacocloud.data;

import com.example.tacocloud.entity.DeliveryAddress;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryAddressRepository extends CrudRepository<DeliveryAddress, Integer> {
}
