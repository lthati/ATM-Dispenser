// Source: http://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java-example-tutorial
/**
   This class will store the amount to dispense and used by the chain
   implementations
 */
 public class Currency {

    private int amount;

    public Currency(int amt){
        this.amount = amt;
    }

    public int getAmount(){
        return this.amount;
    }
}