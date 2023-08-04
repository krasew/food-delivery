package com.bebwhepan.app.Controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;

import com.bebwhepan.app.Models.Sushi.Sushi;
import com.bebwhepan.app.Models.Sushi.SushiOrder;
import com.bebwhepan.app.Models.Sushi.IngredientSushi;
import com.bebwhepan.app.Models.Sushi.IngredientSushi.SushiType;

@Slf4j
@Controller
@RequestMapping("/designSushi")
@SessionAttributes("sushiOrder")

public class DesignSushiController {
    @ModelAttribute
    public void addIngredientsToModelSus(Model modelsus) {
        List<IngredientSushi> ingredientsSushi = Arrays.asList(
            new IngredientSushi("CPHIL", "Cold Philadelphia", SushiType.PHIL),
            new IngredientSushi("HPHIL", "Tempura Philadelphia", SushiType.PHIL),
            new IngredientSushi("CCALIF", "Cold California", SushiType.CALIF),
            new IngredientSushi("HCALIF", "Tempura California", SushiType.CALIF),
            new IngredientSushi("CKIO", "Cold Kioto", SushiType.KIO),
            new IngredientSushi("HKIO", "Tempura Kioto", SushiType.KIO),
            new IngredientSushi("CNIK", "Cold Nikko", SushiType.NIK),
            new IngredientSushi("HNIK", "Tempura Nikko", SushiType.NIK),
            new IngredientSushi("CKRISPI", "Cold Krispi", SushiType.KRISPI),
            new IngredientSushi("HKRISPI", "Tempura Krispi", SushiType.KRISPI),
            new IngredientSushi("COVARA", "Cold Ovara", SushiType.OVARA),
            new IngredientSushi("HOVARA", "Tempura Ovara", SushiType.OVARA));
            
        SushiType[] sustypes = SushiType.values();
        
        for (SushiType typesus : sustypes) {
            modelsus.addAttribute(typesus.toString().toLowerCase(), filterByType(ingredientsSushi, typesus)); 
        }
    }

    @ModelAttribute(name = "sushiOrder")
    public SushiOrder order() {
        return new SushiOrder();
    }

    @ModelAttribute(name = "sushi")
    public Sushi sushi() {
        return new Sushi();
    }

    @GetMapping
    public String showDesignForm() {
        return "designSushi";
    }

    @PostMapping
    public String processTaco(Sushi sushi, @ModelAttribute SushiOrder sushiOrder) {
        sushiOrder.addSushi(sushi);
        log.info("Processing sushi: {}", sushi);
        return "redirect:/ordersSushi/current";
    }

    private Iterable<IngredientSushi> filterByType(List<IngredientSushi> ingredientsSushi, SushiType typesus) {
        return ingredientsSushi
                .stream()
                .filter(x -> x.getType().equals(typesus))
                .collect(Collectors.toList());
    }
}
