package com.example.authentificationapp.model;

import java.util.ArrayList;

public class ItemsList {

    private ArrayList<Item> items;

    public ItemsList(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItemsList() {
        return items;
    }
}
