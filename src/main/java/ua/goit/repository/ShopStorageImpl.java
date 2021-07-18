package ua.goit.repository;

import ua.goit.model.BaseEntity;
import ua.goit.model.Saleable;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShopStorageImpl<T extends Saleable & BaseEntity<ID>, ID> implements ShopStorage<T, ID> {

    private final Map<ID, T> productsBucket;

    public ShopStorageImpl(T... entities) {
        this.productsBucket = Arrays.stream(entities).collect(Collectors.toMap(k -> k.getId(), v -> v));
    }

    @Override
    public Optional<T> findById(ID id) {
        final T entity = productsBucket.get(id);
        return entity == null ? Optional.empty() : Optional.of(entity);
    }
}
