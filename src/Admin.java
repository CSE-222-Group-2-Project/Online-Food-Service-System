package src;

import java.util.ArrayList;

/**
 * Admin classı restauranttan extend edilmesse her methodta parametere olarak almak gerekiyor??
 */

public class Admin extends User{

    private Restaurant restaurant;

    public Admin(Restaurant restaurant, String name, int age, String username, String password){
        super(name,age,username,password);
        this.restaurant = restaurant;
    }

    public Admin(){
        super();
    }    

    //Username ve password bastırmadım 
    public void showWorkersInfo(){
    
        for (Worker worker : restaurant.workers) {

            System.out.println("Job: " + worker.getJob());
            System.out.println("Name: " + worker.getName());
            System.out.println("Age: " + worker.getAge());

            if(worker instanceof Chef)
                System.out.println("Certification Number: "+ ((Chef)worker).getCertificateNumber());
            System.out.println("---------------");
        }
    }

    public void showCustomersInfo(){
    
        for (Customer customer : restaurant.customers)
        {

            System.out.println("Name: " + customer.getName());
            System.out.println("Job: " + customer.getJob());
            System.out.println("Age: " + customer.getAge());
            System.out.println("Balance: " + customer.getBalance());
            System.out.println("Last Order number: " + customer.getOrderNumber());
            System.out.println("Phone Number: " + customer.getPhone());
            System.out.println("---------------");;
        }
    }

    public void income_outcome(){

        System.out.println("The total income is " + restaurant.income);
        System.out.println("The total outcome is " + restaurant.outcome);
        System.out.println("The profit is " + (restaurant.income - restaurant.outcome));
    }

    public boolean fireWorker(Worker firedWorker)
    {
        if(firedWorker.getScore() < 10)
        {
            System.out.println(firedWorker.getName() + " has been fired with " + firedWorker.getScore() + " score.");
            restaurant.workers.remove(firedWorker);
            return true;
        }
        else 
            return false;
    }

    //Update all salaries 
    
    public void EditSalary()
    {
        
        for (Worker worker : restaurant.workers) {
            
            if(worker.getScore() > 50) // Çalışanın scoru 50 üzerine çıkarsa -> score%10 * 100 * ExperienceYear, salaryiye eklenir  
                                       //ve scoru ilk haline getitir sürekli zam yapmamış olmak için

            {   
                 worker.setSalary(worker.getSalary() +  worker.getExperienceYear() * 100 * (worker.getScore() % 10)) ;    
                 worker.setScore(30);
            }
            else;
        }

    }






}
