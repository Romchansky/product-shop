package ua.goit.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ProductTest {

    private final double accuracy = 0.001;

    private Product product;

    @BeforeEach
    public void init() {
        product = new Product("A", 1.25, 3, 3.0);
    }

    @Test
    public void testGetPrice() {
        assertEquals(3.0, product.getPrice(3L), accuracy);
    }

    @Test
    public void testMinusQuantity() {
        negativeTestCalculateCost(-2L, "Amount can't be null or less than 1");
    }

    @Test
    public void testNullQuantity() {
        negativeTestCalculateCost(null, "Amount can't be null or less than 1");
    }

    private void negativeTestCalculateCost(Long quantity, String exceptionMessage) {
        assertThrows(RuntimeException.class, () -> product.getPrice(quantity), exceptionMessage);
    }

}
