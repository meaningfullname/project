package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserRoptisory {

    default Connection getCon() {
        try (Connection result = new Conncetion_Db().getCon()) {
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    void creation(User user);

    User getAllUsers();

    void choose(int row);
}
