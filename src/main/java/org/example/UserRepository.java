package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserRepository {

    default Connection getCon() {
        try (Connection resul = new Conncetion_Db().getCon()) {
            return resul;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    void creation(User user);

    User getAllUsers();

    void choose(int row);

    void update(User user);
}
