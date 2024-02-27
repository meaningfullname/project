package org.example;

import java.sql.*;

public class User_Repository implements UserRepository,DB {

    User users = null;
    private int lastId = 0;

    private String url;
    private String user;
    private String password;


    public User_Repository(String url, String user, String password) {
        this.url = this.url;
        this.user = this.user;
        this.password = this.password;
    }

    @Override
    public Connection getCon() {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            return conn;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    @Override
    public void creation(User user) {
        try (Connection conn = getCon()) {

            String sql = "INSERT INTO users (name, surname, wealth) VALUES (?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, ++lastId);
            st.setString(2, user.getName());
            st.setString(3, user.getSurname());
            st.setInt(4, user.getWealth());


            st.executeUpdate();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public User getAllUsers() {
        Statement st = null;
        ResultSet rs = null;


        try (Connection conn = getCon()) {

            String sql = "SELECT * FROM users";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name") + "  "
                        + rs.getString("surname") + "  " + rs.getInt("wealth"));


            }
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void choose(int row) {
        try (Connection conn = getCon()) {
            String sql = "SELECT * FROM users";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.absolute(row)) {
                User user = new User(rs.getString("name"), rs.getString("surname"), rs.getInt("wealth"));
                user.setId(rs.getInt("id"));
                System.out.println("Selected user: " + user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(User user) {
        try (Connection conn = getCon()) {
            String sql = "UPDATE users SET wealth = row WHERE id = row";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, user.getWealth());
            st.setInt(2, user.getId());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}

