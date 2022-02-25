package model;

public class Blended {
    private String name;
    private float quantity = 100;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Blended(String name, float quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
