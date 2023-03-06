
package beverages;

public class CoffeeWithMilk implements Beverage {
    private final Beverage beverage;
    private final boolean hasCinnamon;

    public CoffeeWithMilk(Beverage beverage, boolean hasCinnamon) {
        this.beverage = new CinnamonDecorator(new SimpleBeverage(beverage.price() + 0.10), hasCinnamon);
        this.hasCinnamon = hasCinnamon;
    }

    @Override
    public double price() {
        return beverage.price();
    }
}