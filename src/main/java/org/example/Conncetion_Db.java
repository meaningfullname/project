package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conncetion_Db implements DB {
    String connectionUrl="jdbc:postgresql:localhost:5432/Cars";
    ResultSet rs = null;
    Statement stm=null;
    Connection conn;
    public Connection getCon(){
        try{
            Class.forName("org.postgresql.Driver");

            Connection conn= DriverManager.getConnection(connectionUrl,"postgres","123456");

            return conn;

        } catch(Exception e){
            return null;

        }
    }



}
