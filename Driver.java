import java.util.Scanner;

import src.demo.DemoAdmin;
import src.demo.DemoChef;
import src.demo.DemoCourier;
import src.demo.DemoCustomer;
import src.restaurant.Restaurant;
import src.test.TestCustomer;

public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    /*
     * Restaurant restaurant = new Restaurant();
     * DemoAdmin.adminDemo(restaurant);
     */
    testDemos();
  }

  public static void testUsers() {
    // TestCustomer.testCustomer();

  }

  public static void testDemos() {
    System.out.println("\n\n\nTHIS IS DEMO PART\n");
    int choice = -1;
    Scanner sc = new Scanner(System.in);
    while (choice != 5) {
      System.out.println("1-> Admin ");
      System.out.println("2-> Chef ");
      System.out.println("3-> Courier");
      System.out.println("4-> Customer");
      System.out.println("5-> Exit");
      System.out.println("Enter your input: ");
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          DemoAdmin.demoAdmin();
          break;
        case 2:
          DemoChef.demoChef();
          break;
        case 3:
          DemoCourier.demoCourier();
          break;
        case 4:
          DemoCustomer.demoCustomer();
          break;
        case 5:
          System.out.println("Thank you for using HoldON!");
          break;
        default:
      }

    }
  }

}
