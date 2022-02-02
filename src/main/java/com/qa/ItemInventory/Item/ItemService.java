package com.qa.ItemInventory.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getById(Long id) {
        if (itemRepository.existsById(id)) {
            return itemRepository.findById(id).get();
        }
        throw new EntityNotFoundException("Item with this id " + id + " does not exist");
    }


}


//return List.of(
//        new Item(
//        1L,
//        "Gilded Key",
//        "Allows player to open locked chests")
//        );