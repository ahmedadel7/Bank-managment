/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author agh
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Mostafa Gado
 */
public class EmployeeControl extends EmployeeAccount{
    
     EmployeeAccount accountUser;
     Client clientUser;
      ArrayList <Client> Client;
    ArrayList <EmployeeAccount> account;

    public EmployeeControl() {
          try{
            connact = DriverManager.getConnection("jdbc:derby://localhost:1527/buee","bue","bue");
            stcat = connact.createStatement();
            System.out.println("Database connected successfully");
     
   
         }catch(SQLException E){
             System.out.println("database failed");
             
         }
    }
    

    public EmployeeControl(int accountID,String userName, String password, String AccountType, double balance, int NationalID) {
        super(accountID,userName, password, AccountType, balance, NationalID);
    }

    
    
    public boolean searchAcount(int nationalID){
        for (int i =0; i < Client.size();i++){
            if(nationalID == clientUser.getClientID()){ // shange the serach to search for the national ID
                System.out.println("The account is found");
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
        
    
    public void deleteAccount(String username){
    try{
        String s="";
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue")) {
            stcat = conn.createStatement();
            ResultSet rs;
            rs=stcat.executeQuery("SELECT * FROM CLIENT WHERE USERNAME ="+ "'" + username + "'");
            if(rs.next()){
                s=rs.getString("USERNAME");
            
            }
           String sql = "DELETE FROM CLIENT WHERE USERNAME="+ "'" + s + "'";
Statement st = conn.createStatement();
st.executeUpdate(sql);
            
            stcat.close();
            rs.close();
        }
    }catch(SQLException e){
        System.out.println("err");
    }
    }
    
    
  public  void Employee_showLogin(String username,String password) throws SQLException{
    accountUser.Employee_Login(username, password);
    }
    
    
}