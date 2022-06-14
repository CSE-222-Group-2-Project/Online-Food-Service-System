package src;

import java.util.Comparator;
import src.linkedlistwithmergesort.CustomLinkedList;

/**
 *  Order class is used to represent the order of the Customer
 * @author Group 2
 * @version 1.0.0
 * @since 08.04.2022
 */
/**
 * Order class is used to represent the order of the Customer
 */
public class Order implements Comparable<Order> {

  /**  An enum class. It is used to represent the status of the order. */
  public enum OrderStatus {
    /** Order is taken by the restaurant statu */
    ORDER_TAKEN,
    /** Order is prepared by the chef statu*/
    ORDER_PREPARED,
    /** Order is delivered by the chef statu*/
    ORDER_DELIVERED,
  }

  // Data Fields
  OrderStatus status = OrderStatus.ORDER_TAKEN;
  private Chef orderChef;
  private Courier ordeCourier;
  private int orderID;
  private Customer orderOwner;
  private double coefficient = 1.0;
  private double account = 0.0;
  private CustomLinkedList<Food> foods = new CustomLinkedList<Food>();

  private String destination;
  // Constructers
  /**
   * Constructor of the Order class
   * @param orderID the ID of the order
   * @param customer owner of the order
   * @param _foods the foods in the order
   */
  public Order(int orderID, Customer customer, CustomLinkedList<Food> _foods,String destination) {
    this.orderID = orderID;
    orderOwner = customer;
    foods = _foods;
    this.destination = destination;
    calculateAccount();
  }

  /**
   * This function sets the chef of the order
   *
   * @param _whoCooked The chef who cooked the order.
   */
  public void setWhoCooked(Chef _whoCooked) {
    orderChef = _whoCooked;
  }

  /**
   * This function sets the courier who delivered the order
   *
   * @param _whoDelivered Courier
   */
  public void setWhoDelivered(Courier _whoDelivered) {
    ordeCourier = _whoDelivered;
  }

  /**
   * This function returns the foods linked list
   *
   * @return The foods linked list.
   */
  public CustomLinkedList<Food> getFoods() {
    return foods;
  }

  /**
   * This function returns the customer who owns this order.
   *
   * @return The orderOwner object.
   */
  public Customer getCustomer() {
    return orderOwner;
  }

  /**
   * This function returns the chef who cooked the order
   *
   * @return The chef who cooked the order.
   */
  public Chef getWhoCooked() {
    return orderChef;
  }

  /**
   * It returns the courier who delivered the order.
   *
   * @return The courier who delivered the order.
   */
  public Courier getWhoDelivered() {
    return ordeCourier;
  }

  /**
   * This function returns the ID of the order
   *
   * @return The ID of the order
   */
  public int getOrderID() {
    return orderID;
  }

  /**
   * It returns the account balance of the order.
   *
   * @return The account balance of the order.
   */
  public double getAccount() {
    return account;
  }

  /**
   * This function sets the status of the order to the status passed in
   *
   * @param stat The status of the order.
   */
  public void setStatus(OrderStatus stat) {
    status = stat;
  }

  /**
   * "If the order owner is a VIP, set the coefficient to 0.85. If the order owner is a student, set the
   * coefficient to 0.75."
   *
   */
  public void coefCalc() {
    if (orderOwner.isVIP()) {
      coefficient = 0.85;
    }

    if (orderOwner.isStudent()) {
      coefficient = 0.75;
    }
  }

  /**
   * It calculates the account of the order
   *
   * @return The orderAccount is being returned.
   */
  public double calculateAccount() {
    double orderAccount = 0.0;
    coefCalc();
    for (Food afood : foods) orderAccount += afood.getFoodPrice();

    orderAccount *= coefficient;
    account = orderAccount;
    return orderAccount;
  }

  /**
   * This class implements the Comparator interface and overrides the compare method
   * It compares orders according to their account balance
   */
  public static class ComparatorbyOrderNumber implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
      if (o1.getAccount() < o2.getAccount()) {
        return 1;
      } else if (o1.getAccount() > o2.getAccount()) {
        return -1;
      } else {
        return 0;
      }
    }
  }

  /**
   * If the account number of the current object is greater than the account number of the object passed
   * in, return 1. If the account number of the current object is less than the account number of the
   * object passed in, return -1. Otherwise, return 0
   *
   * @param o The object to be compared.
   */
  @Override
  public int compareTo(Order o) {
    if (this.getAccount() > o.getAccount()) {
      return 1;
    } else if (this.getAccount() < o.getAccount()) {
      return -1;
    } else {
      return 0;
    }
  }

  /**
   * It returns a string that contains the order ID, the order price, the name of the chef who cooked the
   * order, the name of the courier who delivered the order, the order status, and the foods in the order
   *
   * @return The order information.
   */
  @Override
  public String toString() {
    StringBuilder orderInfo = new StringBuilder();
    orderInfo.append("Order Info: \n");
    orderInfo.append("Order ID: " + orderID + "\n");
    orderInfo.append("Order Price: " + account + "\n");
    orderInfo.append("Order Chef: " + getWhoCooked().getName() + "\n");
    orderInfo.append("Order Courier: " + getWhoDelivered().getName() + "\n");
    orderInfo.append("Order Status: " + status + "\n");
    orderInfo.append("Order Foods: \n");
    for (Food afood : foods) orderInfo.append("\n" + afood.toString());

    return orderInfo.toString();
  }
}
