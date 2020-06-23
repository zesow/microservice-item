package com.gus.microservice.item.rest;

import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import com.gus.microservice.item.domain.spec.lol.LolLevel3Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/lol")
public class LolResource {

    private final LolLevel3Service lolService;

    public LolResource(ServiceLifecycle serviceLifecycle) {
        this.lolService = serviceLifecycle.requestLolLevel3Service();
    }

    @CrossOrigin
    @GetMapping(value = "/findUserMatchHistoryByUsername/{id}")
    public Map<String,Object> findUserMatchHistoryByUsername(@PathVariable(value="id") String id) {
        return lolService.findUserMatchHistoryByUsername(id);
    }

    @CrossOrigin
    @GetMapping(value = "/findUserInfo/{id}")
    public Map<String,Object> findUserInfo(@PathVariable(value="id") String id) {
        return lolService.findUserInfo(id);
    }
}
