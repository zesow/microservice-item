package com.gus.microservice.item.domain.lifecycle;

import com.gus.microservice.item.domain.spec.ItemService;

public interface ServiceLifecycle {

    ItemService requestItemService();
}
