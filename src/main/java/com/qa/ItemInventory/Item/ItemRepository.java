package com.qa.ItemInventory.Item;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface ItemRepository
        extends JpaRepository<Item, Long> {
}
