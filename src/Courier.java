package src;

import java.util.PriorityQueue;

public class Courier extends Worker { // !!! ne eklenebilir düşün

  workerStatus courierStat;
  private String phoneNumber; // constructorlara ekle
  private PriorityQueue<Order> orderQueue = new PriorityQueue<>(); // To determine which order is more "important", priority queue is used.

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

  public void addOrder(Order order) {
    orderQueue.add(order); // add func bu halde valid, bizim bir add func yazmamıza gerek yok.
  }

  public void deliverOrderToCustomer(Order order) { // !!! fill
    Customer orderOwner = order.get_customer(); // orderOwner'ın foodTaken tarzı bir methodu olsun. atacana bildir :D
    order.setStatus(Order.Status.orderDelivered);
    // orderOwner.takeOrder(order);
  }

  public void calculateStatus() {
    if (getExperienceYear() < 4) {
      courierStat = workerStatus.beginner;
    } else if (getExperienceYear() < 6) {
      courierStat = workerStatus.junior;
    } else if (getExperienceYear() < 8) {
      courierStat = workerStatus.midLevel;
    } else {
      courierStat = workerStatus.senior;
    }
  }
}
