// Source: http://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java-example-tutorial
/*
 The important point to note here is the implementation
 of dispense method, you will notice that every implementation
 is trying to process the request and based on the amount,
 it might process some or full part of it. If it’s
 not able to process it fully, it sends the request
 to the next processor in chain to process the remaining
 request. If the processor is not able to process anything,
 it just forwards the same request to the next chain.
*/
public class Dollar10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 10){
            int num = cur.getAmount()/10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing "+num+" 10$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }
        else
            this.chain.dispense(cur);
    }

}