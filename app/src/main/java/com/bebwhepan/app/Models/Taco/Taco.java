package com.bebwhepan.app.Models.Taco;

import java.util.List;

//import com.bebwhepan.app.Models.Taco.IngredientTaco;

import lombok.Data;

@Data
public class Taco {
    private String name;

    private List<IngredientTaco> ingredients;
}