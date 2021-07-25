package ua.goit.service;

import ua.goit.model.BaseEntity;
import ua.goit.model.Saleable;
import ua.goit.repository.ShopStorage;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ShopBucketService<T extends Saleable & BaseEntity<ID>, ID> {

    private final ShopStorage<T, ID> shopStorage;

    public ShopBucketService(ShopStorage<T, ID> shopStorage) {
        this.shopStorage = shopStorage;
    }

    protected double calculateTotalCost(ID... ids) {
        final Map<ID, Long> quantity = Optional.ofNullable(ids).map(id -> Arrays.stream(id)
                .map(shopStorage::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.groupingBy(BaseEntity::getId, Collectors.counting())))
                .orElseThrow(() -> new NullPointerException("Empty bucket, try again"));
      if(quantity.isEmpty()) throw new NullPointerException("Empty bucket, try again");
      return quantity.entrySet().stream()
              .mapToDouble(p-> shopStorage.findById(p.getKey()).get().getPrice((p.getValue())))
              .sum();
    }
}
