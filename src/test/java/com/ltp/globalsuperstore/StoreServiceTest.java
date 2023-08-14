package com.ltp.globalsuperstore;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

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
            new Item("Furniture", "Table", 1000.00, 100.00, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-10")),
            new Item("Furniture", "Chair", 500.00, 50.00, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-10"))
        ));

        List<Item> result = storeService.getItems();
    }
}
