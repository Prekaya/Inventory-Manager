
package reprographicsinventorymanager;
import java.sql.*;

/**
 * This is a static class to manage the connections between XAMPP and the application
 * through JDBC
 * @author ADDO_a
 */
public class DatabaseManager {
    
    private DatabaseManager(){} //This class is static; it shouldn't be able to be instanced
    
    private static Connection databaseConenction;
    private static String DATABASE_URL = "jdbc:mysql://127.0.0.1/reprographics";  
    
    private static void processError(Exception e){
        System.out.println(e);
    }
    
    private  static void connect() throws SQLException{
        try {
            if (databaseConenction != null) {
                return;
            }
            //Making a conenction using the default root phpMyAdmin account
            databaseConenction = DriverManager.getConnection(DATABASE_URL, "root", "");
        } catch (SQLException sQLException) {
            System.out.println(sQLException);
        }    
    }
    
    public static void addItem (InventoryItem item){
        try {
            connect();
            Statement statement = databaseConenction.createStatement();
            
            String command = String.format("INSERT INTO `INVENTORY`"
                    + "VALUES (%d, '%s', 0, 'null' , 0, %d, %d)", 
                    item.getId(), item.name, (item.isBoughtOnDemand) ? 1 : 0, item.getSupplierId());
            statement.executeUpdate(command);
            statement.close();  
            
        } catch (Exception e) {
            processError(e);
        }
      
    }
    
}
