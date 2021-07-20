package ua.goit.repository;


import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import ua.goit.model.Product;


import java.util.Optional;


public class ShopStorageTest {


    @Test
    public  void init() {
        ShopStorage shopStorage = Mockito.mock(ShopStorageImpl.class);
        Mockito.when(shopStorage.findById("A")).thenReturn(Optional.of(new Product("A", 1.25, 3, 3.0)));
    }

}
