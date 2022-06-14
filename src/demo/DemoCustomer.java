package src.demo;

import java.util.Scanner;
import src.auth.Authentication;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.user.Chef;
import src.user.Courier;
import src.user.Customer;

public class DemoCustomer {

  public static void demoCustomer() {
    Restaurant restaurant = new Restaurant();
    Customer customer = (Customer) Authentication.login();
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    CustomLinkedList<Food> foods = new CustomLinkedList<>();

    System.out.println("\nWelcome to the HoldON " + customer.getName() + " !");

    while (choice != 7) {
      printProgramMenu();
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          customer.seeMenu();
          break;
        case 2:
          giveAndTakeOrder(restaurant, customer);
          break;
        case 3:
          System.out.println(customer.orderHistory());
          break;
        case 4:
          System.out.println(customer);
          break;
        case 5:
          editProfile(customer);
          break;
        case 6:
          changePassword(customer);
          break;
        case 7:
          System.out.println("Thank you for using HoldON. Have a good day!");
          break;
        default:
          System.out.println("Please enter an integer between 1-7!");

      }
    }
    sc.close();
  }

  public static void printProgramMenu() {
    System.out.println("\nHere is what you can do: ");
    System.out.println("1: See the menu");
    System.out.println("2: Give an order");
    System.out.println("3: See your order history");
    System.out.println("4: Show profile info");
    System.out.println("5: Edit profile info");
    System.out.println("6: Change your password");
    System.out.println("7: Exit");
    System.out.println("\nPlease enter your choice: ");
  }

  public static void giveAndTakeOrder(Restaurant restaurant, Customer customer ){
    int chefScore = -1;
    int courierScore = -1;
    Scanner sc = new Scanner(System.in);
    Chef chef = restaurant.getTestChef();
    Courier courier = restaurant.getTestCourier();
  
    Order order = new Order(1, customer, getFoodsFromCustomer(), "AKSE");
    customer.giveOrder(restaurant, order);

    System.out.println("Order has been given. \n");
    chef.addOrder(order);
    chef.prepareOrder();
    System.out.println("Your order has been prepared.\n");

    courier.addOrder(order);
    System.out.println("Your order has been delivered to you. Enjoy!");
    courier.deliverOrderToCustomer();
    System.out.println("\nRate our chef and courier please!");
   
    System.out.print("What is your rate about our chef? (1-10): ");
    chefScore = sc.nextInt();
    System.out.print("What is your rate about our courier? (1-10) ");
    courierScore = sc.nextInt();
   
    System.out.print("Thank you! Have a good day.\n\n");
    customer.giveVote(chefScore, courierScore, order);
  }

  public static void editProfile(Customer customer) {

  }

  public static void changePassword(Customer customer) {

  }

  public static CustomLinkedList<Food> getFoodsFromCustomer() {
    CustomLinkedList<Food> foods = new CustomLinkedList<>();
    Menu menu = new Menu();
    System.out.println("Create order according to food ID's");
    System.out.println(
        "Enter the ID's of the foods you want to order (exp: 1 3 5 ): ");
    Scanner sc = new Scanner(System.in);
    String foodID = sc.nextLine();
    String[] foodIDs = foodID.split(" ");
    for (String id : foodIDs) {
      Food food = menu.getFood(Integer.parseInt(id));
      if (food != null) {
        foods.add(food);
      }
    }
    return foods;
  }
}
