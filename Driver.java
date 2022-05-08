import java.util.LinkedList;
import src.*;

public class Driver {

  public static void main(String[] args) {
    testCustomer();
  }

  public static void testCustomer() {
    Restaurant kebelekCafe = new Restaurant();
    Admin administrator = new Admin(
      kebelekCafe,
      "Fatih Erdogan",
      40,
      "gtu1234",
      "1234"
    );

    Customer customer = kebelekCafe.getRandomCustomer(1);
    Customer customer1 = kebelekCafe.getRandomCustomer(2);
    Chef chef = kebelekCafe.getRandomChef();
    Courier courier = kebelekCafe.getRandomCourier();

    for (int i = 0; i < 2; i++) {
      LinkedList<Food> foods = kebelekCafe.createRandomFoods();
      Order order = new Order(i, customer, foods);
      boolean isOrderSuccessfull = customer.giveOrder(kebelekCafe, order);
      if (isOrderSuccessfull) {
        order.setWhoCooked(chef);
        chef.addOrder(order);
        order.setWhoDelivered(courier);
        courier.addOrder(order);
        System.out.println(i + "th.order" + order.toString());
      }
    }

    for (int i = 0; i < 4; i++) {
      LinkedList<Food> foods = kebelekCafe.createRandomFoods();
      Order order = new Order(i, customer1, foods);
      boolean isOrderSuccessfull = customer1.giveOrder(kebelekCafe, order);
      if (isOrderSuccessfull) {
        order.setWhoCooked(chef);
        chef.addOrder(order);
        order.setWhoDelivered(courier);
        courier.addOrder(order);
        System.out.println(i + "th.order" + order.toString());
      }
    }
    System.out.println(courier);
    courier.deliverOrderToCustomer();
    System.out.println(courier);
  }

  public static void testAdmin() {
    Restaurant kebelekCafe = new Restaurant();
    Admin admin = new Admin(
      kebelekCafe,
      "Fatih Erdogan",
      40,
      "gtu1234",
      "1234"
    );
    System.out.println("TESTING ADMIN METHODS...");
    System.out.println("\n\n");
    System.out.println("TESTING SHOW WORKERS INFO METHOD...");
    admin.showWorkersInfo();
    System.out.println("\n\n");
    System.out.println("TESTING SHOW CUSTOMERS INFO METHOD...");
    admin.showCustomersInfo();
  }
}
