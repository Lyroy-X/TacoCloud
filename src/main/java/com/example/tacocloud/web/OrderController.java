package com.example.tacocloud.web;

import com.example.tacocloud.TacoOrder;
import com.example.tacocloud.data.RepositoryForSave;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final RepositoryForSave<TacoOrder> repository;

    public OrderController(RepositoryForSave<TacoOrder> repository) {
        this.repository = repository;
    }

    @GetMapping("/current")
    public String showCurrentOrderForm() {
        return "currentOrderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder completedTacoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) return "currentOrderForm";

        log.info("Готовый заказ: {}", completedTacoOrder);
        repository.save(completedTacoOrder);
        sessionStatus.setComplete();

        return "orderWaitingForm";
    }
}