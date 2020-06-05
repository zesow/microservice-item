package com.gus.microservice.item.domain.lifecycle;

import com.gus.microservice.item.domain.proxy.UserProxy;

public interface ProxyLifecycle {

    UserProxy requestUserProxy();
}
