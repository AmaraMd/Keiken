package beverages;

public class SimpleBeverage implements Beverage {
    private final double basePrice;

    public SimpleBeverage(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double price() {
        return basePrice;
    }
}