package ua.goit.model;

@FunctionalInterface
public interface Saleble {

    Double getPrice(Long quantity);
}
