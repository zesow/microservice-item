package com.gus.microservice.item.rest;

import com.gus.microservice.item.domain.entity.Item;
import com.gus.microservice.item.domain.spec.ItemService;
import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/item")
public class ItemResource {

    public final ItemService itemService;

    public ItemResource(ServiceLifecycle serviceLifecycle) {
        this.itemService = serviceLifecycle.requestItemService();
    }

    @PostMapping(value = "/")
    public String register(@RequestBody Item item) {
        return itemService.register(item);
    }

    @GetMapping(value = "/{id}")
    public Item find(@PathVariable(value = "id") String id) {
        return itemService.find(id);
    }

    @PutMapping(value = "/{id}")
    public void modify(@PathVariable(value = "id") String id, @RequestBody Map<String,String> object) {
        itemService.modify(id,object);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(value = "id") String id) {
        itemService.remove(id);
    }
}
