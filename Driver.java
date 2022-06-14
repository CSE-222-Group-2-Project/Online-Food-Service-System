import src.demo.DemoCustomer;
import src.test.TestCustomer;



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
