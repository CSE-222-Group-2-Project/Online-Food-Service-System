package src.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.PriorityQueue;
import src.constants.District;
import src.constants.OrderStatus;
import src.constants.WorkerStatus;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.datastructures.graph.DijkstrasAlgorithm;

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

  private District source;
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
    this.source = District.RESTAURANT;
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
    order.setOrderCourier(this);

  }

  /**
   * Deliver the order to the customer.
   *
   */
  public void deliverOrderToCustomer() {
    if(orderQueue.size() != 0) {
      Order order = orderQueue.poll();
      showShortestRoute(order.getDestination().toString());
      this.source = order.getDestination();
      Customer orderOwner = order.getCustomer();
      order.setStatus(OrderStatus.ORDER_DELIVERED);
      orderOwner.takeOrder(order);
    }
    else {
      this.source = District.RESTAURANT;
      System.out.println("There is no order currently");
    }
  }

  /**
   * Calculate the status of the courier accordinıg to the experience year.
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

  /**
   * Given a District, return the ordinal value of that District.
   *
   * @param district The district to find the value of.
   * @return The ordinal value of the district.
   */
  private int findValueOfDistrict(District district) {
    return district.ordinal();
  }


  public int compareTo(Admin other) {
    return getName().compareTo(other.getName());
  }

  /**
   * It takes a destination as a parameter, and returns an ArrayList of Integers that represent the shortest route from the
   * source to the destination
   *
   * @param destination The destination district
   * @return The shortest route from the source to the destination.
   */
  public void showShortestRoute(String destination) {
    int numV = Restaurant.districtsGraph.getNumV();
    int[] pred = new int[numV];
    double[] distances = new double[numV];
    DijkstrasAlgorithm.dijkstrasAlgorithm(
            Restaurant.districtsGraph,
            findValueOfDistrict(source),
            pred,
            distances
    );
    District dest = District.valueOf(destination);

    ArrayList<Integer> shortestRoute = new ArrayList<>();
    shortestRoute.add(source.ordinal());


    getShortestRoute(
            pred,
            shortestRoute,
            dest.ordinal(),
            this.source.ordinal()
    );




    System.out.println("Destination to the "+ destination + " ->> "+ distances[dest.ordinal()]);

    ListIterator<Integer> iterator = shortestRoute.listIterator(shortestRoute.size()-1);
    District[] values = District.values();
    while (iterator.hasPrevious()) {
      Integer district = iterator.previous();
      System.out.print(values[district].name() + " ->> ");
    }
    System.out.println(values[dest.ordinal()].name());
    System.out.println();

  }






  /**
   * It takes in the predecessor array, the route array, the current node, and the destination node. It then checks if the
   * current node is the destination node. If it is, it adds the current node to the route array and returns the current
   * node. If it isn't, it adds the current node to the route array and calls the function again with the current node's
   * predecessor as the current node
   *
   * @param pred the array that stores the shortest path from the source to the destination
   * @param route the shortest route from source to destination
   * @param i the current node
   * @param des destination node
   * @return The shortest route from the source to the destination.
   */
  private int getShortestRoute(
          int[] pred,
          ArrayList<Integer> route,
          int i,
          int des
  ) {
    if (des == pred[i]) {
      route.add(pred[i]);
      return pred[i];
    }
    route.add(pred[i]);
    return getShortestRoute(pred, route, pred[i], des);
  }
  public int compareTo(User other) {
    return getName().compareTo(other.getName());
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
