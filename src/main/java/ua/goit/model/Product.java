package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Product implements Saleble, BaseEntity<String> {

    private String id;
    private Double productPrice;
    private Integer salesProductQuantity;
    private Double salesProductPrice;

    public Product(String id, Double productPrice) {
        this(id, productPrice, null, null);
    }

    @Override
    public Double getPrice(Long quantity) {
        if (quantity == null || quantity < 1) throw new RuntimeException("Bucket is empty, please put something in");
        return salesProductQuantity == null ? quantity * productPrice
                : (quantity / salesProductQuantity) * salesProductPrice + (quantity % salesProductQuantity) * productPrice;

    }
}
