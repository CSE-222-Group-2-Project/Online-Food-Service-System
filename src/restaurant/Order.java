package src.restaurant;

import java.util.Comparator;
import src.constants.District;
import src.constants.OrderStatus;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.user.Chef;
import src.user.Courier;
import src.user.Customer;

/**
 *  Order class is used to represent the order of the Customer
 * @author Group 2
 * @version 2.0.0
 * @since 14.06.2022
 */
/**
 * Order class is used to represent the order of the Customer
 */
public class Order implements Comparable<Order> {

  // Data Fields
  OrderStatus orderStatus = OrderStatus.ORDER_TAKEN;
  private Chef orderChef;
  private Courier orderCourier;
  private int orderID;
  private Customer orderOwner;
  private double orderCoefficient = 1.0;
  private double orderAccount = 0.0;
  private CustomLinkedList<Food> foods = new CustomLinkedList<>();
  private District orderDestination;

  // Constructers
  /**
   * Constructor of the Order class
   * @param orderID the ID of the order
   * @param orderOwner owner of the order
   * @param foods the foods in the order
   */
  public Order(
    int orderID,
    Customer orderOwner,
    CustomLinkedList<Food> foods,
    String orderDestination
  ) {
    this.orderID = orderID;
    this.orderOwner = orderOwner;
    this.foods = foods;
    this.orderDestination = District.valueOf(orderDestination);
    calculateAccount();
  }

  /**
   * This function sets the chef of the order
   *
   * @param orderChef The chef who cooked the order.
   */
  public void setOrderChef(Chef orderChef) {
    this.orderChef = orderChef;
  }

  /**
   * This function sets the courier who delivered the order
   *
   * @param orderCourier Courier
   */
  public void setOrderCourier(Courier orderCourier) {
    this.orderCourier = orderCourier;
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
  public Chef getOrderChef() {
    return orderChef;
  }

  /**
   * It returns the courier who delivered the order.
   *
   * @return The courier who delivered the order.
   */
  public Courier getOrderCourier() {
    return orderCourier;
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
    return orderAccount;
  }

  /**
   * This function sets the status of the order to the status passed in
   *
   * @param orderStatus The status of the order.
   */
  public void setStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  /**
   * This function returns the destination of the edge
   *
   * @return The destination of the edge.
   */
  public District getDestination() {
    return orderDestination;
  }

  /**
   * "If the order owner is a VIP, set the coefficient to 0.85. If the order owner is a student, set the
   * coefficient to 0.75."
   *
   */
  public void calculateCoefficient() {
    if (orderOwner.isVIP()) {
      orderCoefficient = 0.85;
    }

    if (orderOwner.isStudent()) {
      orderCoefficient = 0.75;
    }
  }

  /**
   * It calculates the account of the order
   *
   * @return The orderAccount is being returned.
   */
  public double calculateAccount() {
    double account = 0.0;
    calculateCoefficient();
    for (Food afood : foods) account += afood.getFoodPrice();

    account *= orderCoefficient;
    orderAccount = account;
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
    orderInfo.append("Order Price: " + orderAccount + "\n");
    orderInfo.append("Order Chef: " + getOrderChef().getName() + "\n");
    orderInfo.append("Order Courier: " + getOrderCourier().getName() + "\n");
    orderInfo.append("Order Status: " + orderStatus + "\n");
    orderInfo.append("Order Foods: \n");
    for (Food afood : foods) orderInfo.append("\n" + afood.toString());

    return orderInfo.toString();
  }
}
