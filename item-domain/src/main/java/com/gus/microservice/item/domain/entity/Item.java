package com.gus.microservice.item.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class Item {

    private String id;
    private String name;
    private int buyingPrice;
    private int price;

    private String seller;
    private String sellerId;

    public Item() {
        super();
        this.id = UUID.randomUUID().toString();
    }

    public void setValues(Map<String,String> object) {
        Set<String> keys = object.keySet();

        for(String key : keys) {
            if(key.equals("name")) {
                this.name = object.get(key);
                break;
            }
            else if(key.equals("buyingPrice")) {
                this.buyingPrice = Integer.valueOf(object.get(key));
                break;
            }
            else{
                this.price = Integer.valueOf(object.get(key));
                break;
            }
        }

    }
}
