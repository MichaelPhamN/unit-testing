package com.example.unittesting.scenarioFour;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StockTest {
    @InjectMocks
    private Stock stock;
    @Mock
    private StockService stockService;

    @Test
    public void numItemsInStock() {
        //Return number items in stock in three time, so check the return values in three times
        when(stockService.numItemsInStock()).thenReturn(5).thenReturn(10).thenReturn(20);
        int expectedResult = 5;
        //First time check
        Assert.assertEquals(expectedResult, stock.numItemsInStock());
        expectedResult = 10;
        //Second time check
        Assert.assertEquals(expectedResult, stock.numItemsInStock());
        expectedResult = 20;
        //Third time check
        Assert.assertEquals(expectedResult, stock.numItemsInStock());
    }

    @Test
    public void getItemByItemName() {
        List<Item> items = stockService.getItemsByItemName("Hello Junit and Mockito");
        //Capture the item name type and value [Item name should be String type and "Hello Junit and Mockito" value]
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(stockService).getItemsByItemName(captor.capture());
        Assert.assertEquals("Hello Junit and Mockito", captor.getValue());
    }

    @Test
    public void getItemById() {
        Item google = new Item(1, "Google", 499.99, 10);
        //anyInt method is an argument matcher, the meaning of bellow statement is whenever stockService.getItemById with any integer number, then the item will be a google
        when(stockService.getItemById(anyInt())).thenReturn(google);
        Assert.assertEquals(google, stock.getItemById(1000000));
        Assert.assertEquals(google, stock.getItemById(10));
    }

    @Test
    public void addItems() {
        Item google = new Item(1, "Google", 499.99, 10);
        Item apple = new Item(2, "Apple", 599.99, 20);
        stockService.add(google);
        stockService.add(google);
        stockService.add(google);
        //verify if stockService add item google three times
        verify(stockService, times(3)).add(google);
        //verify if stockService adds item google at most three times
        verify(stockService, atMost(3)).add(google);
        //verify if stockService adds item google at least one time
        verify(stockService, atLeast(1)).add(google);
        //verify if stockService doesn't add item apple
        verify(stockService, never()).add(apple);
    }
}