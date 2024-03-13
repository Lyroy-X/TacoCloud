package com.example.tacocloud.web;

import com.example.tacocloud.Ingredient;
import com.example.tacocloud.Ingredient.Type;
import com.example.tacocloud.Taco;
import com.example.tacocloud.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/tof")
@SessionAttributes("tacoOrder")
public class TacoOrderController {

    @PostMapping
    public String redirectCurrentOrder(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) return "tacoOrderForm";

        tacoOrder.addTaco(taco);
        log.info("taco: {}", taco);

        return "redirect:orders/current";
    }

    @GetMapping
    public String showTacoOrderForm() {
        return "tacoOrderForm";
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient(0, "Flour Tortilla", Type.WRAP),
                new Ingredient(1, "Corn Tortilla", Type.WRAP),
                new Ingredient(2, "Ground Beef", Type.PROTEIN),
                new Ingredient(3, "Carnitas", Type.PROTEIN),
                new Ingredient(4, "Diced Tomatoes", Type.VEGGIES),
                new Ingredient(5, "Lettuce", Type.VEGGIES),
                new Ingredient(6, "Cheddar", Type.CHEESE),
                new Ingredient(7, "Monterrey Jack", Type.CHEESE),
                new Ingredient(8, "Salsa", Type.SAUCE),
                new Ingredient(9, "Sour Cream", Type.SAUCE),
                new Ingredient(10, "Small", Type.SIZE),
                new Ingredient(10, "Medium ", Type.SIZE),
                new Ingredient(10, "Big", Type.SIZE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
}