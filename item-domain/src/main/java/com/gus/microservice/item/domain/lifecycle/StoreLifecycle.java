package com.gus.microservice.item.domain.lifecycle;

import com.gus.microservice.item.domain.store.ItemStore;

public interface StoreLifecycle {

    ItemStore requestItemStore();
}
