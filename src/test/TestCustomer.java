package src.test;

import src.user.*;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.*;
import java.util.ArrayList;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;

public class TestCustomer {
    public static void testCustomer() {
        Restaurant kebelekCafe = new Restaurant();
        Menu menu = new Menu();
        Customer customer1 = kebelekCafe.getTestCustomer();
        System.out.println(customer1);
        CustomLinkedList<Food> foods = new CustomLinkedList<>();  

        System.out.println("TESTING CUSTOMER METHODS...");
        System.out.println("\n\n");

        System.out.println("TESTING GET JOB NUMBER METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getJob() + "\n\n");

        System.out.println("TESTING GET PHONE NUMBER METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getPhoneNumber() + "\n\n");

        System.out.println("TESTING GET BUDGET NUMBER METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getBudget() + "\n\n");
        
        String IDs = "1 10 15 24";
        String[] foodIDs = IDs.split(" ");
        for (String id : foodIDs) {
            Food food = menu.getFood(Integer.parseInt(id));
            if (food != null) {
              foods.add(food);
            }
          }

        System.out.println("TESTING GIVE ORDER NUMBER METHOD OF CUSTOMER CLASS...");
        customer1.giveOrder(kebelekCafe, new Order(1, customer1, foods, "CUMHURIYET"));

        System.out.println("TESTING SEE MENU NUMBER METHOD OF CUSTOMER CLASS...");
        //customer1.seeMenu();
        
    }
}
