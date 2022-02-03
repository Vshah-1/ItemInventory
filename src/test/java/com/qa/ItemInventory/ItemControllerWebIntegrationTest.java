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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

//@SpringBootTest
@WebMvcTest(ItemController.class)
public class ItemControllerWebIntegrationTest {

    @Autowired
    private ItemController controller;

    @MockBean
    private ItemService itemService;

    private List<Item> items;

    @BeforeEach
    public void init() {
        items = new ArrayList<>();
        items.addAll(List.of(new Item(1, "Key", "Opens chest"),
                new Item(2, "Pen", "Write ability"),
                new Item(3, "Sword", "Slash ability")));
    }

    @Test
    public void getAllItemsTest() {
        ResponseEntity<List<Item>> expected = new ResponseEntity<List<Item>>(items, HttpStatus.OK);

        when(itemService.getAll()).thenReturn(items);

        ResponseEntity<List<Item>> actual = controller.getItems();
        assertThat(expected).isEqualTo(actual);

        verify(itemService, times(1)).getAll();

    }

}
