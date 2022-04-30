package src;

import java.util.PriorityQueue;
import java.util.Queue;

public class Chef extends Worker {

  private int certificateNumber;
  private Queue<Order> newOrders = new PriorityQueue<Order>();

  public Chef(
    String _name,
    int _age,
    String _username,
    String _password,
    int _certificateNumber
  ) {
    super(_name, _age, _username, _password, "Chef");
    this.certificateNumber = _certificateNumber;
  }

  public void addOrder(Order order) {
    newOrders.add(order);
  }

  public void cookFood() {
    Order order = newOrders.poll();
  }

  public int getCertificateNumber() {
    return this.certificateNumber;
  }

  public int incrementCertificateNumber() {
    return this.certificateNumber++;
  }
  public void changeMenu() {}
}
