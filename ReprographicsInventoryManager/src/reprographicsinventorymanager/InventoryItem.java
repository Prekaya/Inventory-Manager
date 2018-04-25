package reprographicsinventorymanager;

/**
 * Obviously, this is meant to represent inventory items
 * @author ADDO_a
 */
public class InventoryItem {
    
    private int id;
    public String name;
    public int count;
    public double price;
    
    public boolean isBoughtOnDemand = false;
    
    private int supplierId;  
    
    public int getId() {
        return id;
    }

    public int getSupplierId() {
        return supplierId;
    }
    
    
    
    public InventoryItem(int id, String name, int supplierId, boolean boughtonDemand) {
        this.id = id;
        this.name = name;
        this.supplierId = supplierId;
        this.isBoughtOnDemand = boughtonDemand;
    }
}
