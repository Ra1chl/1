package Space;

public class Item {
    private String itemName;
    private int price;
    private String description;

    public Item(String itemName,int price, String description) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
    }


    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
