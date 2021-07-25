package ua.goit.service;

import ua.goit.model.Product;
import ua.goit.repository.ShopStorage;

import java.util.Optional;

public class ProductBucketService extends ShopBucketService<Product, String> {

    public ProductBucketService(ShopStorage<Product, String> shopStorage) {
        super(shopStorage);
    }


    public double calculateTotalCost(String args) {
        return super.calculateTotalCost(Optional.ofNullable(args).map(arg -> arg.toUpperCase().split("")).orElse(null));
    }

}
