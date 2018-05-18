package reprographicsinventorymanager;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryItemTableData { // If you can populate the tableview without this class you can delete it
    SimpleStringProperty itemID;
    SimpleStringProperty itemName;
    SimpleStringProperty itemQuantity;
    SimpleStringProperty itemPrice;

    public Property itemIDProperty() {
        return itemID;
    }

    public Property itemNameProperty() {
        return itemName;
    }

    public Property itemQuantityProperty() {
        return itemQuantity;
    }

    public Property itemPriceProperty() {
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
