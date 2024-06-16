package com.example.kthu_nang_cao.lab4;

import com.example.kthu_nang_cao.lab4.entities.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {
    private ItemManager itemManager;

    @BeforeEach
    public void setUp() {
        itemManager = new ItemManager();
    }
    //add
    @Test
    public void testAddItem() {
        Item item = new Item(1, "Item1");
        itemManager.addItem(item);
        assertTrue(itemManager.getItems().contains(item));
    }

    @Test
    void addItem1(){
        Item invalidItemWithDigits = new Item(2, "");
        itemManager.addItem(invalidItemWithDigits);
        assertFalse(itemManager.getItems().contains(invalidItemWithDigits));
    }

    @Test
    void addItem2(){
        Item invalidItemLongName = new Item(3, "ThisIsALonaaaaaaaaaaaaaaaaaaaaaaaaagNameThatExceedsFiftyCharactersLimit");
        itemManager.addItem(invalidItemLongName);
        assertFalse(itemManager.getItems().contains(invalidItemLongName));
    }

    // update
    @Test
    public void testUpdateItem() {
        Item item = new Item(1, "Item 1");
        itemManager.addItem(item);
        String newName = "New Name";
        itemManager.updateItem(1, newName);
        assertEquals(newName, item.getName());
    }
    @Test
    void updateItem() {
        Item existingItem = new Item(1, "Existing Item");
        itemManager.addItem(existingItem);
        String updatedName = "Updated Name";
        itemManager.updateItem(1, null);
        assertEquals(updatedName, existingItem.getName());
    }

    @Test
    void updateItem3() {
        Item existingItem = new Item(1, "Existing Item");
        itemManager.addItem(existingItem);
        String updatedName = "Updated Name123";
        itemManager.updateItem(1, updatedName);
        assertEquals(updatedName, existingItem.getName());
    }
    @Test
    void updateItem4() {
        Item existingItem = new Item(1, "Existing Item");
        itemManager.addItem(existingItem);
        String updatedName = "Updated Nameaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        itemManager.updateItem(1, updatedName);
        assertEquals(updatedName, existingItem.getName());
    }

    //delete
    @Test
    void deleteItem() {
        Item itemToDelete = new Item(1, "Item to Delete");
        itemManager.addItem(itemToDelete);
        assertDoesNotThrow(()->itemManager.deleteItem(1));
    }

    @Test
    void deleteItem1() {
        Item itemToDelete = new Item(1, "Item to Delete");
        itemManager.addItem(itemToDelete);
        itemManager.deleteItem(2);
        assertFalse(itemManager.getClass().equals(itemToDelete));
    }
}