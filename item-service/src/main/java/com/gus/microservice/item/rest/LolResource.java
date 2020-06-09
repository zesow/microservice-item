package com.gus.microservice.item.rest;

import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import com.gus.microservice.item.domain.spec.LolService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/lol")
public class LolResource {

    private final LolService lolService;

    public LolResource(ServiceLifecycle serviceLifecycle) {
        this.lolService = serviceLifecycle.requestLolService();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public String findUserMatchHistoryByUsername(@PathVariable(value="id") String id) {
        return lolService.findUserMatchHistoryByUsername(id);
    }
}
