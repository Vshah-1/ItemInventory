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

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAll() {
       ResponseEntity<List<Item>> allItems =  ResponseEntity.ok(itemService.getAll());
        return allItems;
    }

    @GetMapping("/getItem/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") long id) {
        Item savedItem = itemService.getById(id);

        ResponseEntity<Item> item = ResponseEntity.status(HttpStatus.OK)
                .body(savedItem);
        return item;
    }

    @PostMapping("/addItem")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
//
        ResponseEntity<Item> items = ResponseEntity.status(HttpStatus.OK).body(itemService.create(item));
        return items;
    }

    @PutMapping("/updateItem/{id}")
    @ResponseBody
    public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @Valid @RequestBody Item item) {
        Item updatedItem = itemService.update(id, item);
        return new ResponseEntity<Item>(updatedItem, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<Item> deleteById(@PathVariable("id") long id) {
        itemService.deleteItem(id);
        return ResponseEntity.accepted().build();
    }
}
