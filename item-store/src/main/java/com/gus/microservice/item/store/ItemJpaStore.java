package com.gus.microservice.item.store;

import com.gus.microservice.item.domain.entity.Item;
import com.gus.microservice.item.domain.store.ItemStore;
import com.gus.microservice.item.store.jpo.ItemJpo;
import com.gus.microservice.item.store.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ItemJpaStore implements ItemStore {

    private final ItemRepository itemRepository;

    public ItemJpaStore(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void create(Item item) {
        itemRepository.save(new ItemJpo(item));
    }

    @Override
    public Item retrieve(String id) {
        Optional<ItemJpo> itemJpo = itemRepository.findById(id);
        if(!itemJpo.isPresent()) {
            throw new NoSuchElementException("");
        }

        return itemJpo.get().toDomain();
    }

    @Override
    public void update(Item item) {

        itemRepository.save(new ItemJpo(item));
    }

    @Override
    public void delete(String id) {

        itemRepository.deleteById(id);

    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll().stream().map(ItemJpo::toDomain).collect(Collectors.toList());
    }
}
