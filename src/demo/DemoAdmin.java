package src.demo;

import src.auth.Authentication;
import src.user.Admin;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DemoAdmin {

    public static void adminDemo(){
        Scanner scan = new Scanner(System.in);
        int operation;
        Admin admin;
        while(true) {
            try {
                System.out.println("======================================");
                System.out.println("\nPlease select an operation\n");
                System.out.println("1-> Login system as admin");
                System.out.println("0-> Go top menu");
                System.out.print("\nEnter the operation : ");
                operation = Integer.parseInt(scan.nextLine());
                switch(operation) {
                    case 1:
                        admin = (Admin)Authentication.login();
                        adminAuthority(admin);

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

    private static void adminAuthority(Admin admin){

    }


}
