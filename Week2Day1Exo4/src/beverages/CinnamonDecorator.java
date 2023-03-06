package beverages;

public class CinnamonDecorator implements Condiment {
    private final Beverage beverage;
    private final boolean hasCinnamon;

    public CinnamonDecorator(Beverage beverage, boolean hasCinnamon) {
        this.beverage = beverage;
        this.hasCinnamon = hasCinnamon;
    }

    @Override
    public double price() {
        if (hasCinnamon) {
            return beverage.price() + 0.05;
        } else {
            return beverage.price();
        }
    }
}