package com.example.unittesting.scenarioFive;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StockTest {

    @Test
    @DisplayName("Demonstration how to use mock")
    public void getItemsMock() {
        List<Item> items = mock(ArrayList.class);
        int expectedResult = 0;
        Assert.assertEquals(null, items.get(0));    //null
        Assert.assertEquals(expectedResult, items.size());  //0

        Item google = new Item(1, "Google", 499.99, 10);
        Item apple = new Item(2, "Apple", 449.99, 20);
        Item samsung = new Item(3, "Samsung", 399.99, 15);
        Item oppo = new Item(4, "Oppo", 449.99, 20);
        items.add(google);
        items.add(apple);
        items.add(samsung);
        items.add(oppo);
        Assert.assertEquals(null, items.get(0));    //because items list has not been overridden when we use mockito
        Assert.assertEquals(expectedResult, items.size());  //because items list size has not been overridden when we use mockito

        //items list will be overridden
        when(items.get(0)).thenReturn(apple);
        when(items.get(1)).thenReturn(google);
        Assert.assertEquals(apple, items.get(0));
        Assert.assertEquals(google, items.get(1));
        Assert.assertEquals(expectedResult, items.size());  //because items list size has not been overridden

        //items list size will be overridden
        when(items.size()).thenReturn(1000);
        Assert.assertEquals(1000, items.size());
    }

    @Test
    @DisplayName("Demonstration how to use Spy")
    public void getItemsSpy() {
        List<Item> items = spy(ArrayList.class);
        int expectedResult = 0;
        //items.get(0) --> will throw an exception;
        Assert.assertEquals(expectedResult, items.size());

        Item google = new Item(1, "Google", 499.99, 10);
        Item apple = new Item(2, "Apple", 449.99, 20);
        Item samsung = new Item(3, "Samsung", 399.99, 15);
        Item oppo = new Item(4, "Oppo", 449.99, 20);
        items.add(google);
        items.add(apple);
        items.add(samsung);
        items.add(oppo);
        expectedResult = 4;
        Assert.assertEquals(google, items.get(0));
        Assert.assertEquals(expectedResult, items.size());

        //Override items list size
        when(items.size()).thenReturn(1000);
        Assert.assertEquals(1000, items.size());

        //Even though add a new item to item list, the size won't change
        items.add(google);
        Assert.assertEquals(1000, items.size());
    }
}