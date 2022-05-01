package src;

import java.util.LinkedList;
import java.util.Scanner;

public class Customer extends User {

  private String job;
  private String phoneNumber;
  private float balance;
  private int orderNumber = 0;
  private  LinkedList<Order> myOrders = new LinkedList<Order>();

  public Customer(
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
  }

  Customer() {
    super();
    job = "Teacher";
    phoneNumber = "0555555555";
    balance = 100;
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
    int order_sequence = 0;
    StringBuilder stb = new StringBuilder();
    for(Order order: myOrders){
      order_sequence++;
      stb.append("\n"+order_sequence+"th Order:\n"+order.toString());
    }
    return stb.toString();
  }

  public int giveVote() {
    return 0; // 0-5 aralığı, int[] de return edilebilir 3 kişiye oy verileceğinden
    // This method will run after courier delivers the order to the customer.
    // !!! getWhoCooked burada çağırılıp, ilgili chef'e oy verilmeli ama giveVote'un nerede çağırıldığına göre parametre, return type eklenmeli.
  }

  public LinkedList<Order> giveOrder(
    LinkedList<Integer> orderedFoods,
    LinkedList<Order> orders,
    int orderID,
    Menu m
  ) {
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

  public LinkedList<Order> giveOrder(LinkedList<Order> restaurantOrders , Order wantedOrder) {
    restaurantOrders.add(wantedOrder); // bura düzenlencek !!!

  }

  public boolean is_vip() {
    if (getOrderNumber() > 5)
      return true;

    else return false;
  }

  public boolean is_student() {
    if(getJob().equals("Student"))
      return true;
    else
      return false;
  }
}
