/**
 * Quarter.java is a subclass of Coin that stores a quarter's value and name.
 * @version 05/12/2020
 * @author 22ridley
 */
public class Quarter extends Coin{
    /**
     * Returns 0.25
     * @return The coin's value as a double
     */
    public double getValue(){
        return .25;
    }

    /**
     * Returns quarter
     * @return The coin's name as a string
     */
    public String getName() {
        return "quarter";
    }
}
