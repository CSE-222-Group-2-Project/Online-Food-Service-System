package src.test;

import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.user.Chef;
import src.user.Customer;
import src.user.User;
import src.user.Worker;

public class TestChef {
	
  /** 
   * @param kebelekCafe
   */
  public static void testChef(Restaurant kebelekCafe) {
    Chef chef1 = new Chef(
      "Somer Chef",
      50,
      "smr1234",
      "1335",
      5,	// certificateNumber
      15    // experienceYear
    );

    Chef chef2 = new Chef(
      "Mehmet Chef",
      45,
      "mhmt1",
      "4565",
      6,	// certificateNumber
      12    // experienceYear
    );

    // kebelekCafe objesi gorulebiliyor mu
    CustomLinkedList<Food> foods = kebelekCafe.createRandomFoods();

    System.out.println("TESTING CHEF METHODS...");
    System.out.println("\n\n");

    System.out.println("TESTING ADD ORDER METHOD OF CHEF CLASS...");
    // !!! owner of the order should be change according to customer name


    chef1.addOrder(new Order(1, kebelekCafe.getTestCustomer() , foods, "CUMHURIYET"));
    System.out.println("\n\n");

    System.out.println("TESTING PREPARE ORDER METHOD OF CHEF CLASS...");
    chef1.prepareOrder();
    System.out.println("\n\n");

    System.out.println("TESTING GET CERTIFICATE NUMBER METHOD OF CHEF CLASS...");
    chef1.getCertificateNumber();
    System.out.println("\n\n");

    System.out.println("TESTING INCREMENT CERTIFICATE NUMBER METHOD OF CHEF CLASS...");
    chef1.incrementCertificateNumber();
    System.out.println("\n\n");

    System.out.println("TESTING CALCULATE STATUS METHOD OF CHEF CLASS");
    chef1.calculateStatus();
    System.out.println("\n\n");

    System.out.println("TESTING GET SIZE OF ORDERS METHOD OF CHEF CLASS...");
    chef1.getSizeOfOrders();
    System.out.println("\n\n");

    System.out.println("TESTING COMPARE TO METHOD...");
    chef1.compareTo(chef2);
    System.out.println("\n\n");

    System.out.println("TESTING TO STRING METHOD OF CHEF CLASS...");
    System.out.println(chef1.toString());
  }
}

