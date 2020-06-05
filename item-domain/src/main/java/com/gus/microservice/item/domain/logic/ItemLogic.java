package com.gus.microservice.item.domain.logic;

import com.gus.microservice.item.domain.entity.Item;
import com.gus.microservice.item.domain.spec.ItemService;
import com.gus.microservice.item.domain.lifecycle.ProxyLifecycle;
import com.gus.microservice.item.domain.lifecycle.StoreLifecycle;
import com.gus.microservice.item.domain.proxy.UserProxy;
import com.gus.microservice.item.domain.store.ItemStore;

import java.util.Map;

public class ItemLogic implements ItemService {

    private ItemStore itemStore;

    private final UserProxy userProxy;

    public ItemLogic(StoreLifecycle storeLifecycle, ProxyLifecycle proxyLifecycle)
    {
        this.itemStore = storeLifecycle.requestItemStore();
        this.userProxy = proxyLifecycle.requestUserProxy();
    }

    @Override
    public String register(Item item) {

        String seller = userProxy.findUser(item.getSellerId());
        item.setSeller(seller);

        this.itemStore.create(item);
        return item.getId();
    }

    @Override
    public Item find(String id) {
        return this.itemStore.retrieve(id);
    }

    @Override
    public void modify(String id, Map<String, String> object) {
        Item item = this.itemStore.retrieve(id);
        item.setValues(object);
        this.itemStore.update(item);
    }

    @Override
    public void remove(String id) {
        this.itemStore.delete(id);


    }
}
