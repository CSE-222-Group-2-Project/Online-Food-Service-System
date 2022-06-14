import java.util.ArrayList;
import src.demo.DemoCustomer;
import src.restaurant.Restaurant;


import src.restaurant.Restaurant;

public class Driver {

  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    ArrayList<Integer> route = restaurant
      .getTestCourier()
      .showShortestRoute("CUMHURIYET");
    for (int parent : route) {
      System.out.println(parent);
    }
  }

  public static void testUsers() {}

  public static void testDemos() {
    DemoCustomer.demoCustomer();
  }

}
