package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Printtable  {
    private DB db;

    public Printtable(DB db){
        this.db=db;

    }

    public Printtable() {

    }


    public void Print(String tablename){
        Connection conn =db.getCon();
        try{

            Statement stmt=conn.createStatement();
            ResultSet rs= stmt.executeQuery("select  from"+tablename);

            while(rs.next()){
                System.out.println(rs.getString("name")+ rs.getString("modele")
                        +rs.getInt("price")+rs.getString("equipment"));
            }



        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }






}
