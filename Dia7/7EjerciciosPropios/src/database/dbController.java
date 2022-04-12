package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Album;

public class dbController {
    private Conection conection;

    private Connection con;
     
    public dbController(){
    	conection = new Conection();
      
    }
    
    
    
     
    public void insert(Album album){
        PreparedStatement ps;
        String sql;
    
       
        try{ //Save personal info
        	
         	Connection con = conection.getConnection();
            sql = "insert into personalInfo(id, firstname, lastname, dni) values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, album.getArtists().getOwnId());
            ps.setString(2, album.getArtists().getFirstname());
            ps.setString(3, album.getArtists().getLastname());
            ps.setString(4, album.getArtists().getDni());
    
            ps.executeUpdate();
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        
        try{ //Save Artist Info
         	Connection con = conection.getConnection();
            sql = "insert into  Artist (ids, musicStyle, idInfo) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, album.getArtists().getOwnId());
            ps.setString(2, album.getArtists().getMusicStyle());
            ps.setInt(3, album.getArtists().getOwnId());
          
    
            ps.executeUpdate();
            
        
        }
        
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        
      
        try{ //Save album
            con = conection.getConnection();
            sql = "insert into album(id, albumName, idArtist) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, album.getOwnId());
            ps.setString(2, album.getName());
            ps.setInt(3, album.getArtists().getOwnId());
    
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Success");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        } 
      
        try{ //Save Songs
        	for(int i = 0; i<album.getSongs().getSize(); i++)
        	{
        		
        	 	Connection con = conection.getConnection();
            con = conection.getConnection();
            sql = "insert into Song(id, title, duration, albumId) values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, album.getSongs().getElement(i).getOwnId());
            ps.setString(2,  album.getSongs().getElement(i).getTitle());
            ps.setDouble(3,  album.getSongs().getElement(i).getDuration());
            ps.setInt(4,  album.getOwnId());
    
            ps.executeUpdate();
        
            
        	}
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        } 
    
        
        
      
        
      
    }
        
        public void selectArtist()
        {
       
        
        	try
        	{
        	 	Connection con = conection.getConnection();
     	   String sql = "select ids, musicStyle, firstname, lastname from Artist a inner join personalInfo p on p.id = a.idInfo";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   ResultSet rs = stmtt.executeQuery(sql);
   	
   		   while (rs.next()) {
   			
   		   System.out.println("Artist Id: " + rs.getInt("ids")+ ", Music Style: " + rs.getString("musicStyle") + ", Name: " + rs.getString("firstname") + " " + rs.getString("lastname") );
   		}
   		  
   		  rs.close();
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
        
            public void selectSongs()
            {
            	Connection con = conection.getConnection();
            	String firstname, lastname;
            	try
            	{
            		 
         	   String sql = "select * from Song";
       		   PreparedStatement stmtt =  con.prepareStatement(sql);
       		   ResultSet rs = stmtt.executeQuery(sql);
       	
       		   while (rs.next()) {
       			
       		   System.out.println("Song Id: " + rs.getInt("id")+ ", Title: " + rs.getString("title") + ", Duration: " + rs.getDouble("duration"));
       		}
       		  
       		  rs.close();
       	stmtt.close();
       		}
       		catch (Exception e) {
       		  e.printStackTrace();
       		}
            }
            
            	   public void selectAlbums()
                   {
                   	Connection con = conection.getConnection();
                   	String firstname, lastname;
                   	try
                   	{
                   		 
                	   String sql = "select * from Album";
              		   PreparedStatement stmtt =  con.prepareStatement(sql);
              		   ResultSet rs = stmtt.executeQuery(sql);
              	
              		   while (rs.next()) {
              			
              		   System.out.println("Album Id: " + rs.getInt("id")+ ",  Album Title: " + rs.getString("albumName") +", Artist ID: " + rs.getInt("idArtist"));
              		}
              		  
              		  rs.close();
              	stmtt.close();
              		}
              		catch (Exception e) {
              		  e.printStackTrace();
              		}
        
        
        
      
    }
    
    

    
}
