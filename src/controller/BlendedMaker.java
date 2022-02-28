package controller;

import model.*;
import ui.UIIngredients;
import ui.UIMenu;

import java.util.ArrayList;

public class BlendedMaker {

    private ArrayList<Inventory> ingredients;
    private ArrayList<Fruit> fruits;
    private ArrayList<Recipe> recipes;
    private ArrayList<Size> sizes;

    /**
     * Factor to do any size blended
     * @param size
     * @param juice
     * @return
     */
    private float factorRecipe(Size size, Blended juice){
        return size.getQuantity()/juice.getProduct();
    }

    /**
     * Factor to do blended fruit to blended recipe
     * @param fruit
     * @param juice
     * @param size
     * @return
     */
    private float fruitFactor(Fruit fruit, Blended juice, Size size){
        return ((fruit.getNeed()*juice.getQuantityNeed())/fruit.getOut())*this.factorRecipe(size,juice);
    }

    public BlendedMaker(ArrayList<Inventory> ingredients, ArrayList<Fruit> fruits, ArrayList<Recipe> recipes, ArrayList<Size> sizes) {
        this.ingredients = ingredients;
        this.fruits = fruits;
        this.recipes = recipes;
        this.sizes = sizes;
    }

    /**
     * Function to check if exist materials to do recipe
     * @param fruit
     * @param size
     * @return
     */
    public boolean canMakeRecipe(Fruit fruit,Size size){
        UIMenu.showTitle();
        UIIngredients.titleRecipe(fruit,size);
        Blended juice = fruit.getJuice();
        int haveMaterials = 0;
        float factRecipe = factorRecipe(size, juice);
        float fruitNeed = fruitFactor(fruit,juice,size);
        float aux = 0;
        if(fruit.getQuantity()>=fruitNeed){
            System.out.println(" ✔️"+fruit.getName()+" "+fruitNeed+fruit.getUnit());
        }else{
            System.out.println(" ❌️"+fruit.getName()+" "+fruitNeed+fruit.getUnit()+", you have "+fruit.getQuantity()+fruit.getUnit());
            haveMaterials++;
        }
        for (Recipe i: recipes){
            aux =  i.getQuantityNeed()*factRecipe;
            if(i.getIngredient().getQuantity()>=aux){
                System.out.println(" ✔️"+i.getIngredient().getName()+" "+aux+i.getIngredient().getUnit());
            }else{
                System.out.println(" ❌️"+i.getIngredient().getName()+" "+aux+i.getIngredient().getUnit()+", you have "+i.getIngredient().getQuantity()+fruit.getUnit());
                haveMaterials++;
            }
        }
        return haveMaterials == 0;
    }

    /**
     * Function to change current inventory and fruits
     * @param fruit
     * @param size
     */
    public void newInventory(Fruit fruit,Size size){
        Blended juice = fruit.getJuice();
        float factRecipe = factorRecipe(size, juice);
        float fruitNeed = fruitFactor(fruit,juice,size);
        float aux = 0;
        fruit.setQuantity(fruit.getQuantity()-fruitNeed);
        for (Recipe i: recipes){
            aux =  i.getQuantityNeed()*factRecipe;
            i.getIngredient().setQuantity(i.getIngredient().getQuantity()-aux);
        }
    }
}
