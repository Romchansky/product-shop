package ua.goit.model;

@FunctionalInterface
public interface Saleable {
    Double getPrice(Long quantity);
}
