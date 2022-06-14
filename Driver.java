import java.util.Scanner;
import src.demo.DemoAdmin;
import src.demo.DemoChef;
import src.demo.DemoCourier;
import src.demo.DemoCustomer;
import src.test.TestAdmin;
import src.test.TestChef;
import src.test.TestCourier;
import src.test.TestCustomer;

public class Driver {


  public static void main(String[] args) {
    testUsers();
    testDemos();
  }

  public static void testUsers() {
    System.out.println("\n\n\nTHIS IS TEST PART\n");
    TestAdmin.testAdmin();
    TestChef.testChef();
    TestCourier.testCourier();
    TestCustomer.testCustomer();
  }

  public static void testDemos() {
    System.out.println("\n\n\nTHIS IS DEMO PART\n");
    int choice = -1;
    Scanner sc = new Scanner(System.in);
    while (choice != 5) {
      System.out.println("Which one are you going to login as?");
      System.out.println("1-> Admin ");
      System.out.println("2-> Chef ");
      System.out.println("3-> Courier");
      System.out.println("4-> Customer");
      System.out.println("5-> Exit");
      System.out.print("Enter your input: ");
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
