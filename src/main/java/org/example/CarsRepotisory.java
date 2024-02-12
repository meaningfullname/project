package org.example;

import java.util.Arrays;
import java.util.List;

public interface CarsRepotisory {



    boolean Creation (Cars cars);
    Cars getCar(String modele);
    List<Cars> getAllCars();
}
