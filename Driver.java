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
    
    
    kebelekCafe.getRandomCustomer().seeMenu();
    //Food food1 = new Food(10, food_name, food_price, food_type);
  }

}
