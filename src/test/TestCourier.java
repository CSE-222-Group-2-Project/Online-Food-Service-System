package src.test;

import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.user.Courier;
import src.user.Customer;
import src.user.Worker;

public class TestCourier {
	
  /** 
   * @param kebelekCafe
   */
  public static void testCourier(Restaurant kebelekCafe) {
    Courier courier1 = new Courier(
      "Tolstoy",
      50,
      "tlsty",
      "5652",
      "+905055332577",	// phoneNumber
      11    // experienceYear
    );

    Courier courier2 = new Courier(
      "Gogol",
      45,
      "mhmt1",
      "4565",
      "+905055932576",	// phoneNumber
      17    // experienceYear
    );

    // kebelekCafe objesi gorulebiliyor mu
    CustomLinkedList<Food> foods = kebelekCafe.createRandomFoods();

    System.out.println("TESTING COURIER METHODS...");
    System.out.println("\n\n");

    System.out.println("TESTING SET PHONE NUMBER METHOD OF COURIER CLASS...");
    courier1.setPhoneNumber("+905155942876");
    System.out.println("\n\n");

    System.out.println("TESTING GET PHONE NUMBER METHOD OF COURIER CLASS...");
    courier1.getPhoneNumber();
    System.out.println("\n\n");

    System.out.println("TESTING GET SIZE OF ORDERS METHOD OF COURIER CLASS...");
    courier1.getSizeOfOrders();
    System.out.println("\n\n");

    System.out.println("TESTING ADD ORDER METHOD OF COURIER CLASS...");
    courier1.addOrder(new Order(1, kebelekCafe.getTestCustomer(), foods, "dest1"));
    System.out.println("\n\n");

    System.out.println("TESTING DELIVER ORDER TO CUSTOMER METHOD OF COURIER CLASS...");
    courier1.deliverOrderToCustomer();
    System.out.println("\n\n");

    System.out.println("TESTING FIND VALUE OF DISTRICT METHOD OF COURIER CLASS");
// !!!    courier1.findValueOfDistrict();
    System.out.println("\n\n");

    System.out.println("TESTING SHOW SHORTEST ROUTE METHOD OF COURIER CLASS");
// !!!    courier1.showShortestRoute();
    System.out.println("\n\n");

    System.out.println("TESTING COMPARE TO METHOD...");
    courier1.compareTo(courier2);
    System.out.println("\n\n");

    System.out.println("TESTING GET SHORTEST ROUTE METHOD OF COURIER CLASS");
// !!!    courier1.getShortestRoute();
    System.out.println("\n\n");

    System.out.println("TESTING TO STRING METHOD OF COURIER CLASS...");
    System.out.println(courier1.toString());
  }
}

