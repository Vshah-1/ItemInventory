package com.qa.ItemInventory.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    public Item getById(long id) {
        return itemRepository.findById(id).orElseThrow(() -> {
                return new EntityNotFoundException("Item with  id" + id + " does not exist");
            });
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public Item update(long id, Item item) {
        if (itemRepository.existsById(id)) {
            Item itemDb = itemRepository.getById(id);

            itemDb.setName(item.getName());
            itemDb.setDescription(item.getDescription());

            return itemRepository.save(itemDb);
        } else {
            throw new EntityNotFoundException("Item with id" + id + " does not exist");
        }
    }

    public void deleteItem(long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Item with id" + id + " does not exist");
        }
    }
}


