package beverages;

public class TeaWithMilk implements Beverage {
    private final Beverage beverage;
    private final boolean hasCinnamon;

    public TeaWithMilk(Beverage beverage, boolean hasCinnamon) {
        this.beverage = new CinnamonDecorator(new SimpleBeverage(beverage.price() + 0.10), hasCinnamon);
        this.hasCinnamon = hasCinnamon;
    }

    @Override
    public double price() {
        return beverage.price();
    }
}