
import java.sql.*;
import javax.swing.*;
public class mysqlconnect {
    
    Connection conn = null;
    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/HB_db","root","");
            //JOptionPane.showMessageDialog(null,"Connection Established");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}