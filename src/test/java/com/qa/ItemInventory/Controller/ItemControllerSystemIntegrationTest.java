package com.qa.ItemInventory.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ItemInventory.data.entity.Item;
import com.qa.ItemInventory.data.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc


public class ItemControllerSystemIntegrationTest {

    // Serializing and deserializing objects
    @Autowired
    private ObjectMapper objectMapper;

    // Emulates sending HTTP Request to application
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    // List for Items stored in database
    private List<Item> itemInDb;

    // id of the next element incremented and updated
    private long nextNewItemId;

    // initialise and insert the database into each new test
    @BeforeEach
    public void init() {
        List<Item> savedItems =
                List.of(new Item("Key", "Opens locks" ), new Item("Pen", "Allows to write"));
        itemInDb = new ArrayList<>();
        itemInDb.addAll(itemRepository.saveAll(savedItems));
        int size = itemInDb.size();
        nextNewItemId = itemInDb.get(size - 1).getId() + 1;
    }

    // teardown method to reset database
    @AfterEach
    public void teardown() {
        itemRepository.deleteAll();
    }


    @Test
    public void getItemsTest() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request((HttpMethod.GET), "/Items/getAllItems");

        String allItems = objectMapper.writeValueAsString(itemInDb);
        mockRequest.accept(MediaType.APPLICATION_JSON);

        ResultMatcher outcomeMatcher = MockMvcResultMatchers.status().isOk();

        ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(allItems);

        mockMvc.perform(mockRequest).andExpectAll(outcomeMatcher).andExpectAll(contentMatcher);

    }

    @Test
    public void createItemTest() throws Exception {
        Item itemSave = new Item("Bandages", "Heal up");
        Item expectItem = new Item(nextNewItemId, itemSave.getName(), itemSave.getDescription());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request((HttpMethod.POST), "/Items/addItem");

        mockRequest.contentType(MediaType.APPLICATION_JSON);
        mockRequest.content(objectMapper.writeValueAsString(itemSave));
        mockRequest.accept(MediaType.APPLICATION_JSON);

        ResultMatcher outcomeMatcher = MockMvcResultMatchers.status().isCreated();
        ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectItem));

        mockMvc.perform(mockRequest).andExpectAll(contentMatcher).andExpectAll(contentMatcher);

    }


}
