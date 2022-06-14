package src.demo;

import java.util.Scanner;

import src.auth.Authentication;
import src.restaurant.Food;
import src.restaurant.Order;
import src.user.Chef;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DemoChef {
	public static void demoChef() {
		Scanner scan = new Scanner(System.in);
        int operation;
        Chef chef;
        while(true) {
            try {
                System.out.println("======================================");
                System.out.println("\nPlease select an operation\n");
                System.out.println("1-> Login system as chef");
                System.out.println("0-> Go top menu");
                System.out.print("\nEnter the operation : ");
                operation = Integer.parseInt(scan.nextLine());
                switch(operation) {
                    case 1:
                    	chef = (Chef) Authentication.login();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println(operation +" is not a valid value");
                }
            }catch(NumberFormatException e) {
                System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type");
            }catch(NoSuchElementException e) {
                System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type");
            }
            catch(NullPointerException e) {
                System.out.println("\n\n" + "There is no such user. \nPlease enter the valid Information");
            }

        }
    }

    private static void chefAuthority(Chef chef, Order order){
        int operation;
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("======================================");
                System.out.println("\nWelcome Mr/Mrs " + chef.getName());
                System.out.println("Please select following operation\n");
                System.out.println("1-> Add Order");
                System.out.println("2-> Prepare Order");
                System.out.println("3-> Show My Information");


                System.out.println("0-> Log out the account");
                System.out.print("\nEnter the operation :");
                operation = Integer.parseInt(scan.nextLine());


                switch (operation) {

                    case 1:
                        chef.addOrder(order);
                        System.out.println("Order is added");

                        break;
                    case 2:
                        chef.prepareOrder();
                        System.out.println();

                        break;
                    case 3:
                        System.out.println(chef);
                        break;
                    case 0:
                        scan.close();
                        return;
                    default:
                        System.out.println("\nPlease, Enter a valid authority number");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nThe entered type is wrong,\nPlease enter the valid");
            } catch (NoSuchElementException e) {
                System.out.println("\nThe entered type is wrong,\nPlease enter the valid type");

            }
        }
    }
}

