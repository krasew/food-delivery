package com.bebwhepan.app.Models.Sushi;


import lombok.Data;

@Data
public class IngredientSushi {
    private final String id;
    private final String name;
    private final SushiType type;

    public enum SushiType {
        PHIL, CALIF, KIO, NIK, KRISPI, OVARA
    }
}
