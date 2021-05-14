/**
 * HalfDollar.java is a subclass of Coin that stores a half dollar's value and name.
 * @version 05/12/2020
 * @author 22ridley
 */
public class HalfDollar extends Coin{
    /**
     * Returns 0.5
     * @return The coin's value as a double
     */
    public double getValue(){
        return .5;
    }

    /**
     * Returns half dollar
     * @return The coin's name as a string
     */
    public String getName() {
        return "half dollar";
    }
}
