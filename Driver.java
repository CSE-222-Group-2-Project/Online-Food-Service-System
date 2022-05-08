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
      "1234"
    );

    Customer customer = kebelekCafe.getRandomCustomer();
    Chef chef = kebelekCafe.getRandomChef();
    Courier courier = kebelekCafe.getRandomCourier();
    LinkedList<Food> foods = kebelekCafe.createRandomFoods();

    Order order = new Order(0, customer, foods);
    Boolean isOrderSuccessfull = customer.giveOrder(kebelekCafe, order);
    if (isOrderSuccessfull) {
      order.setWhoCooked(chef);
      order.setWhoDelivered(courier);
    }
    System.out.println(order.toString());
  }
}
