package com.qa.ItemInventory.Service;


import com.qa.ItemInventory.Item.Item;
import com.qa.ItemInventory.Item.ItemRepository;
import com.qa.ItemInventory.Item.ItemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void updateUserTest() {

    }

    @Test
    public void getByIdTest() {

    }

    @Test
    public void deleteByIdTest() {

    }

    @Test
    public void createItemTest() {

    }

    @Test
    public void getAllItemsTest() {


    }

}
