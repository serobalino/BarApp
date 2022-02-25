package model;

public class Size {
    private String name;
    private float price = 0;
    private float quantity = 300;
    private String unit = "ml";
    private Blended juice;

    public Blended getJuice() {
        return juice;
    }

    public void setJuice(Blended juice) {
        this.juice = juice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Size(String name, float price, float quantity, String unit, Blended juice) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.juice = juice;
    }
}
