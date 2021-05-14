/**
 * Coin.java is an abstract class acts as a template for the Penny, Nickel, Dime, Quarter,
 * HalfDollar, and Dollar classes.
 * @version 05/12/2020
 * @author 22ridley
 */

public abstract class Coin {

    /**
     * Returns a double based on the coin's value
     * @return The coin's value as a double
     */
    public abstract double getValue();

    /**
     * Returns the name of the coin
     * @return The name of the coin as a String
     */
    public abstract String getName();
    // define in the class: pennies, dimes...

    /**
     * Returns the plural name of the coin
     * @return The pluarl name of the coin as a String
     */
    public String getPluralName() {
        return getName() + "s";
    }
}
