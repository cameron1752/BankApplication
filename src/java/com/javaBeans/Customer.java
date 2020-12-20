/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaBeans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cammy
 */

public class Customer{
//      CUSTOMER INFORMATION
    public String email = "";
    public String password = "";
    public String fName = "";
    public String lName = "";
    private boolean validate = false;
    private String message = "";
//      ACCOUNT INFORMATION
    protected String account = "";
    protected String accounts = "";
    protected String selAccount = "";
    protected String amount = "";
    protected String accountSelected = "";
    protected String secondAccountSelected = "";
    protected String emailStuff = "";
    protected String passwordStuff = "";
    protected String firstNameStuff = "";
    protected String lastNameStuff = "";
    protected String transactions = "";
//      DATABASE INFORMATION
    public Connection connection;
    public Statement s;
    
    // constructor creates connection to the database
    public void Customer(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex){
            System.out.println("Ok there was an error");
            System.out.println(ex.getMessage());
            }
        try{
            connection = DriverManager.getConnection("jdbc:ucanaccess://I://Fall 2020/IST 412/bank app/BankApplication/web/Bank.accdb");
            connection.setAutoCommit(false);
            //s = connection.createStatement();
        } catch(SQLException e){
            System.out.println("Ok there was an error");
            System.out.println(e.getMessage());
        }
    }
    
//      SETTERS
    // sets email
    public void setEmail(String email){
        this.email = email;
    }
    // sets first name
    public void setFName(String fName){
        this.fName = fName;
    }
    // sets password
    public void setPassword(String password){
        this.password = password;
    }
    // sets amount for deposit / transfer
    public void setAmount(String amount){
        this.amount = amount;
    }
    // sets the selected account
    public void setAccountSelected(String acct){
        accountSelected = acct;
    }
    // sets teh second selected account
    public void setSecondAccountSelected(String acct2){
        secondAccountSelected = acct2;
    }
//      GETTERS
    // returns the list of accounts surrounded in <p> tags for listing accounts
    public String getAccount(){
        return account;
    }
    // returns the selected account based on the int index
    public String getAccountSelected(){
        return accountSelected;
    }
    // returns the second selected account
    public String getSecondAccountSelected(){
        return secondAccountSelected;
    }
    // returns list of accounts in <select> tags for drop down options
    public String getAccounts(){
        return accounts;
    }
    // returns user first name
    public String getFName(){
        return fName;
    }
    // returns user email address
    public String getEmail(){
        return email;
    }
    // returns user password
    public String getPassword(){
        return password;
    }
    // returns system message
        public String getMessage(){
        return message;
    }
    // returns amount for transfer/deposit
    public String getAmount(){
        return amount;
    }
        
    //  FUNCTIONS
    // function to create a new account with the account create class
    public void newAccount(){
        AccountCreate ac = new AccountCreate();
        ac.newAccount();
    }
    // transaction
    public void addTransaction(String desc, String transAccount){
    try{
            connection = DriverManager.getConnection("jdbc:ucanaccess://I://Fall 2020/IST 412/bank app/BankApplication/web/Bank.accdb");
            connection.setAutoCommit(true);
            s = connection.createStatement();
            String sql = "INSERT INTO Transactions ([Account Number], [Trans Desc], Amount, Balance, [TransDate]) Values ('" + String.valueOf(transAccount).replaceFirst("0", ".") + "','" + desc + "', " + amount + ", "
                    + "(SELECT [Balance] FROM Accounts WHERE [Account Number] = " + String.valueOf(transAccount).replaceFirst("0", ".") + "), Now())";

            System.out.println(sql);
            s.executeUpdate(sql);
        } catch(SQLException e){
            System.out.println("Ok there was an error");
            System.out.println(e.getMessage());
        }
        
    }
    //function to validate the users email address and password
    public boolean getValidate() throws SQLException{
        // if either empty return false and set message
        if (getEmail().isEmpty() || getPassword().isEmpty()){
            validate = false;
            message = "- Please enter a user name or password!";
        // if they are a user return true
        } else if (isUser()){
            validate = true;
        // if they aren't a user display message return false
        } else{
            message = "- sorry couldn't authenticate you :(";
            validate = false;
        }
        // return result
        return validate;
    }
    // function to make deposit
    public void makeDeposit(){
        try{
            connection = DriverManager.getConnection("jdbc:ucanaccess://I://Fall 2020/IST 412/bank app/BankApplication/web/Bank.accdb");
            connection.setAutoCommit(true);
            s = connection.createStatement();
            String sql = "UPDATE Accounts SET [Balance] = ([Balance] + " + Double.parseDouble(amount) + ") "
                    + "WHERE Email = '" + email + "' and [Account Number] = " + String.valueOf(accountSelected).replaceFirst("0", ".") + "";
            System.out.println(sql);
            s.executeUpdate(sql);
            addTransaction("Desposit", accountSelected);
        } catch(SQLException e){
            System.out.println("Ok there was an error");
            System.out.println(e.getMessage());
        }
    }
    
    // function to transfer funds
    public void makeTransfer(){
    try{
        connection = DriverManager.getConnection("jdbc:ucanaccess://I://Fall 2020/IST 412/bank app/BankApplication/web/Bank.accdb");
        connection.setAutoCommit(true);
        s = connection.createStatement();

        String sql = "UPDATE Accounts SET [Balance] = ([Balance] - " + Double.parseDouble(amount) + ") "
                + "WHERE Email = '" + email + "' and [Account Number] = " + String.valueOf(accountSelected).replaceFirst("0", ".") + "";  

        System.out.println(sql);
        s.executeUpdate(sql);

        amount = "-" + amount;
        addTransaction("Transfer",accountSelected);

        s = connection.createStatement();
        amount = amount.substring(1);
        
        sql = "UPDATE Accounts SET [Balance] = ([Balance] + " + Double.parseDouble(amount) + ") "
                + "WHERE Email = '" + email + "' and [Account Number] = " + String.valueOf(secondAccountSelected).replaceFirst("0", ".") + "";

        addTransaction("Transfer",secondAccountSelected);

        System.out.println(sql);
        s.executeUpdate(sql);

        } catch(SQLException e){
            System.out.println("Ok there was an error");
            System.out.println(e.getMessage());
        }
    }
    public String getTransactions(){
        return transactions;
    }
    public String getEmailStuff(){
        if (email.length() == 0){
            emailStuff = "Enter email";
        } else{
            emailStuff = email;
        }
        return emailStuff;
    }
    
    public String getPasswordStuff(){
        if (password.length() == 0){
            passwordStuff = "Enter password";
        } else{
            passwordStuff = password;
        }
        return passwordStuff;
    }
        public String getFirstNameStuff(){
        if (fName.length() == 0){
            firstNameStuff = "Enter first name";
        } else{
            firstNameStuff = fName;
        }
        return firstNameStuff;
    }
    public String getLastNameStuff(){
        if (lName.length() == 0){
            lastNameStuff = "Enter last name";
        } else{
            lastNameStuff = lName;
        }
        return lastNameStuff;
    }
    // function to set accounts on main landing page and deposit drop down
    public void getUserInfo() throws SQLException{
         try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex){
            System.out.println("Ok there was an error");
            System.out.println(ex.getMessage());
            }
        try{
            connection = DriverManager.getConnection("jdbc:ucanaccess://I://Fall 2020/IST 412/bank app/BankApplication/web/Bank.accdb");
            connection.setAutoCommit(false);
            s = connection.createStatement();
            ResultSet RS = s.executeQuery("SELECT [Account Number], Balance, [Account Type] FROM Accounts WHERE Email = '" + email + "';");
            
            // reset account variables
            account = "";
            transactions = "";
            accounts = "";
            
            // while there are records left fill our paragraph account variable
            while(RS.next()){
                account = account + "<p> " + RS.getString("Account Type") + " ACCOUNT " + String.valueOf(RS.getDouble("Account Number")).replace('.', '0')
                        + ".............................................................. " + RS.getDouble("Balance") + "</p>";
            }
            
            // close the recordset
            RS.close();
            
            // reopen please
            RS = s.executeQuery("SELECT [ID], [Account Number], Balance, [Account Type] FROM Accounts WHERE Email = '" + email + "';");
            while(RS.next()){
                accounts = accounts + "<option value=" + String.valueOf(RS.getDouble("Account Number")).replace('.', '0') + ">" + String.valueOf(RS.getDouble("Account Number")).replace('.', '0') + " </option>";
                //accountSelected++;
            }
            
            // close recordset
            RS.close();
            
            RS = s.executeQuery("SELECT Transactions.[Account Number], Transactions.[Trans Desc], Transactions.Amount, Transactions.Balance, Transactions.TransDate" +
                " FROM Accounts INNER JOIN Transactions ON Accounts.[Account Number] = Transactions.[Account Number]" +
                " WHERE Accounts.Email='" + email + "' ORDER BY Transactions.TransDate DESC;");
            while(RS.next()){
                transactions = transactions + "<p>" + String.valueOf(RS.getDouble("Account Number")).replace('.', '0') + 
                        "...................................." + RS.getDouble("Amount") + "...................................." +
                        RS.getString("Trans Desc") + "....................................." + RS.getDouble("Balance") + "</p>";
            }
            System.out.println(account);
            System.out.println(accounts);
            System.out.println(transactions);

        } catch(SQLException e){
            System.out.println("Ok there was an error");
            System.out.println(e.getMessage());
        }
}
    // function to validate users within the DB
    public boolean isUser(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex){
            System.out.println("Ok there was an error");
            System.out.println(ex.getMessage());
            }
        try{
            String sql = "SELECT Email, fName, [Password] FROM Users WHERE Email = '" + email + "' and Password = '" + password + "';";
            System.out.println(sql);
            connection = DriverManager.getConnection("jdbc:ucanaccess://I://Fall 2020/IST 412/bank app/BankApplication/web/Bank.accdb");
            connection.setAutoCommit(false);
            s = connection.createStatement();
            ResultSet RS = s.executeQuery(sql);
            RS.next();
            if (RS.getString("Email").compareTo(email) == 0 && RS.getString("Password").compareTo(password) == 0 ){
                fName = RS.getString("fName");
                System.out.println(getFName());
                getUserInfo();
                return true;
                
            } else{
                return false;
            } 
        } catch(SQLException e){
            System.out.println("Ok there was an error");
            System.out.println(e.getMessage());
            return false;
        }
    }
}