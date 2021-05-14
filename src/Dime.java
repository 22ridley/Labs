/**
 * Dime.java is a subclass of Coin that stores a dime's value and name.
 * @version 05/12/2020
 * @author 22ridley
 */
public class Dime extends Coin{
    /**
     * Returns 0.1
     * @return The coin's value as a double
     */
    public double getValue(){
        return .1;
    }

    /**
     * Returns dime
     * @return The coin's name as a string
     */
    public String getName() {
        return "dime";
    }
}
