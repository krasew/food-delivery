package com.bebwhepan.app.Models;

import java.util.List;

import com.bebwhepan.app.Models.Taco.Taco;
import com.bebwhepan.app.Models.Sushi.Sushi;

import java.util.ArrayList;
import lombok.Data;

@Data

public class Order<T> {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    //private List<Taco> tacos = new ArrayList<>();
    //private List<Sushi> sushi_lots = new ArrayList<>();
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }
    /*public void addTaco(Taco taco) {
        tacos.add(taco);
    }
    public void addSushi(Sushi sushi) {
        sushi_lots.add(sushi);
    }*/
}