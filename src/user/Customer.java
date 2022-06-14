package src.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.datastructures.tree.AVLTree;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;

/**
 * Customer class is a user type that expresses the target audience of the
 * restaurant derived from the user class.
 * @author Group 2
 * @version 1.0.0
 * @since 08.04.2022
 */

/* Customer class is a user type that expresses the target audience of the
 restaurant derived from the user class.*/
public class Customer extends User {

  // Data Fields
  private String customerJob;
  private String phoneNumber;
  private double budget;
  private int orderNumber = 0;
  private CustomLinkedList<Order> myOrders = new CustomLinkedList<>();
  private ArrayList<String> allergies = new ArrayList<>();

  // Constructors
  /**
   * Constructor of the Customer class
   * @param name the name of the customer
   * @param age the age of the customer
   * @param customerJob the job of the customer
   * @param username the username of the customer
   * @param password the password of the customer
   * @param phoneNumber the phone number of the customer
   * @param budget the budget of the customer
   * @param allergies the allergies of the customer
   */
  public Customer(
    String name,
    int age,
    String customerJob,
    String username,
    String password,
    String phoneNumber,
    double budget,
    ArrayList<String> allergies
  ) {
    super(name, age, username, password);
    this.customerJob = customerJob;
    this.phoneNumber = phoneNumber;
    this.budget = budget;
    this.allergies = allergies;
  }

  /**
   * This function returns the job of the customer
   *
   * @return The job of the customer is being returned.
   */
  public String getJob() {
    return customerJob;
  }

  /**
   * This function returns the phone number of the customer
   *
   * @return The phone number of the customer.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * This function returns the budget of the customer
   *
   * @return The budget of the customer.
   */
  public double getBudget() {
    return budget;
  }

  /**
   * It returns the number of order of the customer.
   *
   * @return The number of order of the customer.
   */
  public int getOrderNumber() {
    return orderNumber;
  }

  /**
   * Puts the orders given by the customer in a specified format in a string
   *
   * @return String versions of old olders
   */
  public String customerOrders() {
    int orderSequence = 0;
    StringBuilder stb = new StringBuilder();

    myOrders = myOrders.mergeSort(); // Sort the old orders by price

    stb.append("\n---Cheapest to Most Expensive---");
    for (Order order : myOrders) {
      orderSequence++;
      stb.append("\n" + orderSequence + "th Order:\n" + order.toString());
    }
    return stb.toString();
  }

  /**
   * Transferring the points given in the parameters to the chef and the courier
   *
   * @param chefScore Points to be given to the chef by the customer
   * @param courierScore Points to be given to the chef by the courier
   * @param anOrder Order delivered to the user and which needs to be voted on
   */
  public void giveVote(int chefScore, int courierScore, Order order) {
    order.getOrderChef().calculateAverageScore(chefScore);
    order.getOrderCourier().calculateAverageScore(courierScore);
  }

  /**
   * It allows the customer to place the order by looking at the money situation
   * and transfer the order information to the restaurant.
   *
   * @param restaurant restaurant object
   * @param wantedOrder      Order requested by the customer
   * @return Order requested by the customer if customer has enough money
   */
  public Boolean giveOrder(Restaurant restaurant, Order wantedOrder) {
    if (!checkAllergy(restaurant, wantedOrder)) return false; else if (
      getBudget() >= wantedOrder.calculateAccount()
    ) {
      budget -= wantedOrder.calculateAccount();
      orderNumber++;
      restaurant.addOrder(wantedOrder);
      return true;
    } else {
      System.out.println("\nNot enough money,order can not be applied");
      return false;
    }
  }

  /**
   * Checks whether customer is allergic to food which is in order list.
   * and despite this, asks whether customer want to contiune.
   * @param restaurant restaurant object
   * @param wantedOrder Order requested by the customer
   * @return Order requested by the customer if customer hasn't allergy to foods of order
   */
  public boolean checkAllergy(Restaurant restaurant, Order wantedOrder) {
    Scanner sc = new Scanner(System.in);
    TreeMap<String, AVLTree<String>> ingredients = restaurant.getIngredients();
    boolean check = false;

    //Search TreeMap and AVLTree
    for (Food food : wantedOrder.getFoods()) {
      AVLTree<String> avlTree = ingredients.get(food.getFoodName());
      for (String allergy : allergies) {
        if (avlTree.contains(allergy)) {
          System.out.println(
            "\nYou are allergic to " +
            allergy +
            ". And " +
            food.getFoodName() +
            " has " +
            allergy
          );
          check = true;
        }
      }
    }

    if (check) {
      System.out.print("Do you still want to order (Press 1 to continue): ");
      if (sc.nextInt() == 1) {
        sc.close();
        return true;
      }
    }
    sc.close();
    return false;
  }

  /**
   * Indicates that the customer has received the order and makes the necessary
   * adjustments to the customer information also print the ordered foods with prices
   *
   * @param anOrder Order brought to the customer by the courier
   */
  public void takeOrder(Order anOrder) {
    myOrders.addFirst(anOrder);
    CustomLinkedList<Food> orderFoods = anOrder.getFoods();
    orderFoods = orderFoods.mergeSort();
    System.out.println("Order Foods -> Cheapest to Most Expensive");
    for (Food aFood : orderFoods) {
      System.out.println(aFood.getFoodType() + "   " + aFood.getFoodPrice());
    }
  }

  /**
   * VIP is a status given according to the number of orders placed by the
   * customer.
   *
   * @return Returns true if customer VIP,otherwise return false
   */
  public boolean isVIP() {
    if (getOrderNumber() > 5) return true; else return false;
  }

  /**
   * Student is a status based on the customer's job.
   *
   * @return Returns true if customer Student,otherwise return false
   */
  public boolean isStudent() {
    if (getJob().equals("Student")) return true; else return false;
  }

  /**
   * Allows the customer to see the menu in the restaurant
   */
  public void seeMenu() {
    Menu.seeMenu();
  }

  public int compareTo(Customer other) {
    int res;
    Customer otherCustomer = (Customer) other;
    if (this.getOrderNumber() > otherCustomer.getOrderNumber()) {
      res = 1;
    } else if (this.getOrderNumber() < otherCustomer.getOrderNumber()) {
      res = -1;
    } else res = 0;
    return res;
  }

  public int compareTo(User other) {
    return getName().compareTo(other.getName());
  }

  public static class SortByOrderNum implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
      int res;
      if (o1.getOrderNumber() > o2.getOrderNumber()) {
        res = 1;
      } else if (o1.getOrderNumber() < o2.getOrderNumber()) {
        res = -1;
      } else res = 0;
      return res;
    }
  }

  /**
   * The toString() function returns a string representation of the Customer object
   *
   * @return A string representation of the Customer object.
   */
  @Override
  public String toString() {
    StringBuilder customerInfo = new StringBuilder();
    customerInfo.append("Customer: " + "\n");
    customerInfo.append(super.toString());
    customerInfo.append("Job: " + getJob() + "\n");
    customerInfo.append("Phone number: " + getPhoneNumber() + "\n");
    customerInfo.append("Budget: " + getBudget() + "\n");
    customerInfo.append("Order number: " + getOrderNumber() + "\n");
    customerInfo.append("Given Orders: " + customerOrders() + "\n");
    return customerInfo.toString();
  }
}
