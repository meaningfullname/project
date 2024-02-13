package org.example;

import java.util.Arrays;
import java.util.List;

public class Creation_Cars implements CarsRepotisory {
    private final CarsRepotisory repo;
    List<String> cars=new List<String>(Arrays.asList("mercedes","audi");
    List <Cars> car= (List<Cars>) new Cars();



    public Creation_Cars(CarsRepotisory repo) {
        this.repo = repo;
    }
    public String Define_Cars(Cars car) {

        boolean created = false;
        if (cars.contains(car)) {

            created = repo.Creation(car);
            return ("Cars was created ");


        }else{
            return ("Creation failed");
        }


    }


    @Override
    public boolean Creation(Cars cars) {
        return false;
    }

    @Override
    public Cars getCar(String modele) {
        return null;
    }

    @Override
    public List<Cars> getAllCars() {
        return null;
    }
}
