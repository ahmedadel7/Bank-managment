/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Branch {
    private int branchID;
    private String location;
    private String branchName;
    private ATM atmBalance;
    private int constantBalnace = 2000000;

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public ATM getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(ATM atmBalance) {
        this.atmBalance = atmBalance;
    }
    
   
    void manageATMBalane(){
    if (atmBalance.getATM_balance() < constantBalnace){
     atmBalance.setATM_balance(constantBalnace);
        System.out.println("The balance ins the ATM is increased");
    }else 
            System.out.println("The balance in the ATM equal to the constant balance");
    }
}
