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
        products.put("Milk", 20);
        products.put("Bread", 10);
        products.put("Eggs", 12);
    }

    @Test
    void testAddProduct_ValidQuantity() {
        String result = Main.addProduct(products, "Banana", 30);
        assertEquals("Product: Added", result);
        assertTrue(products.containsKey("Banana"));
        assertEquals(30, products.get("Banana"));
        assertEquals(4, products.size());
    }

    @Test
    void testAddProduct_QuantityZero() {
        String result = Main.addProduct(products, "Mango", 0);
        assertEquals("Product: Added", result);
        assertTrue(products.containsKey("Mango"));
        assertEquals(0, products.get("Mango"));
        assertEquals(4, products.size());
    }

    @Test
    void testAddProduct_AlreadyExists() {
        String result = Main.addProduct(products, "Milk", 50);
        assertEquals("Product: Added", result);
        assertTrue(products.containsKey("Milk"));
        assertEquals(50, products.get("Milk"));
        assertEquals(3, products.size());
    }

    @Test
    void testCheckProduct_Existing() {
        String result = Main.checkProduct(products, "Milk");
        assertEquals("Product Found", result);
        assertEquals(20, products.get("Milk"));
    }

    @Test
    void testCheckProduct_NonExisting() {
        String result = Main.checkProduct(products, "Ice Cream");
        assertEquals("Product not Found", result);
        assertFalse(products.containsKey("Ice Cream"));
    }

    @Test
    void testUpdateStock_ExistingProduct_ValidQuantity() {
        String result = Main.updateStock(products, "Bread", 25);
        assertEquals("Product Updated", result);
        assertTrue(products.containsKey("Bread"));
        assertEquals(25, products.get("Bread"));
        assertEquals(3, products.size());
    }

    @Test
    void testUpdateStock_NonExistingProduct() {
        String result = Main.updateStock(products, "Tofu", 15);
        assertEquals("Product not updated", result);
        assertFalse(products.containsKey("Tofu"));
        assertEquals(3, products.size());
    }

    @Test
    void testRemoveProduct_Existing() {
        String result = Main.removeProduct(products, "Eggs");
        assertEquals("Product removed", result);
        assertFalse(products.containsKey("Eggs"));
        assertEquals(2, products.size());
    }

    @Test
    void testRemoveProduct_NonExisting() {
        String result = Main.removeProduct(products, "Pizza");
        assertEquals("ERR: Cant remove product", result);
        assertFalse(products.containsKey("Pizza"));
        assertEquals(3, products.size());
    }
}