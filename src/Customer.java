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
    stb.append("\n---Latest to oldest---");
    for(Order order: myOrders){
      order_sequence++;
      stb.append("\n"+order_sequence+"th Order:\n"+order.toString());
    }
    return stb.toString();
  }

  public void giveVote(Order anOrder) {
    // This method will run after courier delivers the order to the customer.
    Scanner myInput = new Scanner(System.in);
    System.out.println("Enter vote for chef: ");
    int voteChef = myInput.nextInt();

    System.out.println("Enter vote for courier: ");
    int voteCourier = myInput.nextInt();

    anOrder.getWhoCooked().calculateAverageScore(voteChef);
    anOrder.getWhoDelivered().calculateAverageScore(voteCourier);

  }

  public LinkedList<Order> giveOrder(LinkedList<Order> restaurantOrders , Order wantedOrder) {
    if(getBalance() >= wantedOrder.calculate_account()){
      balance-= wantedOrder.calculate_account();
      restaurantOrders.add(wantedOrder);
      orderNumber++;
    }
    else
      System.out.println("\nNot enough money,order can not be applied");

    return restaurantOrders;
  }

  public void takeOrder(Order anOrder) {
    myOrders.addFirst(anOrder);
    giveVote(anOrder);
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
