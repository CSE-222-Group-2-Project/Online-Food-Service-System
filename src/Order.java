package src;

import java.util.Comparator;
import java.util.LinkedList;

class Order {

  // 3 yeni data field ekledim. Bunları chef'in vs constructor'ında doldur.
  public enum OrderStatus {
    ORDER_TAKEN, // Shows whether order is proper or not
    ORDER_PREPARED,
    ORDER_DELIVERED,
  }

  OrderStatus status = OrderStatus.ORDER_TAKEN;
  private Chef whoCooked; // Shows which chef cooked that order
  private Courier whoDelivered; // Shows which couier delivered that order
  private int orderID;
  private Customer c; // hangi customer sipariş verdi
  private double coefficient = 1.0;
  private double account = 0.0;

  //private LinkedList<Food> foods_in_menu = new LinkedList<Food>();
  //private LinkedList<Integer> foodID = new LinkedList<Integer>();
  private LinkedList<Food> foods = new LinkedList<Food>();

  Order(
    int orderID,
    Customer customer,
    LinkedList<Food> _foods
  ) {
    this.orderID = orderID;
    c = customer;
    foods = _foods;

    calculate_account();
  }

  public void setWhoCooked(Chef _whoCooked) {
    whoCooked = _whoCooked;
  }

  public void setWhoDelivered(Courier _whoDelivered) {
    whoDelivered = _whoDelivered;
  }

  public Customer get_customer() {
    return c;
  }

  public Chef getWhoCooked() {
    return whoCooked;
  }

  public Courier getWhoDelivered() {
    return whoDelivered;
  }

  public int get_orderID() {
    return orderID;
  }

  public void setStatus(OrderStatus stat) {
    status = stat;
  }

  public void coef_calc() { //rastgele katsayılar ekledim düzenleme yapılır.
    if (c.is_vip()) {
      coefficient = 0.85;
    }

    if (c.is_student()) {
      coefficient = 0.75;
    }
  }

  public double calculate_account() {
    coef_calc();
    for (Food afood : foods) account += afood.getFoodPrice();

    account *= coefficient;
    return account;
  }

  /* Orderlerin önceliği için Comparator class*/
  public static class ComparatorbyOrderNumber implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
      int retVal;
      if (
        o1.get_customer().getOrderNumber() > o2.get_customer().getOrderNumber()
      ) {
        retVal = 1;
      } else if (
        o1.get_customer().getOrderNumber() < o2.get_customer().getOrderNumber()
      ) {
        retVal = -1;
      } else retVal = 0;
      return retVal;
    }
  }

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
