package com.gus.microservice.item.store.jpo;

import com.gus.microservice.item.domain.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemJpo {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NM")
    private String name;
    @Column(name = "B_PRC")
    private int buyingPrice;
    @Column(name = "PRC")
    private int price;

    @Column(name = "SELLER")
    private String seller;
    @Column(name = "SELLER_ID")
    private String sellerId;

    public ItemJpo(Item entity) {

        BeanUtils.copyProperties(entity, this);

        this.seller = entity.getSeller();
        this.sellerId = entity.getSellerId();
    }

    public Item toDomain() {
        Item entity = new Item();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }

    public static List<Item> toDomains(Iterable<ItemJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(),false).map(ItemJpo::toDomain).collect(Collectors.toList());
    }
}
