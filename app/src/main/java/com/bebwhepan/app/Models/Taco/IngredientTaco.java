package com.bebwhepan.app.Models.Taco;

import lombok.Data;

@Data
public class IngredientTaco {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
