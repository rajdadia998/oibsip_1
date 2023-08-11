package com.example;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Query {
    public static Connection con;

    static {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/trs", "root", "wreck");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //INSERT
    public static void insert(String fname,String lname,String uname,String pass,String age,String state,String city) throws Exception
    {
        String sql="INSERT INTO register(fname,lname,uname,pass,age,state,city) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,fname);
        ps.setString(2,lname);
        ps.setString(3,uname);
        ps.setString(4,pass);
        ps.setInt(5,Integer.parseInt(age));
        ps.setString(6,state);
        ps.setString(7,city);
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Failed to insert data.");
        }
    }
    
    //Booking Insert
    public static void insert_booking(String name,String email,String phone,String pnr,String from_location,String to_location,String travel_date,String travel_time,int person,String note) throws Exception
    {
        String sql="INSERT INTO travel_details (name, email, phone, pnr, from_location, to_location, travel_date, travel_time, person, note) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,phone);
        ps.setString(4,pnr);
        ps.setString(5,from_location);
        ps.setString(6,to_location);
        ps.setString(7,travel_date);
        ps.setString(8,travel_time);
        ps.setInt(9, person);
        ps.setString(10,note);
         int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Failed to insert data.");
        }
    }
    
    //DELETE
    public static void delete(int id) throws Exception
    {

        String sql="DELETE FROM travel_details WHERE id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully.");
        } else {
            System.out.println("Failed to delete data.");
        }
    }


    
}

