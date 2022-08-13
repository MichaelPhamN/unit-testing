package com.example.unittesting.scenarioFour;

import java.util.List;

public interface StockService {
    int numItemsInStock();
    Item getItemById(int id);
    List<Item> getItemsByItemName(String itemName);
    void add(Item item);
    void saveTotalAmount(double totalAmount);
}
