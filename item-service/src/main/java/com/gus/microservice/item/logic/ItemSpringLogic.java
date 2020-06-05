package com.gus.microservice.item.logic;

import com.gus.microservice.item.domain.lifecycle.ProxyLifecycle;
import com.gus.microservice.item.domain.lifecycle.StoreLifecycle;
import com.gus.microservice.item.domain.logic.ItemLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemSpringLogic extends ItemLogic {

    public ItemSpringLogic(StoreLifecycle storeLifecycle, ProxyLifecycle proxyLifecycle) {
        super(storeLifecycle, proxyLifecycle);
    }
}
