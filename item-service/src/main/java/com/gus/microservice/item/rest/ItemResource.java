package com.gus.microservice.item.rest;

import com.gus.microservice.item.domain.entity.Item;
import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import com.gus.microservice.item.domain.spec.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ItemResource {

    public final ItemService itemService;

    public ItemResource(ServiceLifecycle serviceLifecycle) {
        this.itemService = serviceLifecycle.requestItemService();
    }

    @CrossOrigin
    @PostMapping(value = "/")
    public String register(@RequestBody Item item) {
        return itemService.register(item);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Item find(@PathVariable(value = "id") String id) {
        return itemService.find(id);
    }

    @CrossOrigin
    @GetMapping(value= {"","/"})
    public List<Item> findAll(){
        return this.itemService.findAll();
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public void modify(@PathVariable(value = "id") String id, @RequestBody Map<String,String> object) {
        itemService.modify(id,object);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(value = "id") String id) {
        itemService.remove(id);
    }
}
