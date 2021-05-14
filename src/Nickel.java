/**
 * Nickel.java is a subclass of Coin that stores a nickel's value and name.
 * @version 05/12/2020
 * @author 22ridley
 */
public class Nickel extends Coin{
    /**
     * Returns 0.05
     * @return The coin's value as a double
     */
    public double getValue(){
        return .05;
    }

    /**
     * Returns nickel
     * @return The coin's name as a string
     */
    public String getName() {
        return "nickel";
    }
}
