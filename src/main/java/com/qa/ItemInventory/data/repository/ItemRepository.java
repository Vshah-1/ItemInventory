package com.qa.ItemInventory.data.repository;

import com.qa.ItemInventory.data.entity.Item;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface ItemRepository
        extends JpaRepository<Item, Long> {
}
