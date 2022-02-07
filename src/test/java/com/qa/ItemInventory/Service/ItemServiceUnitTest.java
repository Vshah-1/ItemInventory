package com.qa.ItemInventory.Service;

import com.qa.ItemInventory.data.entity.Item;
import com.qa.ItemInventory.data.repository.ItemRepository;
import com.qa.ItemInventory.service.ItemService;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceUnitTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    private List<Item> items;
    private Item itemId;
    private Item itemWoId;

    @Disabled
    @Test
    public void getItemIdTest() {
        long id = itemId.getId();

        when(itemRepository.findById(id)).thenReturn(Optional.of(itemId));
        assertThat(itemService.getById(id)).isEqualTo(itemId);
        verify(itemRepository).findById(id);
    }

    @Test
    public void createItemTest() {
        when(itemRepository.save(itemWoId)).thenReturn(itemId);

        assertThat(itemService.create(itemWoId)).isEqualTo(itemId);
        verify(itemRepository).save(itemWoId);

    }

    @Test
    public void getAllItemsTest() {
        when(itemRepository.findAll()).thenReturn(items);
        assertThat(itemService.getAll()).isEqualTo(items);
        verify(itemRepository).findAll();

    }

    @Disabled
    @Test
    public void deleteItemTest() {
        long id = itemId.getId();
        when(itemRepository.existsById(id)).thenReturn(true);
        itemService.deleteItem(id);
        verify(itemRepository).existsById(id);
        verify(itemRepository).deleteById(id);

    }

    @Disabled
    @Test
    public void updateItemTest() {
        long id = itemId.getId();
        Item itemUpdated = new Item(itemId.getId(), itemId.getName(), itemId.getDescription());

        when(itemRepository.existsById(id)).thenReturn(true);
        when(itemRepository.getById(id)).thenReturn(itemId);
        when(itemRepository.save(itemId)).thenReturn(itemId);

        assertThat(itemService.update(id, itemUpdated)).isEqualTo(itemUpdated);
        verify(itemRepository).existsById(id);
        verify(itemRepository).getById(id);
        verify(itemRepository).save(itemId);

    }

}
