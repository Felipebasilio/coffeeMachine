package machine;
import java.util.Scanner;  // Import the Scanner class
class Coffee {
    enum CoffeeType {
        expresso, latte, cappuccino
    }
    protected CoffeeType type;
    protected int price;
    protected int waterQtd;
    protected int beansQtd;
    protected int milkQtd;

    protected boolean setCoffeeType(CoffeeType coffeeType) {
        this.type = coffeeType;

        if (coffeeType == CoffeeType.expresso) {
            this.waterQtd = 250;
            this.beansQtd = 16;
            this.milkQtd = 0;
            this.price = 4;
        } else if (coffeeType == CoffeeType.latte) {
            this.waterQtd = 350;
            this.beansQtd = 20;
            this.milkQtd = 75;
            this.price = 7;
        } else if (coffeeType == CoffeeType.cappuccino) {
            this.waterQtd = 200;
            this.beansQtd = 12;
            this.milkQtd = 100;
            this.price = 6;
        } else {
            return false;
        }

        return true;
    }

}
public class CoffeeMachine {
    public State currentState = State.init;
    static enum State {
        buy, fill, take, remaining, init
    }



    public static void main(String[] args) {
        Integer avlWater = 400;
        Integer avlMilk = 540;
        Integer avlBeans = 120;
        Integer avlCups = 9;
        Integer avlMoney = 550;
        Boolean hittedBackButton = false;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String desiredOperation = scanner.nextLine();

        while (!desiredOperation.equals("exit")) {
            hittedBackButton = false;

            switch (desiredOperation) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String desiredCoffeeType = scanner.nextLine();
                    Coffee requestedCoffee = new Coffee();

                    switch (desiredCoffeeType) {
                        case "1":
                            requestedCoffee.setCoffeeType(Coffee.CoffeeType.expresso);
                            break;
                        case "2":
                            requestedCoffee.setCoffeeType(Coffee.CoffeeType.latte);
                            break;
                        case "3":
                            requestedCoffee.setCoffeeType(Coffee.CoffeeType.cappuccino);
                            break;
                        case "back":
                            hittedBackButton = true;
                            break;
                    };

                    if (hittedBackButton == false) {
                        avlWater -= requestedCoffee.waterQtd;
                        avlBeans -= requestedCoffee.beansQtd;
                        avlMilk -= requestedCoffee.milkQtd;

                        if (avlWater < 0) {
                            System.out.println("Sorry, not enough water!\n");
                            hittedBackButton = true;

                        } else if (avlBeans < 0) {
                            System.out.println("Sorry, not enough coffee beans!");
                            hittedBackButton = true;
                        } else if (avlMilk < 0) {
                            System.out.println("Sorry, not enough milk!");
                            hittedBackButton = true;
                        } else {
                            System.out.println("I have enough resources, making you a coffee!");
                        }
                    }

                    if (hittedBackButton) {
                        avlWater += requestedCoffee.waterQtd;
                        avlBeans += requestedCoffee.beansQtd;
                        avlMilk += requestedCoffee.milkQtd;
                    }

                    if (!hittedBackButton) {
                        avlCups -= 1;
                        avlMoney += requestedCoffee.price;
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water you want to add: ");
                    Integer providedWater = scanner.nextInt();
                    avlWater += providedWater;
                    System.out.println("Write how many ml of milk you want to add: ");
                    Integer providedMilk = scanner.nextInt();
                    avlMilk += providedMilk;
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    Integer providedBeans = scanner.nextInt();
                    avlBeans += providedBeans;
                    System.out.println("Write how many disposable cups you want to add:");
                    Integer providedCups = scanner.nextInt();
                    avlCups += providedCups;

                    break;
                case "take":
                    System.out.println("I gave you $" + avlMoney);
                    avlMoney = 0;

                    break;
                case "remaining":
                    System.out.println("The coffee machine has:\n" +
                            avlWater + " ml of water\n" +
                            avlMilk + " ml of milk\n" +
                            avlBeans + " g of coffee beans\n" +
                            avlCups + " disposable cups\n" +
                            "$" + avlMoney + " of money");
                    break;
                default: break;
            };

            desiredOperation = scanner.nextLine();

        };
    }
}

