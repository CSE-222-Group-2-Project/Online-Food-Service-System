package src;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Customer class is a user type that expresses the target audience of the
 * restaurant derived from the user class.
 *
 * @since 03-03-2022
 *
 */
public class Customer extends User {

  private String job;
  private String phoneNumber;
  private double balance; // Money of customer
  private int orderNumber = 0;
  private LinkedList<Order> myOrders = new LinkedList<Order>();

  public Customer(
    String _name,
    int _age,
    String _job,
    String _username,
    String _password,
    String _phoneNumber,
    double _balance
  ) {
    super(_name, _age, _username, _password);
    job = _job;
    phoneNumber = _phoneNumber;
    balance = _balance;
  }

  public String getJob() {
    return job;
  }

  public String getPhone() {
    return phoneNumber;
  }

  public double getBalance() {
    return balance;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  /**
   * Puts the orders given by the customer in a specified format in a string
   *
   * @return String versions of old olders
   */
  public String myOrders() {
    int order_sequence = 0;
    StringBuilder stb = new StringBuilder();
    stb.append("\n---Latest to oldest---");
    for (Order order : myOrders) {
      order_sequence++;
      stb.append("\n" + order_sequence + "th Order:\n" + order.toString());
    }
    return stb.toString();
  }

  /**
   * It asks the customer for points for the chef and the courier and transfers
   * these points to the chef and the courier via order.
   *
   * @param anOrder Order delivered to the user and which needs to be voted on
   */
  public void giveVote(Order anOrder) {
    Scanner myInput = new Scanner(System.in);
    System.out.println("Enter vote for chef: ");
    int pointofChef = myInput.nextInt();

    System.out.println("Enter vote for courier: ");
    int pointofCourier = myInput.nextInt();

    anOrder.getWhoCooked().calculateAverageScore(pointofChef);
    anOrder.getWhoDelivered().calculateAverageScore(pointofCourier);
  }

  /**
   * It allows the customer to place the order by looking at the money situation
   * and transfer the order information to the restaurant.
   *
   * @param restaurantOrders Restaurant's order list
   * @param wantedOrder      Order requested by the customer
   * @return Restaurant's order list containing the order requested by the customer
   */
  public void giveOrder(Restaurant restaurant, Order wantedOrder) {
    if (getBalance() >= wantedOrder.calculate_account()) {
      balance -= wantedOrder.calculate_account();
      restaurant.addOrder(wantedOrder);
      orderNumber++;
    } else {
      System.out.println("\nNot enough money,order can not be applied");
    }
  }

  /**
   * Indicates that the customer has received the order and makes the necessary
   * adjustments to the customer information
   *
   * @param anOrder Order brought to the customer by the courier
   */
  public void takeOrder(Order anOrder) {
    System.out.println("Order received by " + getName());
    myOrders.addFirst(anOrder);
    giveVote(anOrder);
  }

  /**
   * VIP is a status given according to the number of orders placed by the
   * customer.
   *
   * @return Returns true if customer VIP,otherwise return false
   */
  public boolean is_vip() {
    if (getOrderNumber() > 5) return true; else return false;
  }

  /**
   * Student is a status based on the customer's job.
   *
   * @return Returns true if customer Student,otherwise return false
   */
  public boolean is_student() {
    if (getJob().equals("Student")) return true; else return false;
  }

  /**
   * Allows the customer to see the menu in the restaurant
   */
  public void seeMenu() {
    Menu.seeMenu();
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
    customerInfo.append("Phone number: " + getPhone() + "\n");
    customerInfo.append("Balance: " + getBalance() + "\n");
    customerInfo.append("Order number: " + getOrderNumber() + "\n");
    customerInfo.append("Given Orders: " + myOrders() + "\n");
    return customerInfo.toString();
  }
}
