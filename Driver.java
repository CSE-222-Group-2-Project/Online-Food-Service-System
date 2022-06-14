import src.demo.DemoAdmin;
import src.demo.DemoCourier;
import src.demo.DemoCustomer;
import src.restaurant.Restaurant;
import src.test.TestAdmin;
import src.test.TestChef;
import src.test.TestCourier;
import src.test.TestCustomer;



public class Driver {

  
  /** 
   * @param args
   */
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    /*DemoAdmin.adminDemo(restaurant);
    */
    //testDemos();
    TestChef.testChef(restaurant);
    //TestAdmin.testAdmin(restaurant);
    //TestCourier.testCourier(restaurant);
  }

  public static void testUsers() {
    //TestCustomer.testCustomer();

  }

  public static void testDemos() {
   DemoCourier.demoCourier();

  }

}
