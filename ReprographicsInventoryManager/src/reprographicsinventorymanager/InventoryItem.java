package reprographicsinventorymanager;

/**
 * Obviously, this is meant to represent inventory items
 * @author ADDO_a
 */
public class InventoryItem {
    
    public Integer id;
    public String name;
    public Integer count;
    public Double price;
    public boolean isBoughtOnDemand = false;
    private int supplierId;
    
    public Integer getId() {
        return id;
    }

    public String getName() { return  name; }

    public int getSupplierId() {
        return supplierId;
    }

    public Integer getCount() { return count; }

    public Double getPrice() { return price; }

    public boolean isBoughtOnDemand() { return isBoughtOnDemand; }

    public InventoryItem(int id, String name, int supplierId, boolean boughtonDemand, int count, double price) {
        this.id = id;
        this.name = name;
        this.supplierId = supplierId;
        this.isBoughtOnDemand = boughtonDemand;
        this.count = count;
        this.price = price;
    }
}
