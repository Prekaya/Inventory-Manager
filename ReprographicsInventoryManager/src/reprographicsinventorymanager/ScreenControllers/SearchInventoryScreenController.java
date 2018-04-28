package reprographicsinventorymanager.ScreenControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import reprographicsinventorymanager.InventoryItem;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class SearchInventoryScreenController {
    private Connection connection; //TODO: Add database url
    private Statement statement;
    private ResultSet resultSet;
    private static String url = "jdbc:mysql://localhost/";
    private static String userName = "root";
    private static String dbName = "reprographicsdb";
    private String query = "select ItemID, Item Name, " + "from reprographicsdb Inventory " + "where ";
    @FXML private TextField searchItemNameTxtFld;
    @FXML private TextField searchItemIDTxtFld;
    @FXML private Button searchBtn;
    @FXML private TableView<InventoryItem> tableView;
    @FXML private TableColumn<InventoryItem, Integer> idTableColumn;
    @FXML private TableColumn<InventoryItem, String> itemTableColumn;
    @FXML private TableColumn<InventoryItem, Integer> quantityTableColumn;
    @FXML private TableColumn<InventoryItem, Double> priceTableColumn;

    public SearchInventoryScreenController() throws SQLException {
        this.connection = getConnection(url + dbName + userName);
        this.statement = connection.createStatement();
        this.idTableColumn = new TableColumn<>();
        this.itemTableColumn = new TableColumn<>();
        this.quantityTableColumn = new TableColumn<>();
        this.priceTableColumn = new TableColumn<>();
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        itemTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML private void search() throws SQLException {
        int itemID;
        String itemName;
        int itemQuantity;
        Double itemPrice;
        String searchName = searchItemNameTxtFld.getText();
        int searchID = Integer.parseInt(searchItemIDTxtFld.getText());
        query = query + "(ITEMID = " + Integer.toString(searchID) + "OR Item Name = " + searchName;
        this.resultSet = statement.executeQuery(query);
        ObservableList<InventoryItem> data = FXCollections.observableArrayList();
        while (resultSet.next()) {
            itemID = resultSet.getInt("ItemID");
            itemName = resultSet.getString("Item Name");
            itemQuantity = resultSet.getInt("Quantity");
            itemPrice = resultSet.getDouble("Price");

            data.add(new InventoryItem(itemID, itemName, 0, false, itemQuantity, itemPrice));
        }
        tableView.setItems(data);
    }

}
