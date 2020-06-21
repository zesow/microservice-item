package com.gus.microservice.item.domain.lifecycle;

import com.gus.microservice.item.domain.spec.ItemService;
import com.gus.microservice.item.domain.spec.lol.LolLevel2Service;
import com.gus.microservice.item.domain.spec.lol.LolLevel3Service;

public interface ServiceLifecycle {

    ItemService requestItemService();

    LolLevel3Service requestLolLevel3Service();
//    LolLevel2Service requestLolLevel2Service();
}
