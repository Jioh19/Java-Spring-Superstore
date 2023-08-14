package com.ltp.globalsuperstore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ltp.globalsuperstore.repository.StoreRepository;
import com.ltp.globalsuperstore.service.StoreService;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceTest {

    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private StoreService storeService;

    @Test
    public void getItemRepoTest() {
        when(storeRepository.getItems()).thenReturn(Arrays.asList(
            new Item("Furniture", "Table", 1000.00, 100.00, new Date()),
            new Item("Furniture", "Chair", 500.00, 50.00, new Date())
        ));

        List<Item> result = storeService.getItems();

        assertEquals("Furniture", result.get(0).getCategory());
        assertEquals("Chair", result.get(1).getName());
    }

    @Test
    public void addItemTest() {
        Item item = new Item("Furniture", "Bed", 2000.00, 1500.00, new Date());
        storeService.submitItem(item);
        verify(storeRepository, times(1)).addItem(item);
    }
}
