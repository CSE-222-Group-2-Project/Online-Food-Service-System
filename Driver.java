import src.demo.DemoAdmin;
import src.demo.DemoCustomer;
import src.restaurant.Restaurant;
import src.test.TestAdmin;
import src.test.TestCustomer;



public class Driver {

  
  /**
   * @param args
   */
  public static void main(String[] args) {
    /*Restaurant restaurant = new Restaurant();
    DemoAdmin.adminDemo(restaurant);
    */
    //testUsers();
    TestAdmin.testAdmin();
  }

  public static void testUsers() {
    //TestCustomer.testCustomer();

  }


  public static void testDemos() {
    DemoCustomer.demoCustomer();
  }

}
