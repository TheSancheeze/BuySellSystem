import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.LinkedList;

public class Ledger {
    private LinkedList<Integer> USDledger = new LinkedList<Integer>();
    private LinkedList<Double> BTCledger = new LinkedList<Double>();
    private LinkedList<String> DateLedger = new LinkedList<>();
    private int size = 0;

    public void addLedger(double BTC, int USD){
        LocalDateTime currDate = LocalDateTime.now();
        DateTimeFormatter currDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currDate.format(currDateFormat);
        
        this.USDledger.add(USD);
        this.BTCledger.add(BTC);
        this.DateLedger.add(formattedDate);
        this.size++;
    }

    public void printLedger(){
        for(int i=0; i<size; i++){
            System.out.println("\n"+DateLedger.get(i));
            System.out.println("USD: " + USDledger.get(i));
            System.out.println("BTC: " + BTCledger.get(i));
        }
    }
}
