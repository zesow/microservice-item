package com.gus.microservice.item.lifecycle;

import com.gus.microservice.item.domain.lifecycle.ProxyLifecycle;
import com.gus.microservice.item.domain.proxy.UserProxy;
import org.springframework.stereotype.Component;

@Component
public class ProxyLifecycler implements ProxyLifecycle {

    private UserProxy userProxy;

    public ProxyLifecycler(UserProxy userProxy) {
        this.userProxy = userProxy;
    }

    @Override
    public UserProxy requestUserProxy() {
        return this.userProxy;
    }
}
