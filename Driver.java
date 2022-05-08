import java.util.ArrayList;
import java.util.LinkedList;
import src.*;
import src.tree.BinarySearchTree;

public class Driver {

  public static void main(String[] args) {
    testFor10Inputs();
    testFor100Inputs();
    testFor1000Inputs();
  }

  public static void testFor10Inputs() {
    Restaurant kebelekCafe = new Restaurant();

    Customer customer = kebelekCafe.getRandomCustomer(1);
    Chef chef = kebelekCafe.getRandomChef();
    Courier courier = kebelekCafe.getRandomCourier();
    Authentication auth = new Authentication();
    ArrayList<Order> orders = new ArrayList<Order>();
    long startTime, endTime, totalTime;
    for (int i = 0; i < 10; i++) {
      LinkedList<Food> foods = kebelekCafe.createRandomFoods();
      Order order = new Order(i, customer, foods);
      orders.add(order);
    }
    System.out.println("\nTESTING MAIN DATA STRUCTURE METHODS FOR 10 INPUTS");

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      auth.createUser(new User("test", 10, "a" + i + ".th", "pass"));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "BST createUser() Method For 10 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      customer.giveOrder(kebelekCafe, orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Customer giveOrder() Method For 10 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      chef.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef addOrder() Method For 10 Inputs Time: " + totalTime
    );

    for (int i = 0; i < 10; i++) {
      chef.prepareOrder();
    }

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      courier.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier addOrder() Method For 10 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      courier.deliverOrderToCustomer();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier deliverOrderToCustomer() Method For 10 Inputs Time: " + totalTime
    );
  }

  public static void testFor100Inputs() {
    Restaurant kebelekCafe = new Restaurant();

    Customer customer = kebelekCafe.getRandomCustomer(1);
    Chef chef = kebelekCafe.getRandomChef();
    Courier courier = kebelekCafe.getRandomCourier();
    Authentication auth = new Authentication();
    ArrayList<Order> orders = new ArrayList<Order>();
    long startTime, endTime, totalTime;
    for (int i = 0; i < 100; i++) {
      LinkedList<Food> foods = kebelekCafe.createRandomFoods();
      Order order = new Order(i, customer, foods);
      orders.add(order);
    }

    System.out.println("\nTESTING MAIN DATA STRUCTURE METHODS FOR 100 INPUTS");

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      auth.createUser(new User("test", 10, "b" + i + ".th", "pass"));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "BST createUser() Method For 100 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      customer.giveOrder(kebelekCafe, orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Customer giveOrder() Method For 100 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      chef.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef addOrder() Method For 100 Inputs Time: " + totalTime
    );

    for (int i = 0; i < 100; i++) {
      chef.prepareOrder();
    }

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      courier.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier addOrder() Method For 100 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      courier.deliverOrderToCustomer();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier deliverOrderToCustomer() Method For 100 Inputs Time: " +
      totalTime
    );
  }

  public static void testFor1000Inputs() {
    Restaurant kebelekCafe = new Restaurant();

    Customer customer = kebelekCafe.getRandomCustomer(1);
    Chef chef = kebelekCafe.getRandomChef();
    Courier courier = kebelekCafe.getRandomCourier();
    Authentication auth = new Authentication();
    ArrayList<Order> orders = new ArrayList<Order>();
    long startTime, endTime, totalTime;
    for (int i = 0; i < 1000; i++) {
      LinkedList<Food> foods = kebelekCafe.createRandomFoods();
      Order order = new Order(i, customer, foods);
      orders.add(order);
    }

    System.out.println("\nTESTING MAIN DATA STRUCTURE METHODS FOR 1000 INPUTS");

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      auth.createUser(new User("test", 10, "c" + i + ".th", "pass"));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "BST createUser() Method For 1000 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      customer.giveOrder(kebelekCafe, orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Customer giveOrder() Method For 1000 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      chef.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Chef addOrder() Method For 1000 Inputs Time: " + totalTime
    );

    for (int i = 0; i < 1000; i++) {
      chef.prepareOrder();
    }

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      courier.addOrder(orders.get(i));
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier addOrder() Method For 1000 Inputs Time: " + totalTime
    );

    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      courier.deliverOrderToCustomer();
    }
    endTime = System.nanoTime();
    totalTime = (endTime - startTime) / 100;
    System.out.println(
      "Courier deliverOrderToCustomer() Method For 1000 Inputs Time: " +
      totalTime
    );
  }

  public static void testAdminMethods() {
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
    System.out.println("TESTING SHOW WORKERS INFO METHOD OF ADMIN CLASS...");
    admin.showWorkersInfo();
    System.out.println("\n\n");
    System.out.println("TESTING SHOW CUSTOMERS INFO METHOD OF ADMIN CLASS...");
    admin.showCustomersInfo();
    System.out.println("\n\n");
    System.out.println(
      "TESTING PRINT INCOME AND OUTCOME METHOD OF ADMIN CLASS..."
    );
    admin.printIncomeAndOutcome();
    System.out.println("\n\n");
    System.out.println("TESTING PRINT ALL ORDERS METHOD OF ADMIN CLASS...");
    admin.printAllOrders();
    System.out.println("\n\n");
    System.out.println("TESTING FIRE WORKER METHOD OF ADMIN CLASS");
    admin.fireWorker();
    System.out.println("\n\n");
    System.out.println("TESTING HIRING WORKER METHOD OF ADMIN CLASS...");
    admin.hiringWorker(
      new Worker("Ahmet", 30, "ahmet", "gtu1234", "student", 3)
    );
    System.out.println("\n\n");
    System.out.println("TESTING EDIT SALARY METHOD...");
    admin.editSalary();
    System.out.println("\n\n");
    System.out.println("TESTING CREATE FOOD METHOD OF ADMIN CLASS...");
    admin.createFood(3, "cacık", 15, "corba");
    System.out.println("\n\n");
    System.out.println("TESTING ADD FOOD TO MENU METHOD OF ADMIN CLASS...");
    admin.addFoodToMenu(new Food(3, "cacık", 15, "corba"));
    System.out.println("\n\n");
    System.out.println(
      "TESTING DELETE FOOD FROM MENU BY FOOD OBJECT METHOD OF ADMIN CLASS..."
    );
    admin.deleteFoodFromMenu(new Food(3, "cacık", 15, "corba"));
    System.out.println("\n\n");
    System.out.println("TESTING DELETE FOOD FROM MENU BY FOOD ID METHOD...");
    admin.deleteFoodFromMenu(3);
    System.out.println("\n\n");
    System.out.println("TESTING CREATE MENU METHOD OF ADMIN CLASS...");
    admin.createMenu(new Menu());
    System.out.println("\n\n");
    System.out.println("TESTING SEE MENU METHOD OF ADMIN CLASS...");
    admin.seeMenu();
    System.out.println("\n\n");
    System.out.println("TESTING TO STRING METHOD OF ADMIN CLASS...");
    System.out.println(admin.toString());
  }

  public static void testAuthenticationMethods() {
    System.out.println("TESTING AUTHENTICATION CLASS...");
    System.out.println("TESTING LOGIN METHOD OF AUTHENTICATION CLASS...");
    User loginedUser = Authentication.logIn(
      "Eren",
      24,
      "erencour",
      "mikasa123"
    );
    System.out.println(loginedUser);
  }
}
