package src.test;

import src.user.*;
import src.restaurant.*;
import java.util.ArrayList;

public class TestCustomer {
    public static void testCustomer() {

        Restaurant kebelekCafe = new Restaurant();
        CustomLinkedList<Food> foods = kebelekCafe.createRandomFoods();

        Customer customer1 = new Customer(
            "Gojou",
            22,
            "Student",
            "gjj",
            "123",
            "+50112345678",
            500.12,
            null
        );

        Order testOrder = new Order(19,customer1,foods,"CUMHURİYET");

        ArrayList<String> allergies = new ArrayList<String>();
        allergies.add("nane");

        Customer customer2 = new Customer(
            "Zweig",
            62,
            "Author",
            "zwg",
            "123",
            "+5013232323",
            500.12,
            allergies
        );
        
        System.out.println("TESTING CUSTOMER METHODS...");
        System.out.println("\n\n");

        System.out.println("TESTING GET JOB NUMBER METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getJob() + "\n\n");

        System.out.println("TESTING GET PHONE NUMBER METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getPhoneNumber() + "\n\n");

        System.out.println("TESTING GET BUDGET NUMBER METHOD OF CUSTOMER CLASS...");
        System.out.println(customer1.getBudget() + "\n\n");
    
        System.out.println("TESTING GIVE ORDER NUMBER METHOD OF CUSTOMER CLASS...");
        //customer1.giveOrder(kebelekCafe,testOrder);

        System.out.println("TESTING SEE MENU NUMBER METHOD OF CUSTOMER CLASS...");
        //customer1.seeMenu();
        
    }
}
