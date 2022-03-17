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

public class Client {
    String username;
    String password;
  int NationalID;
    String AccountType;
    double balance;
     int clientID;
    ArrayList <Client> Client;
    Connection connact=null;
    java.sql.Statement stcat=null;
    ATM A;
    public Client() {
          try{
            connact = DriverManager.getConnection("jdbc:derby://localhost:1527/buee","bue","bue");
            stcat = connact.createStatement();
            System.out.println("Database connected successfully");
     
   
         }catch(Exception E){
             System.out.println("database failed");
             
         }
          
       
    }

   

  

    public Client( int clientID,String username, String password, int NationalID, String AccountType, double balance) {
        this.username = username;
        this.password = password;
        this.NationalID = NationalID;
        this.AccountType = AccountType;
        this.balance = balance;
        this.clientID = clientID;  
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNationalID() {
        return NationalID;
    }

    public void setNationalID(int NationalID) {
        this.NationalID = NationalID;
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

    public ArrayList<Client> getClient() {
        return Client;
    }

    public void setClient(ArrayList<Client> Client) {
        this.Client = Client;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

  

  
    
   public boolean client_login (String name, String pass)
    {
     try{
            
             Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");



 stcat = conn.createStatement();
            ResultSet rs = stcat.executeQuery("select * from CLIENT" );
            
            
while(rs.next()){
if(rs.getString("USERNAME").equals(name)&&rs.getString("PASSWORD").equals(pass))
return true;

}
rs.close();
stcat.close();
connact.close();

    
    }catch(SQLException e){
          System.out.println("failed");
    }
     return false;

}
   
   public boolean client_Alogin (String pass)
    {
     try{
   Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");



 stcat = conn.createStatement();
            ResultSet rs = stcat.executeQuery("select * from CLIENT" );
            


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
   
      
   void Amount_withDraw(double amount){
        if (balance >= amount){
        balance -=amount;
        }
        else {
            System.out.println("The balance in the account is less then the amount you want to withdraw");
        }
   }
   void Amount_deposit(double amount){
     balance += amount;
   }
   public boolean createAccount(int ClientID,String username, String password, int NationalID, double balance,String AccountType) {
       try{
           Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");
          
            Statement st = conn.createStatement();
    String sql = "INSERT INTO CLIENT(CLIENTID,USERNAME,PASSWORD,NATIONALID,BALANCE,ACCOUNTTYPE) VALUES('"+ClientID+"', '"+username+"', '"+password+"', '"+NationalID+"', '"+balance+"', '"+AccountType+"')'";
           
             st.executeUpdate(sql);
            st.close();
            conn.close();
             System.out.println("Client account has been successfully created");
             return true;
        }catch(SQLException E){
            System.out.println(E);
    
   }
       return false;
   }
   public void Transfermoney(Client c1,Client c2,double x){
         try{
            String sql="SELECT*FROM CLIENT";
            


Statement st = connact.createStatement();
ResultSet rs=null;
rs=st.executeQuery(sql);
while(rs.next()){
if(rs.getString("Username").equals(c1.username)){

        if (x <= balance) {
        c1.Amount_withDraw(x);
        c2.Amount_deposit(x);
        System.out.println("\nTransfer succesful. Tansfered: $" + c1.getBalance());
    } else if (x > balance) {
        System.out.println("\nTransfer failed, not enough balance!");
    }
}
}
rs.close();
st.close();
connact.close();

    
    }catch(SQLException e){
          System.out.println("failed");
    }
    

   }
   
   public double Client_Balance(String username){
       double x =0.0;
        try {
              Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");
            
             stcat = conn.createStatement();
            ResultSet rs;
            rs=stcat.executeQuery("SELECT BALANCE FROM CLIENT WHERE USERNAME ="+ "'" + username + "'");           
       
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
       public String Client_username(String password){
       String x ="";
        try {
              Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");
            
             stcat = conn.createStatement();
            ResultSet rs;
            rs=stcat.executeQuery("SELECT USERNAME FROM CLIENT WHERE PASSWORD ="+ "'" + password + "'");           
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
            public double Client_ATM(String password){
       double x =0.0;
        try {
              Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");
            
             stcat = conn.createStatement();
            ResultSet rs;
            rs=stcat.executeQuery("SELECT BALANCE FROM CLIENT WHERE PASSWORD ="+ "'" + password + "'");           
        Client c=new Client();
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
//                 public double Client_Withdraw(String password){
//       double x =0.0;
//        try {
//              Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/buee", "bue", "bue");
//            
//             stcat = conn.createStatement();
//            ResultSet rs;
//            rs=stcat.executeQuery("SELECT BALANCE FROM CLIENT WHERE PASSWORD ="+ "'" + password + "'");           
//       
//            if(rs.next()){
//                x=rs.getDouble("BALANCE");
//            }
//                       double s= A.Client_withdraw(x);
//            return s;
//            String sql="UPDATE CLIENT WHERE PASSWORD= "+ rs +"SET BALANCE="+s;
//            stcat.executeUpdate(sql);
//        
//            rs.close();
//            stcat.close();
//            connact.close();
//             
//       
//            } catch (SQLException ex) {
//            System.out.println(ex);
//            }
//     return 0;
//   }
   }

