package com.qa.ItemInventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ItemInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemInventoryApplication.class, args);
	}

}
