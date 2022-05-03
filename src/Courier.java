package src;

import java.util.PriorityQueue;

/**
 * Courier class is a subclass of Worker class which represents the Courier of the restaurant.
 * @since  03-03-2022
 *
 */

/**
 * Courier class is a subclass of Worker class which represents the Courier of the restaurant.
 */
public class Courier extends Worker {

  WorkerStatus courierStat;
  private String phoneNumber;
  private PriorityQueue<Order> orderQueue = new PriorityQueue<>(); // To determine which order is more "important", priority queue is used.

  /* Default Constructer of Courier Class */
  public Courier(
    String _name,
    int _age,
    String _username,
    String _password,
    String _phoneNumber,
    int experienceYear
  ) {
    super(_name, _age, _username, _password, "Courier", experienceYear);
    this.phoneNumber = _phoneNumber;
  }

  /**
   * Add the order to the order queue.
   *
   * @param order The order to be added to the queue.
   */
  public void addOrder(Order order) {
    orderQueue.add(order);
  }

  /**
   * Deliver the order to the customer.
   *
   * @param order The order that is to be delivered to the customer.
   */
  public void deliverOrderToCustomer(Order order) {
    Customer orderOwner = order.get_customer(); // orderOwner'ın foodTaken tarzı bir methodu olsun. atacana bildir :D
    order.setStatus(Order.Status.orderDelivered);
    orderOwner.takeOrder(order);
  }

  /**
   * Calculate the status of the courier according to the experience year.
   */
  public void calculateStatus() {
    if (getExperienceYear() < 4) {
      courierStat = WorkerStatus.BEGINNER;
    } else if (getExperienceYear() < 6) {
      courierStat = WorkerStatus.JUNIOR;
    } else if (getExperienceYear() < 8) {
      courierStat = WorkerStatus.MID_LEVEL;
    } else {
      courierStat = WorkerStatus.SENIOR;
    }
  }
}
