import beverages.*;

public class Main {
    public static void main(String[] args) {

        // create a regular coffee with cinnamon
        Beverage coffeeWithCinnamon = new CinnamonDecorator(new Coffee(), true);
        System.out.println("Regular coffee with cinnamon: " + coffeeWithCinnamon.price() + "€");

        // create a regular hot chocolate without cinnamon
        Beverage hotChocolateWithoutCinnamon = new HotChocolate();
        System.out.println("Regular hot chocolate without cinnamon: " + hotChocolateWithoutCinnamon.price() + "€");

        // create a tea with milk and cinnamon
        Beverage teaWithMilkAndCinnamon = new TeaWithMilk(new Tea(), true);
        System.out.println("Tea with milk and cinnamon: " + teaWithMilkAndCinnamon.price() + "€");

        // create a coffee with milk and cream, with cinnamon
        Beverage coffeeWithMilkAndCreamAndCinnamon = new CoffeeWithMilkAndCream(new Coffee(), true);
        System.out.println("Coffee with milk and cream, with cinnamon: " + coffeeWithMilkAndCreamAndCinnamon.price() + "€");
    }
}
