package ua.goit.repository;

import ua.goit.model.BaseEntity;

import java.util.Optional;

public interface ShopStorage<T extends BaseEntity<ID>, ID> {
    Optional<T> findById(ID id);
}
