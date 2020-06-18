package com.gus.microservice.item.domain.spec;

import com.gus.microservice.item.domain.entity.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {

    public String register(Item item);
    public Item find(String id);
    public void modify(String id, Map<String,String> object);
    public void remove(String id);

    List<Item> findAll();
}
