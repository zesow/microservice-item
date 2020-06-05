package com.gus.microservice.item.bind;

import com.gus.microservice.item.domain.proxy.UserProxy;
import com.gus.microservice.user.client.UserClient;
import com.gus.microservice.user.domain.entity.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

@Service
@EnableFeignClients(basePackages = "com.gus.microservice.user.client")
public class UserDelegator implements UserProxy {

    private final UserClient userClient;

    public UserDelegator(UserClient userClient) {
        this.userClient = userClient;
    }

    public String findUser(String id) {
        User user = userClient.findUser(id);
        return user.getName();
    }
}
