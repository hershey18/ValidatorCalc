package com.calebpower.demo.wow;

/**
 * A demonstration of a timer and the querying of a RESTful API through the use
 * of the Owen Wilson WOW API.
 * 
 * @author Caleb L. Power
 */
public class WOWDemo {
  
  /**
   * Entry point.
   * 
   * @param args command-line arguments
   */
  public static void main(String... args) {
    System.out.println("Welcome to the Owen Wilson WOW stream! ");
    System.out.println("You'll get new facts about a WOW every 15 seconds! WOW!");
    System.out.println("(This is a timer and API querying demo. Hit CTRL + C to exit.)");
    
    final QueryHandler queryHandler = new QueryHandler();
    final Timer timer = new Timer(15, queryHandler);
    timer.start();
    
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override public void run() {
        try {
          System.out.println("Shutting down...");
          timer.stop();
          Thread.sleep(1000);
        } catch(InterruptedException e) { } finally {
          System.out.println("Good bye!");
        }
      }
    });
  }
  
}
