package src;

import java.util.PriorityQueue;
import java.util.Queue;

public class Chef extends Worker {

  workerStatus chefStat;
  private int certificateNumber;
  private Queue<Order> newOrders = new PriorityQueue<Order>();

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

  public void addOrder(Order order) {
    // Until reaching some amount, orders will be added to queue.
    newOrders.add(order);
  }

  public void prepareOrder(Courier courier) {
    Order order = newOrders.poll();
    order.setStatus(Order.Status.orderPrepared);
    courier.addOrder(order);
  }

  public int getCertificateNumber() {
    return this.certificateNumber;
  }

  public int incrementCertificateNumber() {
    return this.certificateNumber++;
  }

  public void calculateStatus() {
    if (getExperienceYear() < 4) {
      chefStat = workerStatus.beginner;
    } else if (getExperienceYear() < 6) {
      chefStat = workerStatus.junior;
    } else if (getExperienceYear() < 8) {
      chefStat = workerStatus.midLevel;
    } else {
      chefStat = workerStatus.senior;
    }
  }

  public void changeMenu() {} // !!! üzerine düşün
}
