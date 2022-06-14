import java.util.ArrayList;
import src.demo.DemoCustomer;
import src.restaurant.Restaurant;
import src.test.TestCustomer;


import src.restaurant.Restaurant;

public class Driver {

  public static void main(String[] args) {
    testUsers();
  }

  public static void testUsers() {
    Restaurant kebelekCafe = new Restaurant();
    TestCustomer.testCustomer(kebelekCafe);
  }

  public static void testDemos() {
    DemoCustomer.demoCustomer();
  }

}
