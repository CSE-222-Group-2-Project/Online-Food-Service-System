package src.demo;

import java.util.Scanner;

import src.auth.Authentication;
import src.user.Courier;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DemoCourier {
	public static void demoCourier() {
		Scanner scan = new Scanner(System.in);
        int operation;
        Courier courier;
        while(true) {
            try {
                System.out.println("======================================");
                System.out.println("\nPlease select an operation\n");
                System.out.println("1-> Login system as courier");
                System.out.println("0-> Go top menu");
                System.out.print("\nEnter the operation : ");
                operation = Integer.parseInt(scan.nextLine());
                switch(operation) {
                    case 1:
                    	courier = (Courier) Authentication.login();
                        break;
                    case 0:
                        //return;
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
}

