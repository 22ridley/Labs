/**
 * Penny.java is a subclass of Coin that stores a penny's value and name.
 * @version 05/12/2020
 * @author 22ridley
 */

public class Penny extends Coin{

    /**
     * Returns 0.01
     * @return The coin's value as a double
     */
    public double getValue(){
        return .01;
    }

    /**
     * Returns penny
     * @return The coin's name as a String
     */
    public String getName() {
        return "penny";
    }

    /**
     * Returns pennies
     * @return The coin's plural name as a String
     */
    public String getPluralName() {
        return "pennies";
    }
}
