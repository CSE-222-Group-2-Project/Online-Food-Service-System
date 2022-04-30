package src;

import java.util.ArrayList;

/**
 * Admin classı restauranttan extend edilmesse her methodta parametere olarak almak gerekiyor??
 */

public class Admin {

    String fullName;
    String password;


    public Admin(String fullName, String password){
        this.fullName = fullName;
        this.password = password;
    }

    public Admin(){
        this.fullName = "Administrator" ;
        this.password = "admin";
    }    


    //Username ve password bastırmadım 
    public void showWorkersInfo(Restaurant restaurant){
    
        ArrayList<Worker> workers = restaurant.workers;
        for (int i = 0; i < workers.size(); i++) {

            System.out.println("Job: " + workers.get(i).getJob());
            System.out.println("Name: " + workers.get(i).getName());
            System.out.println("Age: " + workers.get(i).getAge());

            if(workers.get(i) instanceof Chef)
                System.out.println("Certification Number: "+ ((Chef)workers.get(i)).getCertificateNumber());
            System.out.println("---------------");
        }
    }

    public void showCustomersInfo(Restaurant restaurant){
    
        ArrayList<Customer> customers = restaurant.customers;
        for (int i = 0; i < customers.size(); i++) {

            System.out.println("Name: " + customers.get(i).getName());
            System.out.println("Job: " + customers.get(i).getJob());
            System.out.println("Age: " + customers.get(i).getAge());
            System.out.println("Balance: " + customers.get(i).getBalance());
            System.out.println("Last Order number: " + customers.get(i).getOrderNumber());
            System.out.println("Phone Number: " + customers.get(i).getPhone());
            System.out.println("---------------");;
        }
    }

    public void income_outcome(Restaurant restaurant){

        System.out.println("The total income is " + restaurant.income);
        System.out.println("The total outcome is " + restaurant.outcome);
        System.out.println("The profit is " + (restaurant.income - restaurant.outcome));
    }

    





}
