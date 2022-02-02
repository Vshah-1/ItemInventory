package com.qa.ItemInventory.Item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Items")
public class ItemController {

    private  ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
       ResponseEntity<List<Item>> items =  ResponseEntity.ok(itemService.getAll());
        return items;
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.GET })
    public ResponseEntity<Item> getUserById(@PathVariable("id") long id) {
        Item savedItem = itemService.getById(id);

        ResponseEntity<Item> response = ResponseEntity.status(HttpStatus.OK)
                .body(savedItem);
        return response;
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        Item savedItem = itemService.create(item);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/item/" + String.valueOf(savedItem.getId()));

        ResponseEntity<Item> response = new ResponseEntity<Item>(savedItem, headers, HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @Valid @RequestBody Item item) {
        Item updatedItem = itemService.update(id, item);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/item/" + String.valueOf(updatedItem.getId()));

        return new ResponseEntity<Item>(updatedItem, headers, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") long id) {
        itemService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
