package ua.goit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.goit.model.Product;
import ua.goit.repository.ShopStorageImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductBucketServiceTest {

    private final double accuracy = 0.001;

    private ProductBucketService bucket;

    @BeforeEach
    public void init() {
        this.bucket = new ProductBucketService(new ShopStorageImpl<>(
                new Product("A", 1.25, 3, 3.0),
                new Product("B", 4.25),
                new Product("C", 1.0, 6, 5.0),
                new Product("D", 0.75)));
    }

    @Test
    public void shouldCalculateTotalCost() {
        testCalculateCost(7.25, "ABCD");
    }

    @Test
    public void shouldCalculateTotalCostWithLowerCase() {
        testCalculateCost(8.50, "abCDA");
    }

    @Test
    public void shouldCalculateTotalCostWithUndefinedProducts() {
        testCalculateCost(4.25, "berry");
    }

    @Test
    public void shouldCalculateBucketSpace() {
        testCalculateCost(5.75, "A C CA DA");
    }

    @Test
    public void shouldCalculateBucketNumbers() {
        testCalculateCost(5.0, "A1111C3D5566DA");
    }

    @Test
    public void shouldCalculateUndefinedAndCorrect() {
        testCalculateCost(8.5, "JAVAJDBC");
    }

    @Test
    public void shouldCalculateTotalCostEmptyBucket() {
        negativeTestCalculateCost(null, "Please, check your bucket");
    }

    @Test
    public void shouldCalculateTotalCostOnlySpaceBucket() {
        negativeTestCalculateCost(" ", "Please, check your bucket");
    }

    private void testCalculateCost(double expectedValue, String productIds) {
        assertEquals(expectedValue, bucket.calculateTotalCost(productIds), accuracy);
    }

    private void negativeTestCalculateCost(String productIds, String exceptionMessage) {
        assertThrows(NullPointerException.class, () -> bucket.calculateTotalCost(productIds), exceptionMessage);
    }

}
