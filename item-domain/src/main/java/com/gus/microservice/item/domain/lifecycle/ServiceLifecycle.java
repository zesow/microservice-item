package com.gus.microservice.item.domain.lifecycle;

import com.gus.microservice.item.domain.spec.ItemService;
import com.gus.microservice.item.domain.spec.LolService;

public interface ServiceLifecycle {

    ItemService requestItemService();

    LolService requestLolService();
}
