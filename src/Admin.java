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

    public void fireWorker()
    {
        
        for (Worker worker : restaurant.workers) {
    
            if( worker.getVoteAmount() > 10 && worker.getScore() / worker.getVoteAmount() < 4 ) // sipariş sayısı 10 dan fazlaysa ve puanı 4 den düşükse kov
            {   
                System.out.println(worker.getName() + " has been fired with " + worker.getScore()/worker.getVoteAmount() + " score.");
                restaurant.workers.remove(worker);
            }
            else;
        }
    

    }

    //Update all salaries 
    public void EditSalary()
    {
        //değişecek
        for (Worker worker : restaurant.workers) {
            
            if(worker.getScore()/worker.getVoteAmount() > 8) // Çalışanın scoru 8 üzerine çıkarsa -> score * 100 * ExperienceYear, salaryiye eklenir ??  
                                       
            {   
                 worker.setSalary(worker.getSalary() +  worker.getExperienceYear() * 100 * (worker.getScore()/worker.getVoteAmount())) ;    
                 worker.setScore(4); // scoru sıfırlamak gerekebilir??
            }
            else;
        }

    }






}
