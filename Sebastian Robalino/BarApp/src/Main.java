import model.*;
import ui.UIIngredients;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Inventory> ingredients = new ArrayList<>();
        Inventory ice = new Inventory("Ice",0,0,"ml");
        Inventory milk = new Inventory("Condensed milk",0,0,"ml");
        Inventory sugar = new Inventory("Sugar",0,0,"g");
        ingredients.add(ice);
        ingredients.add(milk);
        ingredients.add(sugar);

        Blended juice = new Blended("Blended of fruit",50,100);

        ArrayList<Fruit> fruits = new ArrayList<>();
        Fruit strawberry = new Fruit("Strawberry",0,0,"g", 100,juice);
        Fruit banana = new Fruit("Banana",0,0,"g", 120,juice);
        Fruit mango = new Fruit("Mango",0,0,"g", 140,juice);
        fruits.add(strawberry);
        fruits.add(banana);
        fruits.add(mango);

        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe(30,ice,juice));
        recipes.add(new Recipe(20,milk,juice));
        recipes.add(new Recipe(8,sugar,juice));

        ArrayList<Size> sizes = new ArrayList<>();
        sizes.add(new Size("Standar", 1.5F,300,"ml",juice));
        sizes.add(new Size("Small", 1.5F,150,"ml",juice));

        UIIngredients.setIngredients(ingredients,fruits,recipes,sizes);
    }
}
