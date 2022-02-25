package model;

public class Fruit extends Inventory {
    private float need;

    public float getNeed() {
        return need;
    }

    public void setNeed(float need) {
        this.need = need;
    }

    public Fruit(String name, float price, float quantity, String unit) {
        super(name,price,quantity,unit);
//        this.need = need;
    }

    @Override
    public String toString() {
        return super.toString()+" "+need;
    }
}
