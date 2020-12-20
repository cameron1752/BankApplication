/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cammy
 */
public class AccountCreate extends Customer{

    private String newAccount;
    
 
    public void setLName(String lName){
        this.lName = lName;
    }
    public String getLName(String lName){
        return lName;
    }

    public void setNewAccount(){
        this.newAccount = String.valueOf(Math.random() * 1000);
    }
    public void newAccount(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException ex){
            System.out.println("Ok there was an error");
            System.out.println(ex.getMessage());
        }

        Connection connection;
        try{
            connection = DriverManager.getConnection("jdbc:ucanaccess://I://Fall 2020/IST 412/bank app/BankApplication/web/Bank.accdb");
            Statement s = connection.createStatement();
            String sql;
            setNewAccount();
            sql = "INSERT INTO Accounts (Email, [Account Number], Balance, [Account Type]) VALUES ('" + getEmail() + "','" + newAccount + "',0,'CHECKING');"; 
            System.out.println(sql);
            s.executeUpdate(sql);
        } catch(SQLException e){
            System.out.println("Ok there was an error");
            System.out.println(e.getMessage());
        }
    }
    public void createUser(){
    try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    } catch (ClassNotFoundException ex){
        System.out.println("Ok there was an error");
        System.out.println(ex.getMessage());
    }

    Connection connection;
    try{
        connection = DriverManager.getConnection("jdbc:ucanaccess://I://Fall 2020/IST 412/bank app/BankApplication/web/Bank.accdb");
        Statement s = connection.createStatement();
        String sql = "INSERT INTO Users (Email, fName, lName, Password) VALUES ('" + email + "','" + fName + "','" + lName + "','" + password + "');";
        System.out.println(sql);
        s.executeUpdate(sql);
        
        sql = "INSERT INTO Accounts (Email, [Account Number], Balance, [Account Type]) VALUES ('" + getEmail() + "','" + newAccount + "',0,'CHECKING');"; 
        System.out.println(sql);
        s.executeUpdate(sql);
    } catch(SQLException e){
        System.out.println("Ok there was an error");
        System.out.println(e.getMessage());
    }
}
}
