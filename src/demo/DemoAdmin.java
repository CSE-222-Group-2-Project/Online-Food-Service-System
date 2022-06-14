package src.demo;

import src.auth.Authentication;
import src.user.Admin;
import src.user.Worker;

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
       /* int operation,index;
        Scanner scan = new Scanner(System.in);
        while(true) {
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
                System.out.println("8-> Create Menu");
                System.out.println("9-> Add Food to The Menu");
                System.out.println("10-> Delete Food from Menu");
                System.out.println("11-> See the Menu");
                System.out.println("0-> Log out the account");
                System.out.print("\nEnter the operation :");
                operation = Integer.parseInt(scan.nextLine());;

                switch(operation){

                    case 1:
                        admin.showWorkersInfo();
                        break;
                    case 2:
                        admin.showCustomersInfo();
                        break;
                    case 3:
                        admin.printIncomeAndOutcome();
                        break;
                    case 4:


                        System.out.print("Enter the Worker Name : ");

                        admin.hiringWorker();

                        break;
                    case 5:		admin.displayBranchs();
                        break;
                    case 6:		for(int i = 0; i<admin.getBranchNumber(); ++i) {
                        System.out.println("Branch name : " + admin.getBranch(i).getName());
                        System.out.println("   Employess:");
                        admin.getBranch(i).displayEmployees();
                    }
                        break;
                    case 7:		int type = datas.chooseTypeProduct();
                        Furniture furniture = datas.getProduct(type);
                        if(furniture != null)
                            System.out.println(furniture  + ": " + admin.queryProduct(furniture));
                        else
                            System.out.println("Undefined furniture type");
                        break;
                    case 8:		Admin.displayMessages();
                        break;
                    case 9:		Admin.clearMessages();
                        System.out.println("Messages are deleted");
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("\nPlease, Enter a valid authority number");
                }
            }catch(NumberFormatException e) {
                System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type line : 172");
            }catch(NoSuchElementException e) {
                System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type line : 174");
            }catch(ArrayIndexOutOfBoundsException  e) {
                System.out.println("Out of bound exceprion. You entered unvalid index");
            }catch(NullPointerException e) {
                System.out.println("Be sure that enter valid index for branch");
            }
        }*/
    }


}
