/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaBeans;

import java.sql.SQLException;

/**
 *
 * @author cammy
 */
public class test {
    public static void main(String[] args) throws SQLException{
        
        LoginManager lm = new LoginManager();
        
        lm.setEmail("camks12@gmail.com");
        lm.setPassword("testPassword");
//        lm.setAccountSelected("35402393847041838");
//        lm.setAmount("150.00");
//        lm.makeDeposit();
        
        System.out.println(lm.getValidate());
        lm.getUserInfo();
//    Customer cm = new Customer();
//    cm.setEmail("camks12@gmail.com");
//    cm.getUserInfo();
    }
}
