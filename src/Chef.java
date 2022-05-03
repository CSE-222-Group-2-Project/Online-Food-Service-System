package src;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Chef class is a subclass of Worker class which represents the Chefs of the restaurant.
 * @since  03-03-2022
 *
 */

/**
 * Chef class is a subclass of Worker class which represents the Chefs of the restaurant.
 */
public class Chef extends Worker {

  private WorkerStatus chefStat;
  private int certificateNumber;
  private Queue<Order> newOrders = new PriorityQueue<Order>();

  /* Default Constructer of Chef Class */
  public Chef(
    String _name,
    int _age,
    String _username,
    String _password,
    int _certificateNumber,
    int experienceYear
  ) {
    super(_name, _age, _username, _password, "Chef", experienceYear);
    this.certificateNumber = _certificateNumber; // !!! certificateNumber maaş hesabında vs kullanılack
    calculateStatus();
  }

  /**
   * Add the order to the order queue.
   *
   * @param order The order to be added to the queue.
   */
  public void addOrder(Order order) {
    newOrders.add(order);
  }

  /**
   * Prepare the order in the order queue.
   *
   * @param courier the courier who is going to deliver the order
   */
  public void prepareOrder(Courier courier) {
    Order order = newOrders.poll();
    order.setStatus(Order.Status.orderPrepared);
    courier.addOrder(order);
  }

  /**
   * This function returns the certificate number of the Chef.
   *
   * @return The certificate number.
   */
  public int getCertificateNumber() {
    return this.certificateNumber;
  }

  /**
   * This function increments the certificate number by one.
   *
   * @return Certificate Number of the Chef
   */
  public int incrementCertificateNumber() {
    return this.certificateNumber++;
  }

  /**
   * Calculate the status of the chef according to the experience year and certificate number.
   * successWeight = (certificateNumber * 0.3) + (experienceYear * 0.7)
   */
  public void calculateStatus() {
    double successWeight =
      (certificateNumber * 0.3) + (getExperienceYear() * 0.7);

    if (successWeight < 3) {
      chefStat = WorkerStatus.BEGINNER;
    } else if (successWeight < 5) {
      chefStat = WorkerStatus.JUNIOR;
    } else if (successWeight < 7) {
      chefStat = WorkerStatus.MID_LEVEL;
    } else {
      chefStat = WorkerStatus.SENIOR;
    }
  }

  public void changeMenu() {} // !!! üzerine düşün
}
