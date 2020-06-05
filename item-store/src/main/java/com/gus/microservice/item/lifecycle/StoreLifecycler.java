package com.gus.microservice.item.lifecycle;

import com.gus.microservice.item.domain.lifecycle.StoreLifecycle;
import com.gus.microservice.item.domain.store.ItemStore;
import org.springframework.stereotype.Component;

@Component
public class StoreLifecycler implements StoreLifecycle {

    private final ItemStore itemStore;

    public StoreLifecycler(ItemStore itemStore) {
        this.itemStore = itemStore;
    }

    @Override
    public ItemStore requestItemStore() {
        return this.itemStore;
    }
}
