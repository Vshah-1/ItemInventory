package com.qa.ItemInventory.Service;

import static org.assertj.core.api.Assertions.assertThat;
import com.qa.ItemInventory.Item.Item;
import com.qa.ItemInventory.Item.ItemRepository;
import com.qa.ItemInventory.Item.ItemService;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ItemServiceIntegrationTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    private long nextNewItemId;
    private List<Item> itemInDb;

    @BeforeEach
    public void init() {
        List<Item> items = (List.of(new Item(1, "Key", "Opens chests"),
                new Item(2, "Pen", "Write ability"),
                new Item(3, "Sword", "Slash ability")));
       itemInDb = new ArrayList<>();
       itemInDb.addAll(itemRepository.saveAll(items));
       int size = itemInDb.size();
       nextNewItemId = itemInDb.get(size - 1).getId() + 1;
    }

    // teardown method to reset database
    @AfterEach
    public void teardown() {
        itemRepository.deleteAll();
    }

    @Test @Transactional
    public void updateUserTest() {
        Item itemDb = itemInDb.get(0);

        long id = itemDb.getId();

        Item updatedItem = new Item(itemDb.getId(),
                itemDb.getName(),
                itemDb.getDescription());

        Item actualItem = itemService.update(id, updatedItem);
        assertThat(actualItem).isEqualTo(updatedItem);
    }

//    @Test
//    public void getByIdTest() {
//        Item itemDb = itemInDb.get(0);
//        assertThat(itemService.getById(itemDb.getId())).isEqualTo(itemDb.getId());
//    }

    @Test
    public void deleteByIdTest() {
        Item itemDb = itemInDb.get(0);

        long id = itemDb.getId();

        itemService.deleteItem(id);

         assertThat(itemRepository.findById(id)).isEqualTo(Optional.empty());
    }

    @Test
    public void createItemTest() {
        Item saveItem = new Item("Mask", "Scare enemies");
        Item savedItem = new Item(nextNewItemId, saveItem.getName(), saveItem.getDescription());
        (assertThat(savedItem)).isEqualTo(itemService.create(saveItem));
    }

    @Test
    public void getAllItemsTest() {
        (assertThat(itemInDb)).isEqualTo(itemService.getAll());

    }

}
