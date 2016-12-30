  // Source: http://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java-example-tutorial
  /*
  CREATING A CHAIN
  This is a very important step and we should create the chain
  carefully, otherwise a processor might not be getting any
  request at all. For example, in our implementation if we
  keep the first processor chain as Dollar10Dispenser and
  then Dollar20Dispenser, then the request will never be
  forwarded to the second processor and the chain will
  become useless.
  */
  import java.util.Scanner;

  public class ATMDispenseChain {

      private DispenseChain c1;

      public ATMDispenseChain() {
          // initialize the chain
          this.c1 = new Dollar50Dispenser();
          DispenseChain c2 = new Dollar20Dispenser();
          DispenseChain c3 = new Dollar10Dispenser();

          // set the chain of responsibility
          c1.setNextChain(c2);
          c2.setNextChain(c3);
      }

      public static void main(String[] args) {
          ATMDispenseChain atmDispenser = new ATMDispenseChain();
          while (true) {
              int amount = 0;
              System.out.println("Enter amount to dispense");
              Scanner input = new Scanner(System.in);
              amount = input.nextInt();
              if (amount % 10 != 0) {
                  System.out.println("Amount should be in multiple of 10s.");
                  return;
              }
              // process the request
              atmDispenser.c1.dispense(new Currency(amount));
          }
      }
}