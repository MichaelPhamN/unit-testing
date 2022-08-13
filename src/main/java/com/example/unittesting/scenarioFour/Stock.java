package com.example.unittesting.scenarioFour;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private StockService stockService;
    public int numItemsInStock() {
        return stockService.numItemsInStock();
    }
    public Item getItemById(int id) {
        return stockService.getItemById(id);
    }    
}
