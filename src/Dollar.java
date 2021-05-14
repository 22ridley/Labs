/**
 * Dollar.java is a subclass of Coin that stores a dollar's value and name.
 * @version 05/12/2020
 * @author 22ridley
 */
public class Dollar extends Coin{
    /**
     * Returns 1.0
     * @return The coin's value as a double
     */
    public double getValue(){
        return 1.0;
    }

    /**
     * Returns dollar
     * @return The coin's name as a string
     */
    public String getName() {
        return "dollar";
    }
}
