/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientControl extends Client {

    Client clientUser;
    Client clientUser1;
    ArrayList <Client> Client;
    ATM atm;

    public ClientControl() {
        try{
            connact = DriverManager.getConnection("jdbc:derby://localhost:1527/buee","bue","bue");
            stcat = connact.createStatement();
            System.out.println("Database connected successfully");
     
   
         }catch(SQLException E){
             System.out.println("database failed");
             
         }
    }

    public ClientControl( Client clientUser1) {
        
        this.clientUser1 = clientUser1;
    }


    public ClientControl(int clientID, String username, String password, int NationalID, String AccountType, double balance) {
        super(clientID, username, password, NationalID, AccountType, balance);
    }

    
    

  
    
    public boolean verifyAccount(int ClientID,String username, String password, int NationalID, double balance,String AccountType) {
          return clientUser.createAccount(ClientID,username, password, NationalID, balance,AccountType);
        }
    
    public void changePassword(String Newpassword){
    clientUser.setPassword(Newpassword);
    }
    
    public double viewBalance (){
    return clientUser.getBalance();
    }
    
    public void updateBalance(double updatedBalace){
    clientUser.setBalance(updatedBalace);
    }
    
     public void transferTo(Client A1,Client A2, double x) {
   clientUser.Transfermoney(A1, A2, x);
    }
     
     void clinet_showLogin(String userName, String password) throws SQLException{
     clientUser1.client_login(userName, password);
     }
     
}
