/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;




import java.util.ArrayList;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EmployeeAccount {
    String AccountType;
    double balance;
    private String userName;
    private String password;
     int accountID;
    private int NationalID;
    ArrayList<EmployeeAccount> E; 
    Connection connact=null;
    java.sql.Statement stcat=null;
    public EmployeeAccount(){
     
         try{
            connact = DriverManager.getConnection("jdbc:derby://localhost:1527/buee","bue","bue");
            stcat = connact.createStatement();
            System.out.println("Database connected successfully");
     
   
         }catch(Exception E){
             System.out.println("database failed");
             
         }
       
         
    }
    public EmployeeAccount(int accountID,String userName, String password,String AccountType, double balance,int NationalID) {
        this.AccountType = AccountType;
        this.balance = balance;
        this.userName = userName;
        this.password = password;
       this.NationalID=NationalID;
       this.accountID=accountID;
      
    }

   


    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  int getAccountID() {
        return accountID;
    }

    public  void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getNationalID() {
        return NationalID;
    }

    public void setNationalID(int NationalID) {
        this.NationalID = NationalID;
    }

   

    public ArrayList<EmployeeAccount> getEmployee() {
        return E;
    }

    public void setEmployee(ArrayList<EmployeeAccount> E) {
        this.E = E;
    }
    
    public boolean Employee_Login (String name, String pass) 
    {
      try{
           
            

  Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");

 stcat = conn.createStatement();
  ResultSet rs = stcat.executeQuery("select * FROM EMP_ACCOUNT" );
            ResultSetMetaData rsmd = rs.getMetaData();
while(rs.next()){
if(rs.getString("USERNAME").equals(name)&&rs.getString("PASSWORD").equals(pass))
return true;

}
rs.close();
stcat.close();
conn.close();

    
    }catch(SQLException e){
          System.out.println("efailed");
    }
     return false;

}
     public boolean Employee_Alogin (String pass)
    {
      try{
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");



 stcat = conn.createStatement();
            ResultSet rs = stcat.executeQuery("select * from EMP_ACCOUNT" );
            
    while(rs.next()){
if(rs.getString("PASSWORD").equals(pass))
return true;

}
rs.close();
stcat.close();
conn.close();

    
    }catch(SQLException e){
          System.out.println("failed");
    }
     return false;

}
     public double EMP_Balance(String username){
       double x =0.0;
        try {
              Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");
            
             stcat = conn.createStatement();
            ResultSet rs;
            rs=stcat.executeQuery("SELECT BALANCE FROM EMP_ACCOUNT WHERE USERNAME ="+ "'" + username + "'");           
        
            if(rs.next()){
                x=x+rs.getDouble("BALANCE");
              
       
                 return rs.getDouble("BALANCE");
            }

            rs.close();
            stcat.close();
            connact.close();
             
       
            } catch (SQLException ex) {
            System.out.println(ex);
            }
       return 0;
   }
      public String EMP_username(String password){
       String x ="";
        try {
              Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");
            
             stcat = conn.createStatement();
            ResultSet rs;
            rs=stcat.executeQuery("SELECT USERNAME FROM EMP_ACCOUNT WHERE PASSWORD ="+ "'" + password + "'");           
        Client c=new Client();
            if(rs.next()){
                x=x+rs.getString("USERNAME");
              
       
                 return rs.getString("USERNAME");
            }

            rs.close();
            stcat.close();
            connact.close();
             
       
            } catch (SQLException ex) {
            System.out.println(ex);
            }
     return "";
   }
            public double Emp_ATM(String password){
       String x ="";
        try {
              Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");
            
             stcat = conn.createStatement();
            ResultSet rs;
            rs=stcat.executeQuery("SELECT BALANCE FROM EMP_ACCOUNT WHERE PASSWORD ="+ "'" + password + "'");           
       
            if(rs.next()){
                x=x+rs.getDouble("BALANCE");
              
       
                 return rs.getDouble("BALANCE");
            }

            rs.close();
            stcat.close();
            connact.close();
             
       
            } catch (SQLException ex) {
            System.out.println(ex);
            }
     return 0;
   }
            
}
    
