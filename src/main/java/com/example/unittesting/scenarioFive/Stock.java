package com.example.unittesting.scenarioFive;

import java.util.List;

public class Stock {
    private StockService stockService;
    public List<Item> getItems() {
        return stockService.getItems();
    }
}
