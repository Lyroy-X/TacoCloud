package com.example.tacocloud.web;

import com.example.tacocloud.entity.TacoOrder;
import com.example.tacocloud.data.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/current")
    public String showCurrentOrderForm() {
        return "currentOrder";
    }

    @PostMapping("/confirmation")
    public String confirmationOrder(@Valid TacoOrder completedTacoOrder, Errors errors) {
        if (errors.hasErrors()) return "currentOrder";
        return "orderConfirmation";
    }

    @GetMapping("/waiting")
    public String saveTacoOrder(TacoOrder tacoOrder) {
        repository.save(tacoOrder);
        return "orderWaiting";
    }
}