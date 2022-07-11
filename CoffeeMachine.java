package machine;
import java.util.Scanner;
public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water = 400, milk = 540, beans = 120, glasses = 9, money = 550;
    Status status;
    static boolean stop = true;

    public enum Status {
        CHOOSING_ACTION,
        CHOOSING_COFFEE,
        ADDING_WATER,
        ADDING_MILK,
        ADDING_BEANS,
        ADDING_GLASSES,
        TAKING_MONEY,
        SYSTEM_STOP
    }

    public CoffeeMachine(int water, int milk, int beans, int glasses, int money){
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.glasses = glasses;
        this.money = money;
    }
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.ChooseAction();
    }


    public void ChooseAction(){
        this.status = Status.CHOOSING_ACTION;
        while(stop) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String act = scanner.next();
            if (act.equals("buy")) {
                this.BuyCoffee();
            } else if (act.equals("fill")) {
                this.fill();
            } else if (act.equals("take")) {
                this.takeMoney();
            } else if (act.equals("exit")) {
                this.exit();
            } else if (act.equals("remaining")) {
                remaining();
            }
        }

    }
    public void BuyCoffee() {
        this.status = Status.CHOOSING_COFFEE;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String num = scanner.next();
        switch (num) {
            case "1":
                if (250 <= water && 16 <= beans && 1 <= glasses) {
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    glasses -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (glasses < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                break;
            case "2":
                if (350 <= water && 20 <= beans && 1 <= glasses && 75 <= milk) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    glasses -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (glasses < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                }
                break;
            case "3":
                if (200 <= water && 12 <= beans && 1 <= glasses && 100 <= milk) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    glasses -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (glasses < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                }
                break;
            case "back":
                break;
            default:
                break;
        }
    }

    public void fill () {
        this.status = Status.ADDING_WATER;
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        this.water += addWater;
        this.status = Status.ADDING_MILK;
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        this.milk += addMilk;
        this.status = Status.ADDING_BEANS;
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addBeans = scanner.nextInt();
        this.beans += addBeans;
        this.status = Status.ADDING_GLASSES;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addGlasses = scanner.nextInt();
        this.glasses += addGlasses;
    }

    public void takeMoney() {
        this.status = Status.TAKING_MONEY;
        System.out.println("I gave you $" + this.money);
        this.money -= this.money;
    }

    public void exit() {
        this.status = Status.SYSTEM_STOP;
        stop = false;
    }
    public static void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(glasses + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}