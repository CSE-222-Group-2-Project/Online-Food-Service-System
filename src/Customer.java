package src;

import java.util.LinkedList;

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
  private String job;
  private String phoneNumber;
  private double budget;
  private int orderNumber = 0;
  private LinkedList<Order> myOrders = new LinkedList<>();

  // Constructors
  /*Constructer of Customer Class */
  public Customer(
    String _name,
    int _age,
    String _job,
    String _username,
    String _password,
    String _phoneNumber,
    double _budget
  ) {
    super(_name, _age, _username, _password);
    job = _job;
    phoneNumber = _phoneNumber;
    budget = _budget;
  }

  /**
   * This function returns the job of the customer
   *
   * @return The job of the customer is being returned.
   */
  public String getJob() {
    return job;
  }

  /**
   * This function returns the phone number of the customer
   *
   * @return The phone number of the customer.
   */
  public String getPhone() {
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
   * Transferring the points given in the parameters to the chef and the courier
   *
   * @param _scoreChef Points to be given to the chef by the customer
   * @param _scoreCourier Points to be given to the chef by the courier 
   * @param anOrder Order delivered to the user and which needs to be voted on
   */
  public void giveVote(int _scoreChef, int _scoreCourier, Order anOrder) {
    anOrder.getWhoCooked().calculateAverageScore(_scoreChef);
    anOrder.getWhoDelivered().calculateAverageScore(_scoreCourier);
  }

  /**
   * It allows the customer to place the order by looking at the money situation
   * and transfer the order information to the restaurant.
   *
   * @param restaurantOrders Restaurant's order list
   * @param wantedOrder      Order requested by the customer
   * @return Order requested by the customer if customer has enough money
   */
  public Boolean giveOrder(Restaurant restaurant, Order wantedOrder) {
    if (getBudget() >= wantedOrder.calculateAccount()) {
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
   * Indicates that the customer has received the order and makes the necessary
   * adjustments to the customer information
   *
   * @param anOrder Order brought to the customer by the courier
   */
  public void takeOrder(Order anOrder) {
    System.out.println("Order received by " + getName());
    myOrders.addFirst(anOrder);
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
    customerInfo.append("Budget: " + getBudget() + "\n");
    customerInfo.append("Order number: " + getOrderNumber() + "\n");
    customerInfo.append("Given Orders: " + myOrders() + "\n");
    return customerInfo.toString();
  }
}
