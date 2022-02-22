import java.util.Scanner;

public class Inventory {


    private float ICE_ML;
    private float MILK_ML;
    private float SUGAR_G;

    private float STRAWBERRY_G;
    private float BANANA_G;
    private float MANGO_G;

    Inventory(){
        this.setInventory();
    }

    /**
     * Get Attributes of Inventory
     *
     * @return
     */
    public float getICE_ML() {
        return ICE_ML;
    }

    public float getMILK_ML() {
        return MILK_ML;
    }

    public float getSUGAR_G() {
        return SUGAR_G;
    }

    public float getSTRAWBERRY_G() {
        return STRAWBERRY_G;
    }

    public float getBANANA_G() {
        return BANANA_G;
    }

    public float getMANGO_G() {
        return MANGO_G;
    }

    /**
     * Set attributes of Inventory
     */
    public void setICE_ML() {
        this.ICE_ML = this.setIngredient("Cantidad de Hielo [ml]: ");
    }

    public void setMILK_ML() {
        this.MILK_ML = this.setIngredient("Cantidad de Leche Condesada [ml]: ");
    }

    public void setSUGAR_G() {
        this.SUGAR_G = this.setIngredient("Cantidad de Azúcar [g]: ");
    }

    public void setSTRAWBERRY_G() {
        this.STRAWBERRY_G = this.setIngredient("Cantidad de strawberries [g]: ");
    }

    public void setBANANA_G() {
        this.BANANA_G = this.setIngredient("Cantidad de bananas [g]: ");
    }

    public void setMANGO_G() {
        this.MANGO_G = this.setIngredient("Cantidad de mango [g]: ");
    }


    /**
     * Initial function to collect all inventory values
     */
    private void setInventory() {
        System.out.println("Por favor ingresa tu inventario actual");
        setICE_ML();
        setMILK_ML();
        setSUGAR_G();
        setSTRAWBERRY_G();
        setBANANA_G();
        setMANGO_G();
    }

    /**
     * Function to input and set vars in class from keyboard
     * @param msg
     * @return
     */
    private float setIngredient(String msg) {
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
            System.out.print("\uD83D\uDE14 Invalid input. " + msg);
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
