package com.bebwhepan.app.Data;

import java.util.Optional;
import com.bebwhepan.app.Models.Taco.IngredientTaco;

public interface IngredientRepository{
    
    Iterable<IngredientTaco> findAll();

    Optional<IngredientTaco> findById(String id);

    IngredientTaco save(IngredientTaco ingredient);

}
