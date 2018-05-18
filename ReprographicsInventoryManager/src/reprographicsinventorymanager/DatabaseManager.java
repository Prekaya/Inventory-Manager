
package reprographicsinventorymanager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * This is a static class to manage the connections between XAMPP and the application
 * through JDBC
 * @author ADDO_a
 */
public class DatabaseManager {
    
    private DatabaseManager(){} //This class is static; it shouldn't be able to be instanced
    
    private static Connection databaseConnection;
    private static String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/reprographicsdb";
    private static ResultSet resultSet;

    private static void processError(Exception e){
        System.out.println(e);
    }
    
    private  static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            if (databaseConnection != null) {
                return;
            }
            //Making a connection using the default root phpMyAdmin account
            databaseConnection = DriverManager.getConnection(DATABASE_URL, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void addItem (InventoryItem item){
        try {
            connect();
            Statement statement = databaseConnection.createStatement();
            
            String command = String.format("INSERT INTO `INVENTORY`"
                    + "VALUES (%d, '%s', 0, 'null' , 0, %d, %d)", 
                    item.getId(), item.name, (item.isBoughtOnDemand) ? 1 : 0, item.getSupplierId());
            statement.executeUpdate(command);
            statement.close();  
            
        } catch (Exception e) {
            processError(e);
        }

    }

    public static ObservableList<InventoryItem> searchItemsWithQuery(int id, String name) throws SQLException, ClassNotFoundException {

        System.out.println("Searching by id and name");

        ObservableList<InventoryItem> data = FXCollections.observableArrayList();
        
        int itemID;
        String itemName;
        int itemQuantity;
        Double itemPrice;

        PreparedStatement statement;
        String query = "SELECT * FROM `inventory` WHERE ItemID CONTAINS " + Integer.toString(id) + " OR " + "ItemName LIKE '%" + name + "%';";

        connect();
        statement = databaseConnection.prepareStatement(query);

        statement.execute(query);
        resultSet = statement.getResultSet();

        System.out.println("Data retrieved");

        while (resultSet.next()) {
            itemID = resultSet.getInt("ItemID");
            itemName = resultSet.getString("ItemName");
            itemQuantity = resultSet.getInt("Quantity");
            itemPrice = resultSet.getDouble("Price");
            data.add(new InventoryItem(itemID, itemName, 0, false, itemQuantity, itemPrice));
        }
        return data;
    }

    public static ObservableList<InventoryItem> searchItemsWithQuery(int id) throws SQLException, ClassNotFoundException {

        System.out.println("Searching by id");

        ObservableList<InventoryItem> data = FXCollections.observableArrayList();

        int itemID;
        String itemName;
        int itemQuantity;
        Double itemPrice;

        PreparedStatement statement;
        String query = "SELECT * FROM `inventory` WHERE ItemID CONTAINS " + Integer.toString(id);

        connect();
        statement = databaseConnection.prepareStatement(query);

        statement.execute(query);
        resultSet = statement.getResultSet();

        System.out.println("Data retrieved");

        while (resultSet.next()) {
            itemID = resultSet.getInt("ItemID");
            itemName = resultSet.getString("ItemName");
            itemQuantity = resultSet.getInt("Quantity");
            itemPrice = resultSet.getDouble("Price");
            data.add(new InventoryItem(itemID, itemName, 0, false, itemQuantity, itemPrice));
        }
        return data;
    }

    public static ObservableList<InventoryItem> searchItemsWithQuery(String name) throws SQLException, ClassNotFoundException {

        System.out.println("Searching by name");

        ObservableList<InventoryItem> data = FXCollections.observableArrayList();

        int itemID;
        String itemName;
        int itemQuantity;
        Double itemPrice;

        PreparedStatement statement;
        String query = "SELECT * FROM `inventory` WHERE ItemName LIKE '%" + name + "%';";

        connect();
        statement = databaseConnection.prepareStatement(query);

        statement.execute(query);
        resultSet = statement.getResultSet();

        System.out.println("Data retrieved");

        while (resultSet.next()) {
            itemID = resultSet.getInt("ItemID");
            itemName = resultSet.getString("ItemName");
            itemQuantity = resultSet.getInt("Quantity");
            itemPrice = resultSet.getDouble("Price");
            data.add(new InventoryItem(itemID, itemName, 0, false, itemQuantity, itemPrice));
        }
        return data;
    }

}
