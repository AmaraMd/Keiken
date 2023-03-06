package beverages;

public class CoffeeWithMilkAndCream implements Beverage {
    private final Beverage beverage;
    private final boolean hasCinnamon;

    public CoffeeWithMilkAndCream(Beverage beverage, boolean hasCinnamon) {
        this.beverage = new CinnamonDecorator(new SimpleBeverage(beverage.price() + 0.25), hasCinnamon);
        this.hasCinnamon = hasCinnamon;
    }

    @Override
    public double price() {
        return beverage.price();
    }
}