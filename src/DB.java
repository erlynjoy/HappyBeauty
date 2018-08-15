import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class DB {
    static Connection con=null;
    static Statement st = null;
    static PreparedStatement ps=null;
    ResultSet rs=null;
    
   
    public static void reset(){
    try{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost","root","");
    Statement st = null;
    
    
    String dbDrop = "DROP DATABASE IF EXISTS HB_db";
       try{
        st = con.createStatement();
        st.executeUpdate(dbDrop);
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
       
        create();
        //con=msqlconnect.ConnectDb();
        tables();
        
        }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
    
    
     public static void create(){   
        
         try{
         con = DriverManager.getConnection("jdbc:mysql://localhost","root","");
        String dbCreate = "CREATE DATABASE IF NOT EXISTS HB_db";
       
        st = con.createStatement();
        st.executeUpdate(dbCreate);
        
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
       
       con = mysqlconnect.ConnectDb();
        tables();
     }
     
     public static void tables(){
       
       String tblACCOUNT = "CREATE TABLE ACCOUNT("
                + "e_id INT NOT NULL AUTO_INCREMENT,"
                + "username VARCHAR(20),"
                + "password VARCHAR(20),"
                + "type VARCHAR(20),"
                + "status VARCHAR(20),"
                + "PRIMARY KEY (e_id))";
       
        String tblACCOUNT1 = "INSERT INTO ACCOUNT (e_id,"
                + "username,"
                + "password,"
                + "type,"
                + "status)"
                      //+ "VALUES(1,'Admin','admin','admin','ACTIVE')";
                        + "VALUES(1,'HB_admin','elainecoy','admin','ACTIVE')";
           try{
            st = con.createStatement();
            st.executeUpdate(tblACCOUNT);
            st.executeUpdate(tblACCOUNT1);
        }
        catch(Exception e){
          //JOptionPane.showMessageDialog(null, e);
        }
        
        String tblPRODUCT = "CREATE TABLE PRODUCT("
                + "p_id INT NOT NULL AUTO_INCREMENT,"
                + "p_name VARCHAR(255),"
                + "p_barcode VARCHAR(50),"
                + "p_brand VARCHAR(50),"
                + "p_weight VARCHAR(50),"
                + "p_img LONGBLOB,"
                + "c_stock VARCHAR(50),"
                + "PRIMARY KEY (p_id))";
        try{
            
            st = con.createStatement();
            st.executeUpdate(tblPRODUCT);
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        
        String tblADDED_BY = "CREATE TABLE ADDED_BY("
                + "emp_id INT,"
                + "Abarcode VARCHAR(50),"
                + "date_in VARCHAR(50),"
                + "qty_in VARCHAR(50))";
        try{
            
            st = con.createStatement();
            st.executeUpdate(tblADDED_BY);
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        
        String tblIN = "CREATE TABLE IN("
                + "i_barcode VARCHAR(50),"
                + "i_date VARCHAR(50),"
                + "i_qty VARCHAR(50))";
        try{
            
            st = con.createStatement();
            st.executeUpdate(tblIN);
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        
        String tblRELEASED_BY = "CREATE TABLE RELEASED_BY("
                + "eid INT,"
                + "Rbarcode VARCHAR(50),"
                + "date_out VARCHAR(50),"
                + "qty_out VARCHAR(50))";
        try{
            
            st = con.createStatement();
            st.executeUpdate(tblRELEASED_BY);
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        
        String tblEMPLOYEE = "CREATE TABLE EMPLOYEE("
                + "e_id INT NOT NULL AUTO_INCREMENT,"
                + "e_name VARCHAR(30),"
                + "e_bday VARCHAR(20),"
                + "e_address VARCHAR(50),"
                + "PRIMARY KEY (e_id))";
        
        String tblEMPLOYEE1 = "INSERT INTO EMPLOYEE (e_id,"
                + "e_name,"
                + "e_bday,"
                + "e_address)"
                       + "VALUES(1,'Jacinda Carag','January 19,1996','Angeles City, Pampanga')";
        try{
            
            st = con.createStatement();
            st.executeUpdate(tblEMPLOYEE);
            st.executeUpdate(tblEMPLOYEE1);
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        
        String tblACTIVITY = "CREATE TABLE ACTIVITY("
                + "act_id INT NOT NULL AUTO_INCREMENT,"
                + "act_details VARCHAR(255),"
                + "act_user VARCHAR(50),"
                + "act_date VARCHAR(50),"
                + "PRIMARY KEY (act_id))";
        try{
            
            st = con.createStatement();
            st.executeUpdate(tblACTIVITY);
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        
     }
            


}