import java.util.LinkedList;

import src.*;

public class Driver {

  public static void main(String[] args) {
    Restaurant kebelekCafe = new Restaurant();
    Admin administrator = new Admin(
        kebelekCafe,
        "Fatih Erdogan",
        40,
        "gtu1234",
        "1234");
    
    
    Customer aCustomer = kebelekCafe.getRandomCustomer();
    aCustomer.seeMenu();
    LinkedList<Food> testFoods = kebelekCafe.createRandomFoods();
    Order anOrder = new Order(7,aCustomer,testFoods);
    aCustomer.giveOrder(kebelekCafe,anOrder);
  }

}
