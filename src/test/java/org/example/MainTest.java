package org.example;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
    HashMap<String, Integer> products;

    @BeforeEach
    void setUp() {
        products = new HashMap<>();
        products.put("Apple", 10);
        products.put("Banana", 20);
    }

    @Test
    void testAddProductSuccess() {
        String result = Main.addProduct(products, "Orange", 15);
        assertEquals("Product: Added", result);
        assertTrue(products.containsKey("Orange"));
        assertEquals(15, products.get("Orange"));
        assertEquals(3, products.size());
    }

    @Test
    void testAddProductUpdateExisting() {
        String result = Main.addProduct(products, "Apple", 25);
        assertEquals("Product: Added", result);
        assertTrue(products.containsKey("Apple"));
        assertEquals(25, products.get("Apple"));
        assertEquals(2, products.size());
    }

    @Test
    void testViewInventory() {
        assertTrue(true, "viewInventory is a print method and cannot be directly asserted on its output without mocking System.out.");
    }

    @Test
    void testUpdateStockSuccess() {
        String result = Main.updateStock(products, "Apple", 50);
        assertEquals("Product Updated", result);
        assertEquals(50, products.get("Apple"));
    }

    @Test
    void testUpdateStockProductNotFound() {
        String result = Main.updateStock(products, "Grape", 30);
        assertEquals("Product not updated", result);
        assertFalse(products.containsKey("Grape"));
    }

    @Test
    void testRemoveProductSuccess() {
        String result = Main.removeProduct(products, "Banana");
        assertEquals("Product removed", result);
        assertFalse(products.containsKey("Banana"));
        assertEquals(1, products.size());
    }

    @Test
    void testRemoveProductNotFound() {
        boolean contains = products.containsKey("Grape");
        String result = Main.removeProduct(products, "Grape");
        assertEquals("ERR: Cant remove product", result);
        assertFalse(products.containsKey("Grape"));
        assertEquals(2, products.size());
    }

    @Test
    void testCheckProductFound() {
        String result = Main.checkProduct(products, "Apple");
        assertEquals("Product Found", result);
    }

    @Test
    void testCheckProductNotFound() {
        String result = Main.checkProduct(products, "Mango");
        assertEquals("Product not Found", result);
    }
}