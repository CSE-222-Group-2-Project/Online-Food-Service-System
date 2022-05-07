package src;

import java.util.Comparator;
import java.util.LinkedList;

class Order {
  // 3 yeni data field ekledim. Bunları chef'in vs constructor'ında doldur.
  public enum Status {
  orderTaken, // Shows whether order is proper or not
  orderPrepared,
  orderDelivered
  }
  Status status = Status.orderTaken;
  private Chef whoCooked; // Shows which chef cooked that order
  private Courier whoDelivered; // Shows which couier delivered that order
  private int orderID;
  private Customer c; // hangi customer sipariş verdi
  private double coefficient = 1.0;
  private double account = 0.0;

  //private LinkedList<Food> foods_in_menu = new LinkedList<Food>();
  //private LinkedList<Integer> foodID = new LinkedList<Integer>();
  private LinkedList<Food> foods = new LinkedList<Food>();

  Order(int orderID, Customer customer,LinkedList<Food> _foods,Chef _whoCooked,Courier _whoDelivered) {
    this.orderID = orderID;
    c = customer;
    whoCooked = _whoCooked;
    whoDelivered = _whoDelivered;
    foods = _foods;

    calculate_account();
  }

  public Customer get_customer() {
    return c;
  }

  public Chef getWhoCooked(){
    return whoCooked;
  }

  public Courier getWhoDelivered(){
    return whoDelivered;
  }

  public int get_orderID() {
    return orderID;
  }

  public void setStatus(Status stat){
    status = stat;
  }

  public void coef_calc() { //rastgele katsayılar ekledim düzenleme yapılır.
    if (c.is_vip()) {
      coefficient = 0.85;
    }

    if (c.is_student()) {
      coefficient = 0.75;
    }
  }

  public double calculate_account() {
    coef_calc();
    for(Food afood: foods)
      account+= afood.get_food_price();
    
    account *= coefficient;
    return account;
  }


  /* Orderlerin önceliği için Comparator class*/
  public static class ComparatorbyOrderNumber implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
      int retVal;
      if(o1.get_customer().getOrderNumber() >o2.get_customer().getOrderNumber() ){
        retVal = 1;
      }
      else if(o1.get_customer().getOrderNumber() < o2.get_customer().getOrderNumber() ){
        retVal = -1;
      }
      else  retVal = 0;
      return retVal;
    }
  }


  public String toString() {
    StringBuilder stb = new StringBuilder();
    
    stb.append("\nOrder id: "+ orderID);
    stb.append("\nOrder price: "+ account);
    stb.append("\nOrder maker: "+getWhoCooked().getName());
    stb.append("\nCourier: "+getWhoDelivered().getName());
    stb.append("\nOrdered foods:");
    
    for(Food afood:foods)
      stb.append("\n"+afood.toString());

    return stb.toString();
  }

}

