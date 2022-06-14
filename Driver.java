import src.auth.Authentication;
import src.restaurant.Restaurant;
import src.user.Chef;
import src.user.Courier;
import src.user.User;
import src.demo.DemoCustomer;

import java.util.ArrayList;

public class Driver {

  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    ArrayList<Integer> route = restaurant.getTestCourier().showShortestRoute("CUMHURIYET");
    for (int parent: route) {
      System.out.println(parent);

    testDemos();
  }

  public static void testUsers() {}

  public static void testDemos() {
    DemoCustomer.demoCustomer();
  }
}
