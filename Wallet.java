import java.util.Scanner;

public class Wallet {
    private int USD;
    private double BTC;

    public void setUSD(int USD){
        this.USD = USD;
    }

    public int getUSD(){
        return USD;
    }

    public void setBTC(double BTC){
        this.BTC = BTC;
    }

    public double getBTC(){
        return BTC;
    }

    public void buyBTC(int price){
        Scanner sc = new Scanner(System.in);

        System.out.println("Price of BTC is " + price);
        System.out.println("How much USD (" + this.USD + ") would you like to use?");
        int amount = sc.nextInt();
        
        if(amount > this.USD){
            System.out.println("\nNot enough USD.");
            return;
        }

        this.USD -= amount;
        double dAmount = amount;
        double dPrice = price;
        this.BTC += dAmount/dPrice;
        this.BTC = Math.round(this.BTC * 100.0) / 100.0;

        System.out.println("\nYou Now Own:");
        System.out.println("USD: " + this.getUSD());
        System.out.println("BTC: " + this.getBTC());
    }

    public void sellBTC(int price){
        Scanner sc = new Scanner(System.in);

        System.out.println("Price of BTC is " + price);
        System.out.println("How much BTC (" + this.BTC + ") would you like to sell?");
        double amount = sc.nextDouble();

        if(amount > this.BTC){
            System.out.println("\nNot enough BTC.");
            return;
        }

        this.USD += (int)(amount * price);
        this.BTC -= amount;

        System.out.println("\nYou Now Own:");
        System.out.println("USD: " + this.getUSD());
        System.out.println("BTC: " + this.getBTC());
    }
}
