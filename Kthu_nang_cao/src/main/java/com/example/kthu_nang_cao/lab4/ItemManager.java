package com.example.kthu_nang_cao.lab4;

import com.example.kthu_nang_cao.lab4.entities.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ItemManager {
    private List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        if (item.getName() == "" || item.getName() == null){
            System.out.println("Name trống");
        }else if(item.getName().length() >= 50){
            System.out.println("Tên Không quá 50 ký tự");
        }else {
            items.add(item);
        }
    }

    public void updateItem(int id , String newName){
        if (newName == null || newName.length() > 50) {
            System.out.println("Tên không trống và trên 50 ký tự");
        }else {
            for (Item item: items) {
                if (item.getId() == id) {
                    item.setName(newName);
                    break;
                }
            }
        }
    }
    public void deleteItem(int id){
        items.removeIf(item -> item.getId() == id);
    }
    public List<Item> getItems() {
        return items;
    }
}
