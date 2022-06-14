package src.test;

import src.user.*;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.*;
import java.util.ArrayList;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;

/**
 * Automated class for to test out customer class function
 * @author Group 2
 */
public class TestCustomer {
    public static void testCustomer() {
        Restaurant kebelekCafe = new Restaurant();
        Menu menu = new Menu();
        Customer customer1 = kebelekCafe.getTestCustomer();
        System.out.println(customer1);
        CustomLinkedList<Food> foods = new CustomLinkedList<>();  

        Order order = new Order(1, customer1, foods, "CUMHURIYET");

        System.out.println("TESTING CUSTOMER METHODS...");
        System.out.println("\n\n");

        System.out.println("TESTING GET JOB METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getJob() + "\n\n");

        System.out.println("TESTING GET PHONE NUMBER METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getPhoneNumber() + "\n\n");

        System.out.println("TESTING GET BUDGET METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getBudget() + "\n\n");
        
        String IDs = "1 10 15 24 32 25";
        String[] foodIDs = IDs.split(" ");
        for (String id : foodIDs) {
            Food food = menu.getFood(Integer.parseInt(id));
            if (food != null) {
              foods.add(food);
            }
          }

        System.out.println("TESTING GIVE ORDER METHOD OF CUSTOMER CLASS...");
        customer1.giveOrder(kebelekCafe, order);
        System.out.println("\n\n");

        System.out.println("TESTING TAKE ORDER METHOD OF CUSTOMER CLASS...");
        customer1.takeOrder(order);
        System.out.println("\n\n");

        System.out.println("TESTING TO STRING METHOD OF CUSTOMER CLASS...");
        System.out.print(customer1.toString() + "\n\n");

        System.out.println("TESTING ORDER HISTORY METHOD OF CUSTOMER CLASS...");
        System.out.print(customer1.orderHistory() + "\n\n");

        System.out.println("TESTING SEE MENU METHOD OF CUSTOMER CLASS...");
        customer1.seeMenu();
        
    }
}
