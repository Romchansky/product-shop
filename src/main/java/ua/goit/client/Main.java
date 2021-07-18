package ua.goit.client;

import ua.goit.model.Product;
import ua.goit.repository.ShopStorageImpl;
import ua.goit.service.ProductBucketService;

public class Main {

    public static void main(String[] args) {

        ProductBucketService bucket = new ProductBucketService(new ShopStorageImpl<>(
                new Product("A", 1.25, 3, 3.0),
                new Product("B", 4.25),
                new Product("C", 1.0, 6, 5.0),
                new Product("D", 0.75)));


        double costBucket = bucket.calculateTotalCost(" ABCDABA");
        System.out.println(costBucket);
    }
}
