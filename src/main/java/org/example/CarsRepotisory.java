package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public interface CarsRepotisory {

    default Connection getCon() {
        try (Connection result = new Conncetion_Db().getCon()) {
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    void creation(Cars cars);

    void getAllCars();
    void chose(int row);
}
