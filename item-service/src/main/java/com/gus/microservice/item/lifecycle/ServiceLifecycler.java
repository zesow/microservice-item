package com.gus.microservice.item.lifecycle;

import com.gus.microservice.item.domain.spec.ItemService;
import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifecycle {

    private final ItemService itemService;

    public ServiceLifecycler(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public ItemService requestItemService() {
        return this.itemService;
    }
}
