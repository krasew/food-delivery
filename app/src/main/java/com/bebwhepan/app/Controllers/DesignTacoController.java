package com.bebwhepan.app.Controllers;

//import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors; //for 2.3
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;

import com.bebwhepan.app.Models.Taco.Taco;
import com.bebwhepan.app.Models.Taco.TacoOrder;

import jakarta.validation.Valid; //for 2.3.2

import com.bebwhepan.app.Data.IngredientRepository;
import com.bebwhepan.app.Models.Taco.IngredientTaco;
import com.bebwhepan.app.Models.Taco.IngredientTaco.Type;

@Slf4j // its Beb
@Controller
@RequestMapping("/designTaco") //changing
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    
    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<IngredientTaco> ingredients = ingredientRepo.findAll();
        // List<IngredientTaco> ingredients = Arrays.asList(
        //         new IngredientTaco("FLTO", "Flour Tortilla", Type.WRAP),
        //         new IngredientTaco("COTO", "Corn Tortilla", Type.WRAP),
        //         new IngredientTaco("GRBF", "Ground Beef", Type.PROTEIN),
        //         new IngredientTaco("CARN", "Carnitas", Type.PROTEIN),
        //         new IngredientTaco("TMTO", "Diced Tomatoes", Type.VEGGIES),
        //         new IngredientTaco("LETC", "Lettuce", Type.VEGGIES),
        //         new IngredientTaco("CHED", "Cheddar", Type.CHEESE),
        //         new IngredientTaco("JACK", "Monterrey Jack", Type.CHEESE),
        //         new IngredientTaco("SLSA", "Salsa", Type.SAUCE),
        //         new IngredientTaco("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = IngredientTaco.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<IngredientTaco>) ingredients, type)); //changes here
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "designTaco";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors,
        @ModelAttribute TacoOrder tacoOrder) {
            if (errors.hasErrors()) {
                return "designTaco";
                }

            tacoOrder.addTaco(taco);
            log.info("Processing taco: {}", taco);
            return "redirect:/ordersTaco/current";
        }

    private Iterable<IngredientTaco> filterByType(List<IngredientTaco> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}