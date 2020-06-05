package com.gus.microservice.item.store.repository;

import com.gus.microservice.item.store.jpo.ItemJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemJpo, String> {
}
