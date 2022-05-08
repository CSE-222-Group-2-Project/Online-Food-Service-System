import java.util.LinkedList;
import src.*;

public class Driver {

  public static void main(String[] args) {
    testProgram();
    testAdmin();
  }

  public static void testProgram() {
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
    System.out.println("\n\n");
    System.out.println("TESTING PRINT INCOME AND OUTCOME METHOD...");
    admin.printIncomeAndOutcome();
    System.out.println("\n\n");
    System.out.println("TESTING PRINT ALL ORDERS METHOD...");
    admin.printAllOrders();
    System.out.println("\n\n");
    System.out.println("TESTING FIRE WORKER METHOD");
    admin.fireWorker();
    System.out.println("\n\n");
    System.out.println("TESTING HIRING WORKER METHOD...");
    admin.hiringWorker(new Worker("Test", 20, "test12", "testpass"_, "student", 2));
    System.out.println("\n\n");
    System.out.println("TESTING EDIT SALARY METHOD...");
    admin.editSalary();
    System.out.println("\n\n");
    System.out.println("TESTING CREATE FOOD METHOD...");

  }
}
