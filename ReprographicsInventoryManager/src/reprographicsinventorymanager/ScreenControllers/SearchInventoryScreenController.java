package reprographicsinventorymanager.ScreenControllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import reprographicsinventorymanager.DatabaseManager;
import reprographicsinventorymanager.InventoryItem;
import reprographicsinventorymanager.InventoryItemTableData;


public class SearchInventoryScreenController {
    @FXML private TextField searchItemNameTxtFld;
    @FXML private TextField searchItemIDTxtFld;
    @FXML private Button searchBtn;
    @FXML private TableView<InventoryItem> tableView;
    @FXML private TableColumn<InventoryItem, Integer> idTableColumn;
    @FXML private TableColumn<InventoryItem, String> itemTableColumn;
    @FXML private TableColumn<InventoryItem, Integer> quantityTableColumn;
    @FXML private TableColumn<InventoryItem, Double> priceTableColumn;

    @FXML public void initialize() {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        itemTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML private void search() throws Exception {
        ObservableList<InventoryItem> data;
        try {
            data = DatabaseManager.searchItemsWithQuery(Integer.parseInt(searchItemIDTxtFld.getText()), searchItemNameTxtFld.getText());
        } catch (Exception e) {
            try {
                data = DatabaseManager.searchItemsWithQuery(Integer.parseInt(searchItemNameTxtFld.getText()));
            } catch (Exception ex) {
                data = DatabaseManager.searchItemsWithQuery(searchItemNameTxtFld.getText());
            }
        }
        tableView.setItems(data);
    }

}
