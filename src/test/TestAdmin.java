package src.test;

import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Restaurant;
import src.user.Admin;
import src.user.Worker;

public class TestAdmin {

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
    System.out.println("TESTING SHOW CUSTOMER OF THE MONTH...");
    admin.customerOfTheMonth();
    System.out.println("\n\n");
    System.out.println("TESTING TO STRING METHOD OF ADMIN CLASS...");
    System.out.println(admin.toString());
  }
}
