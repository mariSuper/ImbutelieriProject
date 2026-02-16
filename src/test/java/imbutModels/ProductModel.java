package imbutModels;

public class ProductModel {
    private String productName;
    private String quantity;

    // Constructor gol (important pentru JSON)
    public ProductModel() {
    }

    // Constructor complet
    public ProductModel(String productName, String quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    // Getters & Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

