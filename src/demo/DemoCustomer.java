package src.demo;

import java.util.Scanner;
import src.auth.Authentication;
import src.user.Customer;

public class DemoCustomer {

  public static void demoCustomer() {
    Customer customer = (Customer) Authentication.login();
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("\nWelcome to the HoldON " + customer.getName() + " !");
    System.out.println("\nHere is what you can do: ");
    System.out.println("1. See the menu");
    System.out.println("2. Give an order");
    System.out.println("3. See your order history");
    System.out.println("4. Edit your profile");
    System.out.println("5. Logout");
    System.out.println("\nPlease enter your choice: ");
    choice = sc.nextInt();
  }
}
