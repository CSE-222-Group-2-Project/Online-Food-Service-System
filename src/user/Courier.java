package src.user;

import src.graph.DijkstrasAlgorithm;
import src.graph.Graph;
import src.graph.ListGraph;

import java.util.PriorityQueue;
import src.restaurant.Order;
import src.restaurant.Order.ComparatorbyOrderNumber;
import src.restaurant.Order.OrderStatus;
import src.user.Worker.WorkerStatus;

/**
 *Courier class is a subclass of Worker class which represents the Courier of the restaurant.
 * @author Group 2
 * @version 1.0.0
 * @since 08.04.2022
 */

/**
 * Courier class is a subclass of Worker class which represents the Courier of the restaurant.
 */
public class Courier extends Worker {

  // Data Fields
  // phone number of the couriers
  private String phoneNumber;

  // To determine which order is more "important", priority queue is used.
  private PriorityQueue<Order> orderQueue = new PriorityQueue<>(
    new Order.ComparatorbyOrderNumber()
  );

  // initial salary of the Couriers
  private final double INITIAL_SALARY = 3000.0;

  // Constructors
  /**
   * Constructor of the Courier class
   * @param _name the name of the courier
   * @param _age the age of the courier
   * @param _username the username of the courier
   * @param _password the password of the courier
   * @param _phoneNumber the phone number of the courier
   * @param experienceYear the experience year of the courier
   */
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
    calculateStatus();
    calculateSalary(INITIAL_SALARY);
  }

  // Methods
  /**
   * This function sets the phone number of the courier to the new phone number.
   *
   * @param newPhoneNumber The new phone number to set.
   */
  public void setPhoneNumber(String newPhoneNumber) {
    phoneNumber = newPhoneNumber;
  }

  /**
   * This function returns the phone number of the courier.
   *
   * @return The phone number of the courier.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Returns the size of orders queue
   *
   * @return returns the size of PriorityQueue
   */
  public int getSizeOfOrders() {
    return orderQueue.size();
  }

  /**
   * Add the order to the order queue.
   *
   * @param order The order to be added to the queue.
   */
  public void addOrder(Order order) {
    orderQueue.add(order);
    order.setWhoDelivered(this);
  }

  /**
   * Deliver the order to the customer.
   *
   */
  public void deliverOrderToCustomer() {
    Order order = orderQueue.poll();
    Customer orderOwner = order.getCustomer();
    order.setStatus(Order.OrderStatus.ORDER_DELIVERED);
    orderOwner.takeOrder(order);
  }

  /**
   * Calculate the status of the courier according to the experience year.
   */
  public void calculateStatus() {
    if (getExperienceYear() < 4) {
      workerStat = WorkerStatus.BEGINNER;
    } else if (getExperienceYear() < 6) {
      workerStat = WorkerStatus.JUNIOR;
    } else if (getExperienceYear() < 8) {
      workerStat = WorkerStatus.MID_LEVEL;
    } else {
      workerStat = WorkerStatus.SENIOR;
    }
  }

  private int findValueOfDistrict(String district){

    District dayEnum = District.valueOf(district);
    return dayEnum.ordinal();

  }
  public int[] showShortestRoute(String district){
    int numV =Restaurant.districtsGraph.getNumV();
    int [] pred = new int[numV];
    double [] distances = new double[numV];
    DijkstrasAlgorithm.dijkstrasAlgorithm(Restaurant.districtsGraph,findValueOfDistrict(district),pred,distances);
    return pred;
  }
  /**
   * The toString() function returns a string representation of the Courier object
   *
   * @return A string representation of the courier object.
   */
  @Override
  public String toString() {
    StringBuilder courierInfo = new StringBuilder();
    courierInfo.append("Courier: ");
    courierInfo.append(super.toString());
    courierInfo.append("Phone Number: " + phoneNumber + "\n");
    courierInfo.append("Courier Order Queue: " + orderQueue.peek() + "\n");
    return courierInfo.toString();
  }
}
