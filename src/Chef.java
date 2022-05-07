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

  // certificate number of the chef
  private int certificateNumber;

  // All orders that chef is going to prepare
  private Queue<Order> newOrders = new PriorityQueue<>();

  // initial salary of the Chefs
  private final double INITIAL_SALARY = 4000.0;

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
    this.certificateNumber = _certificateNumber;
    calculateStatus();
    calculateSalary(INITIAL_SALARY);
  }

  /**
   * Add the order to the order queue.
   *
   * @param order The order to be added to the queue.
   */
  public void addOrder(Order order) {
    newOrders.add(order);
    order.setWhoCooked(this);
  }

  /**
   * Prepare the order in the order queue.
   *
   * @param courier the courier who is going to deliver the order
   */
  public void prepareOrder(Courier courier) {
    Order order = newOrders.poll();
    order.setStatus(Order.OrderStatus.ORDER_PREPARED);
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
      workerStat = WorkerStatus.BEGINNER;
    } else if (successWeight < 5) {
      workerStat = WorkerStatus.JUNIOR;
    } else if (successWeight < 7) {
      workerStat = WorkerStatus.MID_LEVEL;
    } else {
      workerStat = WorkerStatus.SENIOR;
    }
  }

  /**
   * The toString() function returns a string representation of the Chef object
   *
   * @return A string representation of the chef object.
   */
  @Override
  public String toString() {
    StringBuilder chefInfo = new StringBuilder();
    chefInfo.append("Chef: ");
    chefInfo.append(super.toString());
    chefInfo.append("\nCertificate Number: ");
    chefInfo.append(this.certificateNumber);
    chefInfo.append("Chef Order Queue: " + newOrders);
    chefInfo.append("\n");
    return chefInfo.toString();
  }

  /**
   * Returns the orders in process
   * 
   * @return the size of newOrders object
   */
  public int getSizeOfOrders(){
    return newOrders.size(); 
  }
}
