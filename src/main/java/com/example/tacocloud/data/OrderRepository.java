package com.example.tacocloud.data;

import com.example.tacocloud.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Integer> {
}
