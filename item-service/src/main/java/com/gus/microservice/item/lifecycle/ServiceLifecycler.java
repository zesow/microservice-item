package com.gus.microservice.item.lifecycle;

import com.gus.microservice.item.domain.spec.ItemService;
import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import com.gus.microservice.item.domain.spec.lol.LolLevel2Service;
import com.gus.microservice.item.domain.spec.lol.LolLevel3Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifecycle {

    private final ItemService itemService;
    private final LolLevel3Service lolLevel3Service;
//    private final LolLevel2Service lolLevel2Service;

    public ServiceLifecycler(
            ItemService itemService
            , LolLevel3Service lolLevel3Service, LolLevel2Service lolLevel2Service) {
        this.itemService = itemService;

        this.lolLevel3Service = lolLevel3Service;
//        this.lolLevel2Service = lolLevel2Service;
    }

    @Override
    public ItemService requestItemService() {
        return this.itemService;
    }

    @Override
    public LolLevel3Service requestLolLevel3Service() {
        return this.lolLevel3Service;
    }

//    @Override
//    public LolLevel2Service requestLolLevel2Service() {
//        return this.lolLevel2Service;
//    }

}
