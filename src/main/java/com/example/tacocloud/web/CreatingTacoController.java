package com.example.tacocloud.web;

import com.example.tacocloud.entity.*;
import com.example.tacocloud.entity.Ingredient.Type;
import com.example.tacocloud.data.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/tof")
@SessionAttributes("tacoOrder")
public class CreatingTacoController {

    private final IngredientRepository ingredientRepository;

    public CreatingTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public String showTacoOrderForm() {
        return "creatingTacoForm";
    }

    @PostMapping
    public String redirectCurrentOrder(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) return "creatingTacoForm";

        tacoOrder.addTaco(taco);
        log.info("taco: {}", taco);

        return "redirect:orders/current";
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
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