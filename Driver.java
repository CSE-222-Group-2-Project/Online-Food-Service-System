import src.demo.DemoAdmin;
import src.demo.DemoCourier;
import src.demo.DemoCustomer;
import src.restaurant.Restaurant;
import src.test.TestCustomer;
import src.restaurant.*;

public class Driver {

  
  /** 
   * @param args
   */
  public static void main(String[] args) {
    testUsers();
    /*Restaurant restaurant = new Restaurant();
    DemoAdmin.adminDemo(restaurant);
    */
    //testDemos();
    
  }

  public static void testUsers() {
    TestCustomer.testCustomer();
  }

  public static void testDemos() {
   DemoCourier.demoCourier();

  }

}
