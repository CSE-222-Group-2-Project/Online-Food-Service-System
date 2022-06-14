import src.auth.Authentication;
import src.restaurant.Restaurant;
import src.user.Chef;
import src.user.Courier;
import src.user.User;

import java.util.ArrayList;

public class Driver {

  public static void main(String[] args) {


    //User user = Authentication.login();
    Restaurant restaurant = new Restaurant();
    ArrayList<Integer> route = restaurant.getTestCourier().showShortestRoute("CUMHURIYET");
    for (int parent: route) {
      System.out.println(parent);
    }
  }
}
