package model;

public class Fruit extends Inventory {
    private float need;
    private float out = 100;
    private Blended juice;

    public Blended getJuice() {
        return juice;
    }

    public void setJuice(Blended juice) {
        this.juice = juice;
    }
    public float getNeed() {
        return need;
    }

    public void setNeed(float need) {
        this.need = need;
    }

    public float getOut() {
        return out;
    }

    public void setOut(float out) {
        this.out = out;
    }


    public Fruit(String name, float price, float quantity, String unit, float need, Blended juice) {
        super(name, price, quantity, unit);
        this.need = need;
        this.juice = juice;
    }
}
