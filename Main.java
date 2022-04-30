import java.util.Scanner;

class Main{
    public static void main(String[] args) {

        Wallet wallet = new Wallet();
        Ledger ledger = new Ledger();

        wallet.setBTC(0);
        wallet.setUSD(75000);
        ledger.addLedger(wallet.getBTC(), wallet.getUSD());

        int price = newPrice();
        int choice = options();
        String x = "*";

        while(choice != 6){
            switch (choice){
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    price = newPrice();
                    System.out.println(x.repeat(10) + "\n");
                    System.out.println("BTC price: " + price);
                    System.out.println("\n" + x.repeat(10));
                    break;
                case 2: 
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(x.repeat(10) + "\n");
                    System.out.println("You Own:");
                    System.out.println("USD: " + wallet.getUSD());
                    System.out.println("BTC: " + wallet.getBTC());
                    System.out.println("\n" + x.repeat(10));
                    break;
                case 3: 
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(x.repeat(10) + "\n");
                    wallet.buyBTC(price);
                    ledger.addLedger(wallet.getBTC(), wallet.getUSD());
                    System.out.println("\n" + x.repeat(10));
                    break;
                case 4: 
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(x.repeat(10) + "\n");
                    wallet.sellBTC(price);
                    ledger.addLedger(wallet.getBTC(), wallet.getUSD());
                    System.out.println("\n" + x.repeat(10));
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(x.repeat(10) + "\n");
                    ledger.printLedger();
                    System.out.println("\n" + x.repeat(10));
                    break;
            }

            choice = options();
        }

        System.out.println("\nThank you for using my program!");
    }

    public static int options(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n1. Check price");
        System.out.println("2. Check wallet");
        System.out.println("3. Buy");
        System.out.println("4. Sell");
        System.out.println("5. History");
        System.out.println("6. Exit");
        System.out.println("\nEnter a number from the menu to select that option:");

        return sc.nextInt();
    }

    public static int newPrice(){
        return (int)(Math.random() * (65000 - 50000 + 1) + 50000);
    }
}