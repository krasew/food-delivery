package com.bebwhepan.app.Models.Sushi;

import java.util.HashMap;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
//import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.bebwhepan.app.Models.Sushi.IngredientSushi.SushiType;

@Component
public class IngredientByIdConverterSushi implements Converter<String, IngredientSushi> {
    private Map<String, IngredientSushi> ingredientMapS = new HashMap<>();

    public IngredientByIdConverterSushi() {
        ingredientMapS.put("CPHIL", new IngredientSushi("CPHIL", "Cold Philadelphia", SushiType.PHIL));
        ingredientMapS.put("HPHIL", new IngredientSushi("HPHIL", "Tempura Philadelphia", SushiType.PHIL));
        ingredientMapS.put("CCALIF", new IngredientSushi("CCALIF", "Cold California", SushiType.CALIF));
        ingredientMapS.put("HCALIF", new IngredientSushi("HCALIF", "Tempura California", SushiType.CALIF));
        ingredientMapS.put("CKIO", new IngredientSushi("CKIO", "Cold Kioto", SushiType.KIO));
        ingredientMapS.put("HKIO", new IngredientSushi("HKIO", "Tempura Kioto", SushiType.KIO));
        ingredientMapS.put("CNIK", new IngredientSushi("CNIK", "Cold Nikko", SushiType.NIK));
        ingredientMapS.put("HNIK", new IngredientSushi("HNIK", "Tempura Nikko", SushiType.NIK));
        ingredientMapS.put("CKRISPI", new IngredientSushi("CKRISPI", "Cold Krispi", SushiType.KRISPI));
        ingredientMapS.put("HKRISPI", new IngredientSushi("HKRISPI", "Tempura Krispi", SushiType.KRISPI));
        ingredientMapS.put("HOVARA", new IngredientSushi("HOVARA", "Cold Ovara", SushiType.OVARA));
        ingredientMapS.put("COVARA", new IngredientSushi("COVARA", "Tempura Ovara", SushiType.OVARA));
    }

    @Override
    public IngredientSushi convert(String id) {
        return ingredientMapS.get(id);
    }
}
