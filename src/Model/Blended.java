package model;

public class Blended {
    private String name;
    private float quantityNeed;
    private float product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantityNeed() {
        return quantityNeed;
    }

    public void setQuantityNeed(float quantityNeed) {
        this.quantityNeed = quantityNeed;
    }

    public float getProduct() {
        return product;
    }

    public void setProduct(float product) {
        this.product = product;
    }

    public Blended(String name, float quantityNeed, float product) {
        this.name = name;
        this.quantityNeed = quantityNeed;
        this.product = product;
    }
}
