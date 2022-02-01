package com.qa.ItemInventory.Item;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "Items")
public class ItemController {

    @GetMapping
    public List<Item> getItems() {
        return List.of(
                new Item(
                        1L,
                        "Gilded Key",
                        "Allows player to open locked chests")
        );
    }
}
