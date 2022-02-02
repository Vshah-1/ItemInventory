package com.qa.ItemInventory.Item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "Items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
       ResponseEntity<List<Item>> items =  ResponseEntity.ok(itemService.getAll());
        return items;
    }


    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        Item savedItem = itemService.create(item);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/item/" + String.valueOf(savedItem.getId()));

        ResponseEntity<Item> response = new ResponseEntity<Item>(savedItem, headers, HttpStatus.CREATED);
        return response;
    }
}
