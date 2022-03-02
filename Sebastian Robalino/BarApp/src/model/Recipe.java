package model;

public class Recipe {
    private float quantityNeed;
    private Inventory ingredient;
    private Blended juice;

    public float getQuantityNeed() {
        return quantityNeed;
    }

    public void setQuantityNeed(float quantityNeed) {
        this.quantityNeed = quantityNeed;
    }

    public Inventory getIngredient() {
        return ingredient;
    }

    public void setIngredient(Inventory ingredient) {
        this.ingredient = ingredient;
    }

    public Blended getJuice() {
        return juice;
    }

    public void setJuice(Blended juice) {
        this.juice = juice;
    }

    public Recipe(float quantityNeed, Inventory ingredient, Blended juice) {
        this.quantityNeed = quantityNeed;
        this.ingredient = ingredient;
        this.juice = juice;
    }
}
