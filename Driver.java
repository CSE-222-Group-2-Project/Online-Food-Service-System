import src.demo.DemoCustomer;
import src.restaurant.Restaurant;
import src.test.TestCustomer;
import src.restaurant.*;

public class Driver {

  public static void main(String[] args) {
    testUsers();
  }

  public static void testUsers() {
    TestCustomer.testCustomer();
  }

  public static void testDemos() {
    DemoCustomer.demoCustomer();
  }

}
