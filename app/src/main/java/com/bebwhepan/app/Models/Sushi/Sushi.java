package com.bebwhepan.app.Models.Sushi;

import java.util.List;

//import com.bebwhepan.app.Models.Sushi.IngredientSushi;

import lombok.Data;

@Data
public class Sushi {
    private String name;

    private List<IngredientSushi> ingredientsSushi;
}
