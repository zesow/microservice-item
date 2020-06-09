package com.gus.microservice.item.lifecycle;

import com.gus.microservice.item.domain.spec.ItemService;
import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import com.gus.microservice.item.domain.spec.LolService;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifecycle {

    private final ItemService itemService;
    private final LolService lolService;

    public ServiceLifecycler(
            ItemService itemService, LolService lolService) {
        this.itemService = itemService;
        this.lolService = lolService;
    }

    @Override
    public ItemService requestItemService() {
        return this.itemService;
    }

    @Override
    public LolService requestLolService() {
        return this.lolService;
    }
}
