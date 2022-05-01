package src;

import java.util.PriorityQueue;

public class Courier extends Worker { // !!! ne eklenebilir düşün
  workerStatus courierStat; 
  private String phoneNumber; // constructorlara ekle
  private PriorityQueue<Order> orderQueue = new PriorityQueue<>(); // To determine which order is more "important", priority queue is used.

  public Courier(String _name, int _age, String _username, String _password) {
    super(_name, _age, _username, _password, "Courier");
  }

  public void addOrder(Order order) {
    orderQueue.add(order);  // add func bu halde valid, bizim bir add func yazmamıza gerek yok.
  }

  public void deliverOrderToCustomer(Order order) { // !!! fill
    Customer orderOwner = order.get_customer(); // orderOwner'ın foodTaken tarzı bir methodu olsun. atacana bildir :D
    order.setStatus(orderDelivered);
    // foodTaken methodune order'ı gönder.
    // foodTaken'da giveVote methodu cagirilsin.
  }

  //public boolean add(Order order) {}

  public void calculateStatus(){
    //switch(experienceyerar) 'a göre set courierStat.
  }

}
