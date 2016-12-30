/**
  This interface has a method to define the next processor in the 
  chain and the method that will process the request.   In our case,
  dispense() processes the request
 */
  
public interface DispenseChain {
 
    void setNextChain(DispenseChain nextChain);
     
    void dispense(Currency cur);
}