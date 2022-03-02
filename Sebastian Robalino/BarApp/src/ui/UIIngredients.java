package ui;

import controller.BlendedMaker;
import model.Fruit;
import model.Inventory;
import model.Recipe;
import model.Size;

import java.util.ArrayList;
import java.util.Scanner;

public class UIIngredients {

    public static void titleRecipe(Fruit fruit, Size size) {
        System.out.println(size.getQuantity() + size.getUnit() + " " + fruit.getName() + " Smoothie Recipe");
    }

    public static void setIngredients(ArrayList<Inventory> ingredients, ArrayList<Fruit> fruits, ArrayList<Recipe> recipes, ArrayList<Size> sizes) {
        UIMenu.showTitle();
        System.out.println("Set Inventory");
        for (Inventory i : ingredients) {
            i.setQuantity(getValueQuality(i.getName() + " [" + i.getUnit() + "]: "));
        }
        for (Fruit i : fruits) {
            i.setQuantity(getValueQuality(i.getName() + " [" + i.getUnit() + "]: "));
        }
        UIMenu.showMainMenu(ingredients, fruits, recipes, sizes);
    }

    public static void showInventory(ArrayList<Inventory> ingredients, ArrayList<Fruit> fruits, ArrayList<Recipe> recipes, ArrayList<Size> sizes) {
        UIMenu.showTitle();
        System.out.println("Inventory\n");
        for (Inventory i : ingredients) {
            System.out.println(i);
        }
        for (Fruit i : fruits) {
            System.out.println(i);
        }
        UIMenu.showMainMenu(ingredients, fruits, recipes, sizes);
    }


    public static void showFlavorsMenu(ArrayList<Inventory> ingredients, ArrayList<Fruit> fruits, ArrayList<Recipe> recipes, ArrayList<Size> sizes) {
        UIMenu.showTitle();
        System.out.println("Flavors to Sell\n");
        int response = 0;
        int j = 1;
        for (Fruit i : fruits) {
            System.out.println(j + ". " + i.getName());
            j++;
        }
        System.out.println("0. Main menu");

        do {
            response = UIMenu.getMenuValue("Press the flavor option number on the keyboard followed by the enter key: ");
            if (response <= 0 || response > j) {
                if (response == 0) {
                    UIMenu.showMainMenu(ingredients, fruits, recipes, sizes);
                } else {
                    System.out.println("❌ Please select a correct flavor");
                    showFlavorsMenu(ingredients, fruits, recipes, sizes);
                }
            } else {
                System.out.println(fruits.get(response - 1).getName());
                showSizeMenu(ingredients, fruits, recipes, sizes, fruits.get(response - 1));
                UIMenu.showMainMenu(ingredients, fruits, recipes, sizes);
            }
        } while (response != 0);
    }

    private static void showSizeMenu(ArrayList<Inventory> ingredients, ArrayList<Fruit> fruits, ArrayList<Recipe> recipes, ArrayList<Size> sizes, Fruit fruit) {
        int j = 1;
        int response = 0;
        if (sizes.size() > 1) {
            UIMenu.showTitle();
            System.out.println("Drink size\n");
            for (Size i : sizes) {
                System.out.println(j + ". " + i.getName() + " [" + i.getQuantity() + i.getUnit() + "]");
                j++;
            }
            do {
                response = UIMenu.getMenuValue("Press the size option number on the keyboard followed by the enter key: ");
                if (response <= 0 || response > sizes.size()) {
                    System.out.println("❌ Please select a correct size");
                    showSizeMenu(ingredients, fruits, recipes, sizes, fruit);
                } else {
                    tryDoBlended(ingredients, fruits, recipes, sizes, fruit, sizes.get(response - 1));
                }
            } while (response != -1);
        } else {
            tryDoBlended(ingredients, fruits, recipes, sizes, fruit, sizes.get(0));
        }
    }

    private static void tryDoBlended(ArrayList<Inventory> ingredients, ArrayList<Fruit> fruits, ArrayList<Recipe> recipes, ArrayList<Size> sizes, Fruit fruit, Size size) {
        BlendedMaker process = new BlendedMaker(ingredients, fruits, recipes, sizes);
        boolean haveMat = process.canMakeRecipe(fruit, size);
        if (haveMat) {
            process.newInventory(fruit, size);
        } else {
            System.out.print(" \uD83D\uDE14 You don't have enough ingredients.");
        }
        UIMenu.showMainMenu(ingredients, fruits, recipes, sizes);
    }


    private static float getValueQuality(String msg) {
        System.out.print("> " + msg);
        Scanner keyboard = new Scanner(System.in);
        float input = 0;
        boolean error = false;
        if (keyboard.hasNext()) {
            if (keyboard.hasNextFloat()) {
                input = keyboard.nextFloat();
                error = input <= 0;
            } else {
                keyboard.next();
                error = true;
            }
        }
        while (error) {
            System.out.print("\uD83D\uDE14 Invalid input. Try again " + msg);
            if (keyboard.hasNextFloat()) {
                input = keyboard.nextFloat();
                error = input <= 0;
            } else {
                if (keyboard.hasNext())
                    keyboard.next();
                error = true;
            }
        }
        return input;
    }
}
