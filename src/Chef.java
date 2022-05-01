package src;

import java.util.PriorityQueue;
import java.util.Queue;

public class Chef extends Worker { // !!! ne eklenebilir düşün
  workerStatus chefStat; 
  private int certificateNumber;
  private Queue<Order> newOrders = new PriorityQueue<Order>(); // All incoming orders will be kept in this field.

  public Chef(
    String _name,
    int _age,
    String _username,
    String _password,
    int _certificateNumber
  ) {
    super(_name, _age, _username, _password, "Chef");
    this.certificateNumber = _certificateNumber;  // !!! certificateNumber maaş hesabında vs kullanılack
    // calculateStatus() cagir.
  }

  public void addOrder(Order order) {
    newOrders.add(order); // Until reaching some amount, orders will be added to queue.
  }

// order'ı queue'dan çek, statüsünü değiştir.
  public void orderPrepared(Courier courier) {
    Order order = newOrders.poll(); // Oldest order in newOrders queue will be cooked in here.
    order.setStatus(orderPrepared);
    courier.addOrder(order);  // Polled order will be send to courier.
        // !!! kuryeye burda haber gönder.
  }

  public int getCertificateNumber() {
    return this.certificateNumber;
  }

  public int incrementCertificateNumber() {
    return this.certificateNumber++;
  }

  public void calculateStatus(){
    //switch(experienceyerar) 'a göre set chefStat.
  }

  public void changeMenu() {} // !!! üzerine düşün

}
