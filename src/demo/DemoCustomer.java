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
    if (customer == null) {
      System.out.println();
      return;
    }
    int choice = 0;
    Scanner sc = new Scanner(System.in);

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
          updateProfile(customer);
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
  }

  public static void printProgramMenu() {
    System.out.println("\nHere is what you can do: ");
    System.out.println("1-> See the menu");
    System.out.println("2-> Give an order");
    System.out.println("3-> See your order history");
    System.out.println("4-> Show profile info");
    System.out.println("5-> Update profile info");
    System.out.println("6-> Change your password");
    System.out.println("7-> Logout");
    System.out.print("\nPlease enter your choice: ");
  }

  public static void giveAndTakeOrder(
    Restaurant restaurant,
    Customer customer
  ) {
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

  public static void updateProfile(Customer customer) {
    int choice = -1;
    Scanner sc = new Scanner(System.in);
    System.out.println("What do you want to update:");
    System.out.println("1-> USERNAME");
    System.out.println("2-> JOB");
    System.out.println("3-> PHONE NUMBER");
    System.out.println("4-> BUDGET");
    System.out.println("5-> ADD NEW ALLGERGY");
    System.out.print("Enter your choice: ");
    choice = sc.nextInt();

    switch (choice) {
      case 1:
        updateCustomerUsername(customer);
        break;
      case 2:
        updateCustomerJob(customer);
        break;
      case 3:
        updateCustomerPhoneNumber(customer);
        break;
      case 4:
        updateCustomerBudget(customer);
        break;
      case 5:
        addNewAllergy(customer);
        break;
      default:
        System.out.println(
          "Invalid input. You should have entered an integer between 1-4!"
        );
    }
  }

  public static void updateCustomerUsername(Customer customer) {
    String newUsername = "";
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your new username please: ");
    newUsername = sc.next();
    customer.setUsername(newUsername);
    System.out.println("Your username has been updated!\n");
  }

  public static void updateCustomerJob(Customer customer) {
    String newJob = "";
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your new job please: ");
    newJob = sc.nextLine();
    customer.setJob(newJob);
    System.out.println("Your job has been updated!\n");
  }

  public static void updateCustomerPhoneNumber(Customer customer) {
    String newNumber = "";
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your new phone number please: ");
    newNumber = sc.next();
    customer.setPhoneNumber(newNumber);
    System.out.println("Your phone number has been updated!\n");
  }

  public static void updateCustomerBudget(Customer customer) {
    Double newBudget;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your new budget please: ");
    newBudget = sc.nextDouble();
    customer.setBudget(newBudget);
    System.out.println("Your budget has been updated!\n");
  }

  public static void addNewAllergy(Customer customer) {
    String newAllergy = "";
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your allergy please: ");
    newAllergy = sc.next();
    customer.addAllergy(newAllergy);
    System.out.println("Your allergy has been added!\n");
  }

  public static void changePassword(Customer customer) {
    String newPassword = "";
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your new password please: ");
    newPassword = sc.next();
    customer.setPassword(newPassword);
    System.out.println("Your password has been updated!\n");
  }

  public static CustomLinkedList<Food> getFoodsFromCustomer() {
    CustomLinkedList<Food> foods = new CustomLinkedList<>();
    Menu menu = new Menu();
    System.out.println("Create order according to food ID's");
    System.out.println(
      "Enter the ID's of the foods you want to order (exp: 1 3 5 ): "
    );
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
