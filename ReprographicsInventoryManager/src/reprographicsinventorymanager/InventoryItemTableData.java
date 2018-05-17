package reprographicsinventorymanager;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryItemTableData { // If you can populate the tableview without this class you can delete it
    SimpleStringProperty itemID;
    SimpleStringProperty itemName;
    SimpleStringProperty itemQuantity;
    SimpleStringProperty itemPrice;

    public SimpleStringProperty getItemID() {
        return itemID;
    }

    public SimpleStringProperty getItemName() {
        return this.itemName;
    }

    public SimpleStringProperty getItemQuantity() {
        return this.itemQuantity;
    }

    public SimpleStringProperty getItemPrice() {
        return itemPrice;
    }

    public InventoryItemTableData(String itemId, String itemName, String itemQuantity, String itemPrice) {
        this.itemID = new SimpleStringProperty(itemId);
        this.itemName = new SimpleStringProperty(itemName);
        this.itemQuantity = new SimpleStringProperty(itemQuantity);
        this.itemPrice = new SimpleStringProperty(itemPrice);
    }

    public static ObservableList<InventoryItemTableData> convertToTableData(ObservableList<InventoryItem> data) {
        ObservableList tableData = FXCollections.observableArrayList();
        for (InventoryItem item : data) {
            tableData.add(new InventoryItemTableData(Integer.toString(item.getId()), (item.name), Integer.toString(item.getCount()), Double.toString(item.getPrice())));
        }
        return tableData;
    }

}
