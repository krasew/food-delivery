package com.bebwhepan.app.Models.Taco;

//import java.util.HashMap;
//import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//import com.bebwhepan.app.Models.Taco.IngredientTaco.Type;
import com.bebwhepan.app.Data.IngredientRepository;

@Component
public class IngredientByIdConverterTaco implements Converter<String, IngredientTaco> {
        private IngredientRepository ingredientRepo;

        public IngredientByIdConverterTaco(IngredientRepository ingredientRepo) {
                this.ingredientRepo = ingredientRepo;
        }

        @Override
        public IngredientTaco convert(String id) {
                return ingredientRepo.findById(id).orElse(null);
        }
//     private Map<String, IngredientTaco> ingredientMap = new HashMap<>();

//     public IngredientByIdConverterTaco() {
//         ingredientMap.put("FLTO",
//                 new IngredientTaco("FLTO", "Flour Tortilla", Type.WRAP));
//         ingredientMap.put("COTO",
//                 new IngredientTaco("COTO", "Corn Tortilla", Type.WRAP));
//         ingredientMap.put("GRBF",
//                 new IngredientTaco("GRBF", "Ground Beef", Type.PROTEIN));
//         ingredientMap.put("CARN",
//                 new IngredientTaco("CARN", "Carnitas", Type.PROTEIN));
//         ingredientMap.put("TMTO",
//                 new IngredientTaco("TMTO", "Diced Tomatoes", Type.VEGGIES));
//         ingredientMap.put("LETC",
//                 new IngredientTaco("LETC", "Lettuce", Type.VEGGIES));
//         ingredientMap.put("CHED",
//                 new IngredientTaco("CHED", "Cheddar", Type.CHEESE));
//         ingredientMap.put("JACK",
//                 new IngredientTaco("JACK", "Monterrey Jack", Type.CHEESE));
//         ingredientMap.put("SLSA",
//                 new IngredientTaco("SLSA", "Salsa", Type.SAUCE));
//         ingredientMap.put("SRCR",
//                 new IngredientTaco("SRCR", "Sour Cream", Type.SAUCE));
//     }

//     @Override
//     public IngredientTaco convert(String id) {
//         return ingredientMap.get(id);
//     }
}