package com.bebwhepan.app.Data;

import com.bebwhepan.app.Models.Taco.IngredientTaco;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<IngredientTaco, String> { }
