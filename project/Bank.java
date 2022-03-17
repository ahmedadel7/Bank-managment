/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Bank{
    String address;
    int code;
     EmployeeAccount accountUser;
         ArrayList<EmployeeAccount> E;
Connection connact=null;
    java.sql.Statement stcat=null;
    public Bank() throws SQLException {
        try{
        String connectionURL= "jdbc:derby://localhost:1527/buee";
         connact = DriverManager.getConnection(connectionURL, "bue", "bue");
         stcat=connact.createStatement();
            System.out.println("Database connected Succssfully");
        }catch(SQLException E){
            System.out.println("connection Failed");
        }
    }
         
    public String getAddress() {
        return address;
    }

    public Bank(String address, int code) {
        this.address = address;
        this.code = code;
          E = new ArrayList<EmployeeAccount> ();
      
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }   
    
       void addEmployeeSalary (double amount){
    double Employee_accountBalance =accountUser.getBalance();
            Employee_accountBalance += amount;
            System.out.println("The salary is added");
    }
}
