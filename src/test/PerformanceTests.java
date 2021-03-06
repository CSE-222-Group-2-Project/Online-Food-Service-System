package src.test;

import java.util.ArrayList;
import java.util.Iterator;
import src.auth.Authentication;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.Food;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.user.Chef;
import src.user.Courier;
import src.user.Customer;
import src.user.User;

public class PerformanceTests {


  /*
   * The testFor10Inputs() method tests createUser(), 
   * giveOrder(), addOder(), prepareOrder() and 
   * deliverOrderToCustomer() methods
   * for 10 inputs 
   * 
   */
  public static void testFor10Inputs() {
    Restaurant kebelekCafe = new Restaurant();

    Iterator<Customer> customerIterator = kebelekCafe.getCustomers().iterator();
    Customer customer = customerIterator.next();

    Chef chef = kebelekCafe.getTestChef();
    Courier courier = kebelekCafe.getTestCourier();
    Authentication auth = new Authentication();
    ArrayList<Order> orders = new ArrayList<Order>();
    long startTime, endTime, totalTime;
    for (int i = 0; i < 10; i++) {
      CustomLinkedList<Food> foods = kebelekCafe.createRandomFoods();
      Order order = new Order(i, customer, foods, "test");
      orders.add(order);
    }
    System.out.println("\nTESTING MAIN DATA STRUCTURE METHODS FOR 10 INPUTS");

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      auth.createUser(new User("test", 10, "a" + i + ".th", "pass"));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "BST createUser() Method For 10 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      customer.giveOrder(kebelekCafe, orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Customer giveOrder() Method For 10 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      chef.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef addOrder() Method For 10 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      chef.prepareOrder();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef prepareOrder() Method For 10 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      courier.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier addOrder() Method For 10 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      courier.deliverOrderToCustomer();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier deliverOrderToCustomer() Method For 10 Inputs Time: " + totalTime
    );
  }

  /*
   * The testFor10Inputs() method tests createUser(), 
   * giveOrder(), addOder(), prepareOrder() and 
   * deliverOrderToCustomer() methods
   * for 100 inputs 
   * 
   */
  public static void testFor100Inputs() {
    Restaurant kebelekCafe = new Restaurant();

    Iterator<Customer> customerIterator = kebelekCafe.getCustomers().iterator();
    Customer customer = customerIterator.next();

    Chef chef = kebelekCafe.getTestChef();
    Courier courier = kebelekCafe.getTestCourier();
    Authentication auth = new Authentication();
    ArrayList<Order> orders = new ArrayList<Order>();
    long startTime, endTime, totalTime;
    for (int i = 0; i < 100; i++) {
      CustomLinkedList<Food> foods = kebelekCafe.createRandomFoods();
      Order order = new Order(i, customer, foods, "test");
      orders.add(order);
    }

    System.out.println("\nTESTING MAIN DATA STRUCTURE METHODS FOR 100 INPUTS");

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      auth.createUser(new User("test", 10, "b" + i + ".th", "pass"));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "BST createUser() Method For 100 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      customer.giveOrder(kebelekCafe, orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Customer giveOrder() Method For 100 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      chef.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef addOrder() Method For 100 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      chef.prepareOrder();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef prepareOrder() Method For 100 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      courier.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier addOrder() Method For 100 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      courier.deliverOrderToCustomer();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier deliverOrderToCustomer() Method For 100 Inputs Time: " +
      totalTime
    );
  }


  /*
   * The testFor10Inputs() method tests createUser(), 
   * giveOrder(), addOder(), prepareOrder() and 
   * deliverOrderToCustomer() methods
   * for 1000 inputs 
   * 
   */
  public static void testFor1000Inputs() {
    Restaurant kebelekCafe = new Restaurant();

    Iterator<Customer> customerIterator = kebelekCafe.getCustomers().iterator();
    Customer customer = customerIterator.next();

    Chef chef = kebelekCafe.getTestChef();
    Courier courier = kebelekCafe.getTestCourier();
    Authentication auth = new Authentication();
    ArrayList<Order> orders = new ArrayList<Order>();
    long startTime, endTime, totalTime;
    for (int i = 0; i < 1000; i++) {
      CustomLinkedList<Food> foods = kebelekCafe.createRandomFoods();
      Order order = new Order(i, customer, foods, "test");
      orders.add(order);
    }

    System.out.println("\nTESTING MAIN DATA STRUCTURE METHODS FOR 1000 INPUTS");

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      auth.createUser(new User("test", 10, "c" + i + ".th", "pass"));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "BST createUser() Method For 1000 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      customer.giveOrder(kebelekCafe, orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Customer giveOrder() Method For 1000 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      chef.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef addOrder() Method For 1000 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      chef.prepareOrder();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef prepareOrder() Method For 1000 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      courier.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier addOrder() Method For 1000 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      courier.deliverOrderToCustomer();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier deliverOrderToCustomer() Method For 1000 Inputs Time: " +
      totalTime
    );
  }
}
