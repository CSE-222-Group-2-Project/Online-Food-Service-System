package src;

import java.util.LinkedList;

class Order {
  // 3 yeni data field ekledim. Bunları chef'in vs constructor'ında doldur.
  enum Status {
  orderTaken, // Shows whether order is proper or not
  orderPrepared,
  orderDelivered
  }
  Status status = Status.orderTaken;
  private String whoCooked; // Shows which chef cooked that order
  private String whoDelivered; // Shows which couier delivered that order
  private int orderID = 0;
  private Customer c; // hangi customer sipariş verdi
  private double coefficient = 1.0;
  private double account = 0.0;

  private LinkedList<Food> foods_in_menu = new LinkedList<Food>();
  private LinkedList<Integer> foodID = new LinkedList<Integer>();

  Order(LinkedList<Integer> food, int orderID, Customer customer, Menu menu) {
    this.orderID = orderID;
    int i = 0;
    while (i < food.size()) {
      foodID.add(food.get(i));
      i++;
    }
    c = customer;
    foods_in_menu = menu.get_foods();
    calculate_account();
  }

  public Customer get_customer() {
    return c;
  }

  public String getWhoCooked(){
    return whoCooked;
  }

  public String getWhoDelivered(){
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
    for (int i = 0; i < foodID.size(); i++) {
      for (int j = 0; j < foods_in_menu.size(); j++) {
        if (foodID.get(i) == foods_in_menu.get(j).get_foodID()) {
          account += foods_in_menu.get(j).get_food_price();
        }
      }
    }
    account *= coefficient;
    return account;
  }

  public String toString() {
    StringBuilder stb = new StringBuilder();
    
    stb.append("\nOrder id: "+ orderID);
    stb.append("\nOrder price: "+ account);
    stb.append("\nOrdered foods:");
    
    for(int i:foodID)
      stb.append("\n"+Integer.toString(i));

    return stb.toString();
  }
}
