package com.bebwhepan.app.Models.Sushi;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;

@Data
public class SushiOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Sushi> sushi_lots = new ArrayList<>();

    public void addSushi(Sushi sushi) {
        sushi_lots.add(sushi);    
    }
}
