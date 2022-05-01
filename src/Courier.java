package src;

import java.util.PriorityQueue;

public class Courier extends Worker { // !!! ne eklenebilir düşün

  private PriorityQueue<Order> orderQueue = new PriorityQueue<>(); // To determine which order is more "important", priority queue is used.

  public Courier(String _name, int _age, String _username, String _password) {
    super(_name, _age, _username, _password, "Courier");
  }

  public void addOrder(Order order) {
    orderQueue.add(order);  // add func bu halde valid, bizim bir add func yazmamıza gerek yok.
  }

  public void deliverOrderToCustomer(Order order) { // !!! fill
    Customer orderOwner = order.get_customer();
  }

  //public boolean add(Order order) {}

  public void makeOrderReady() {} // When chef prepares the order, status field in Order class will be true

}
