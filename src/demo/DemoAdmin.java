package src.demo;

import src.auth.Authentication;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Restaurant;
import src.user.Admin;
import src.user.Worker;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DemoAdmin {

    public static void adminDemo(Restaurant restaurant){
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
                        adminAuthority(admin,restaurant);

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

    private static void adminAuthority(Admin admin,Restaurant restaurant) {
        int operation, index;
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("======================================");
                System.out.println("\nWelcome Mr/Mrs " + admin.getName());
                System.out.println("Please select following operation\n");
                System.out.println("1-> Show Workers Information");
                System.out.println("2-> Show Customers Information");
                System.out.println("3-> Show Income and Outcome");
                System.out.println("4-> Hire Worker");
                System.out.println("5-> Fire Worker");
                System.out.println("6-> Edit Salary");
                System.out.println("7-> Show All Orders");
                System.out.println("8-> Add Food to Menu");
                System.out.println("9-> Delete Food from Menu");
                System.out.println("10-> See the Menu");
                System.out.println("11-> See the Month of The Customer");

                System.out.println("0-> Log out the account");
                System.out.print("\nEnter the operation :");
                operation = Integer.parseInt(scan.nextLine());
                ;

                switch (operation) {

                    case 1:
                        admin.showWorkersInfo();
                        System.out.println();
                        break;
                    case 2:
                        admin.showCustomersInfo();
                        System.out.println();

                        break;
                    case 3:
                        admin.printIncomeAndOutcome();
                        System.out.println();

                        break;
                    case 4:

                        //admin.hiringWorker();
                        System.out.println();

                        break;
                    case 5:
                        admin.fireWorker();
                        System.out.println();

                        break;
                    case 6:
                        admin.editSalary();
                        System.out.println();

                        break;
                    case 7:
                        admin.printAllOrders();
                        System.out.println();

                        break;
                    case 8:

                        try {
                            int foodID;
                            String foodName, foodType;
                            double foodPrice;

                            System.out.print("Enter Food Name : ");
                            foodName = scan.nextLine();
                            System.out.print("Enter Food Price : ");
                            foodPrice = Double.parseDouble(scan.nextLine());
                            System.out.print("Enter Food Type : ");
                            foodType = scan.nextLine();
                            System.out.print("Enter Food Id : ");
                            foodID = Integer.parseInt(scan.nextLine());
                            admin.addFoodToMenu(new Food(foodID, foodName, foodPrice, foodType));
                        } catch (NumberFormatException e) {
                            System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type");
                        } catch (NoSuchElementException e) {
                            System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type");
                        }
                        break;
                    case 9:
                        Integer foodId;
                        System.out.print("Enter Food Id : ");
                        foodId = Integer.parseInt(scan.nextLine());
                        if (admin.deleteFoodFromMenu(foodId)) {
                            System.out.println("Food is deleted from menu");
                        } else System.out.println("Food is not found in menu");

                        break;
                    case 10:
                        admin.seeMenu();
                        break;
                    case 11:
                        admin.customerOfTheMonth();
                        break;

                    case 0:
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
