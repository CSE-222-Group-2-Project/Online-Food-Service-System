import src.demo.DemoCustomer;
import src.test.TestCustomer;



public class Driver {

  public static void main(String[] args) {
    testDemos();
  }

  public static void testUsers() {
    Restaurant kebelekCafe = new Restaurant();
    TestCustomer.testCustomer(kebelekCafe);
  }

  public static void testDemos() {
    DemoCustomer.demoCustomer();
  }

}
