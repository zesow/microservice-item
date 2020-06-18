package com.gus.microservice.item.domain.store;

import com.gus.microservice.item.domain.entity.Item;

import java.util.List;

public interface ItemStore {

    public void create(Item item);
    public Item retrieve(String id);
    public void update(Item item);
    public void delete(String id);

    List<Item> findAll();
}
