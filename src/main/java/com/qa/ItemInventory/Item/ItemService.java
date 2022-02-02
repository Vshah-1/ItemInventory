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

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getById(long id) {
        return itemRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Item with  id " + id + " does not exist");
        });
    }

    public Item create(Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

    public Item update(long id, Item item) {
        if (itemRepository.existsById(id)) {
            Item itemInDb = itemRepository.getById(id);

            itemInDb.setName(item.getName());
            itemInDb.setDescription(item.getDescription());

            return itemRepository.save(itemInDb);
        } else {
            throw new EntityNotFoundException("Item with id " + id + " does not exist");
        }
    }

    public void delete(long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Item with id " + id + " does not exist");
        }
    }
}


