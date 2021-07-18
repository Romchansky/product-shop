package ua.goit.model;


import org.junit.Before;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ProductTest {

    private final double accuracy = 0.001;

    private Product product;

    @Before
    public void init() {
        product = new Product("A", 1.25, 3, 3.0);
    }

    @Test
    public void shouldGetPrice() {
        assertEquals(3.0, product.getPrice(3L), accuracy);
    }

    @Test
    public void shouldThrowRuntimeExceptionWithMinusQuantity() {
        negativeTestCalculateCost(-2L, "Amount can't be null or less than 1");
    }


    @Test
    public void shouldThrowRuntimeExceptionWithNullQuantity() {
        negativeTestCalculateCost(null, "Amount can't be null or less than 1");
    }

    private void negativeTestCalculateCost(Long quantity, String exceptionMessage) {
        assertThrows(RuntimeException.class, () -> product.getPrice(quantity), exceptionMessage);
    }

}
