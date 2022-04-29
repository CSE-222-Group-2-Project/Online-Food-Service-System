package src;

import java.util.LinkedList;
import java.util.Scanner;

public class Customer extends User {

  private String job;
  private String phoneNumber;
  private float balance;
  private int orderNumber;
  private int status; // 1 student(yaşa veya mesleğe göre) 2 vıp(ordernumberına göre)

  Customer(
    String _name,
    int _age,
    String _job,
    String _username,
    String _password,
    String _phoneNumber,
    float _balance
  ) {
    super(_name, _age, _username, _password);
    job = _job;
    phoneNumber = _phoneNumber;
    balance = _balance;
    orderNumber = 0;
    status = 0;
  }

  Customer() {
    super();
    job = "Teacher";
    phoneNumber = "0555555555";
    balance = 0;
    orderNumber = 0;
    status = 0;
  }

  public String getJob() {
    return job;
  }

  public String getPhone() {
    return phoneNumber;
  }

  public float getBalance() {
    return balance;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public String myOrders() {
    return "empty";
  }

  public int giveVote() {
    return 0; // 0-5 aralığı, int[] de return edilebilir 3 kişiye oy verileceğinden
  }

  public LinkedList<Order> giveOrder(
    LinkedList<Integer> orderedFoods,
    LinkedList<Order> orders,
    int orderID,
    Menu m
  ) { // return type Order classı herhalde
    Scanner myInput = new Scanner(System.in);
    int o = myInput.nextInt();
    while (o != -1) {
      orderedFoods.add(o);
      o = myInput.nextInt();
    }
    Order temp = new Order(orderedFoods, orderID, this, m);
    orders.add(temp);
    orderedFoods.clear();
    orderNumber++;
    return orders;
  }

  public void seeMenu() { // menu classını çağırıp printlettirme,restoran classında da oalbilir
    // restorana geçirmek de mantıklı olabilir
  }

  public Boolean is_vip() {
    if (orderNumber > 5) {
      return true;
    } else return false;
  }
}
