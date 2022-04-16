package database;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.*;

public class dbController {
    private Conection conection;

    private Connection con;
     
    public dbController(){
    	conection = new Conection();
      
    }
    
  
    
   

    
    
   
        
     
    
  //SELECTS
        
    
        

        

        
       
        
        //DELETES
        
        public void deletePerson(int idInfo)
        {
        	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Delete from personInfo where idInfo = " +idInfo +";";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
        
        
        public void deleteProduct(int idProduct)
        {
        	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Delete from Products where idProduct = " +idProduct +";";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        	
        }
    
        public void deleteBilling(int idBilling)
        {
        	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Delete from Billings  where idBilling = " +idBilling +";";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        	
        }
        
        
        //UPDATES
        
        public void updatePerson(int idPerson, String firstName, String lastname, String dni, String Address, Date date)
        {
	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Update personInfo  "
     	   		+ "SET firstname = ?, lastname = ?, dni = ?, Address = ? ,birth = ?" 
     	   		+ "where idPerson =?;";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   
   		   stmtt.setString(1, firstName);
   		   stmtt.setString(2, lastname);
   		   stmtt.setString(3, dni);
   		   stmtt.setString(4, Address);
   		   stmtt.setDate(5, date);
   		   stmtt.setInt(6, idPerson);
   		   
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
        
        public void updateProduct(int idProduct, double price, int ammount, int minStock)
        {
	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Update Products  "
     	   		+ "SET price = ?, ammount = ?, minStock = ?" 
     	   		+ "where idProduct = ?;";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		
   		   stmtt.setDouble(1, idProduct);
   		   stmtt.setInt(2, ammount);
   		 stmtt.setInt(3, minStock);
   		 stmtt.setInt(4, idProduct);
   	
   	   stmtt.executeUpdate();
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
        
        
        public void updateBilling(int idBilling, Date datesql, int idClient, int idVendor, int idProd)
        {
	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Update Billings  "
     	   		+ "SET datesql =  ? , idClient = ?  , idVendor = =  , idProd= ?"  
     	   		+ "where idBilling = ?;";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   stmtt.setDate(1, datesql);
   		   stmtt.setInt(2, idClient);
   		   stmtt.setInt(3, idVendor);
   		   stmtt.setInt(4, idProd);
   		 stmtt.setInt(5, idBilling);
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }

	

    
}
