package domain;

public class Product {
    private Long productId;
    private Temperature temperature;
    private String productName;
    private Integer cost;

    public Product(Temperature temperature, String productName, Integer cost) {
        this.temperature = temperature;
        this.productName = productName;
        this.cost = cost;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Temperature getTemperture() {
        return temperature;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s : %d\n", productId, productName, cost);
    }
}
