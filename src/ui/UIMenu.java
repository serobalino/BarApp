package ui;

import model.Fruit;
import model.Inventory;
import model.Recipe;
import model.Size;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {


    public static void showTitle(){
        System.out.println("\n************\uD83C\uDF78 Bar Recipes \uD83C\uDF78************");
    }

    public static void showMainMenu(ArrayList<Inventory> ingredients, ArrayList<Fruit> fruits, ArrayList<Recipe> recipes, ArrayList<Size> sizes){
        showTitle();
        int response = 0;
        do {
            System.out.println("Main Menu\n");
            System.out.println("1. Show Inventory");
            System.out.println("2. Set Inventory");
            System.out.println("3. Sell a drink");
            System.out.println("0. Exit");

            response = getMenuValue("Press the menu option number on the keyboard followed by the enter key: ");

            switch (response){
                case 1:
                    response = 0;
                    UIIngredients.showInventory(ingredients,fruits,recipes,sizes);
                    break;
                case 2:
                    response = 0;
                    UIIngredients.setIngredients(ingredients,fruits,recipes,sizes);
                    break;
                case 3:
                    response = 0;
                    UIIngredients.showFlavorsMenu(ingredients,fruits,recipes,sizes);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;

                default:
                    System.out.println("❌ Please select a correct answer");
                    showMainMenu(ingredients, fruits, recipes, sizes);
                    break;
            }
        } while (response != 0);
    }

    public static int getMenuValue(String msg) {
        System.out.print("\n> " + msg);
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        boolean error = false;
        if (keyboard.hasNext()) {
            if (keyboard.hasNextInt()) {
                input = keyboard.nextInt();
                error = input < 0;
            } else {
                keyboard.next();
                error = true;
            }
        }
        while (error) {
            System.out.print("\uD83D\uDE14 Invalid option. Try again " + msg);
            if (keyboard.hasNextInt()) {
                input = keyboard.nextInt();
                error = input < 0;
            } else {
                if (keyboard.hasNext())
                    keyboard.next();
                error = true;
            }
        }
        return input;
    }
}
