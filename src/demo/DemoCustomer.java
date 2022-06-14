package src.demo;

import src.auth.Authentication;
import src.user.Customer;

public class DemoCustomer {

  public static void demoCustomer() {
    Customer customer = (Customer) Authentication.login();
  }
}
