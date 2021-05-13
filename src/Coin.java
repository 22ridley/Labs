public abstract class Coin {
    // returns .01, .05, ..., .5, 1.0 based on
    // implementing class object's value
    public abstract double getValue();
    // returns "penny", "nickel", ...,
    // "half dollar", "dollar"
    public abstract String getName();
    // define in the class: pennies, dimes...
    public String getPluralName() {
        return getName() + "s";
    }
}
