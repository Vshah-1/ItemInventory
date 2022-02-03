package com.qa.ItemInventory;

import com.qa.ItemInventory.Item.Item;
import com.qa.ItemInventory.Item.ItemController;
import com.qa.ItemInventory.Item.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@SpringBootTest
@WebMvcTest(ItemController.class)
public class ItemControllerWebIntegrationTest {

    @Autowired
    private ItemController controller;

    @MockBean
    private ItemService itemService;

    // Data for testing purposes
    private List<Item> items;
    private Item validItem;
    private Item itemCreate;

    @BeforeEach
    public void init() {
        items = new ArrayList<>();
        items.addAll(List.of(new Item(1, "Key", "Opens chests"),
                new Item(2, "Pen", "Write ability"),
                new Item(3, "Sword", "Slash ability")));
        itemCreate = new Item("Key","Opens chests");
        validItem = new Item(1, "Key", "Opens chests");
    }

    @Test
    public void getAllItemsTest() {
        ResponseEntity<List<Item>> expected = new ResponseEntity<List<Item>>(items, HttpStatus.OK);

        when(itemService.getAll()).thenReturn(items);

        ResponseEntity<List<Item>> actual = controller.getItems();
        assertThat(expected).isEqualTo(actual);

        verify(itemService, times(1)).getAll();

    }

    @Test
    public void createItemTest() {

        ResponseEntity<Item> expected = new ResponseEntity<Item>(validItem, HttpStatus.OK);

        when(itemService.create(itemCreate)).thenReturn(validItem);

        ResponseEntity<Item> actual = controller.createItem(itemCreate);
        assertEquals(expected, actual);

        verify(itemService).create(itemCreate);

    }

    @Test
    public void updateItemTest() {
        Item updateItem = new Item(1, "key", "Opens lock");
        Item updateWith = new Item("Key", "Opens Chests");
        long itemId = updateItem.getId();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/updateItem/");

        ResponseEntity<Item> expected = new ResponseEntity<Item>(updateItem, headers, HttpStatus.ACCEPTED);
        when(itemService.update(itemId, updateItem)).thenReturn(updateItem);
    }

    // Test designed to test getByID function
    // Takes id of item variable created validItem
    @Test
    public void getByIdTest() {
        ResponseEntity<Item> expected = ResponseEntity.of(Optional.of(validItem));
        when(itemService.getById(1)).thenReturn(validItem);

        ResponseEntity<Item> actual = controller.getById(1);
        assertEquals(expected, actual);

        verify(itemService, times(1)).getById(1);
    }

    // Test of deleteById function in itemService
    // No Mock return as delete does not return results in the same manner
    // Instead I verified that the deleteById method in itemService is being called
    @Test
    public void deleteByIdTest() {
        ResponseEntity<Item> actual = controller.deleteById(1);

        ResponseEntity<Item> expected = ResponseEntity.accepted().build();

        assertEquals(expected, actual);

        verify(itemService).deleteItem(1);

    }

}
