package com.qa.ItemInventory;

import com.qa.ItemInventory.Item.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ItemInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemInventoryApplication.class, args);
	}

	@GetMapping
	public List<Item> Items() {
		return List.of(
				new Item(
						1L,
						"Gilded Key",
						"Allows player to open locked chests")
		);
	}
}



