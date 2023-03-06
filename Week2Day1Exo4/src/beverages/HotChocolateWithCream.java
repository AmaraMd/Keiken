package beverages;

public class HotChocolateWithCream implements Beverage {
    private final Beverage beverage;
    private final boolean hasCinnamon;

    public HotChocolateWithCream(Beverage beverage, boolean hasCinnamon) {
        this.beverage = new CinnamonDecorator(new SimpleBeverage(beverage.price() + 0.15), hasCinnamon);
        this.hasCinnamon = hasCinnamon;
    }

    @Override
    public double price() {
        return beverage.price();
    }
}