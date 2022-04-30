package src;

import java.util.PriorityQueue;

public class Courier extends Worker {

  private PriorityQueue<Order> orderQueue = new PriorityQueue<>();

  public Courier(String _name, int _age, String _username, String _password) {
    super(_name, _age, _username, _password, "Courier");
  }

  public void deliverFood() {
    Order order = orderQueue.poll();
    Customer orderOwner = order.get_customer();
  }
}
