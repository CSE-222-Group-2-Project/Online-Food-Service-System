package src;

import java.util.ArrayList;

public class Restaurant {
    private int income;
    private int outcome;
    private ArrayList<Order> orders; // Linkedlist şeklinde depolanacak
    private ArrayList<Order> ordersPrepared; // Linkedlist şeklinde depolanacak
    private float score;
    private int numberofScores;
    private Menu menu;
    protected ArrayList<Worker> workers;
    protected ArrayList<Customer> customers;


    public void Restaurant() {
        
    }

    public void inputScore(int score) {
        if( score > 5 || score < 0 )
            return;
        
        float temp =  this.score*numberofScores;
        this.score = (temp+score)/(++numberofScores);         
    }

    public void getOrder( Order obj ){
        orders.add(obj);
    }

    public void sendChef( Order order) {

    }

    public void sendCourier() {

    }

    public void directingInterface() {

    }

    public ArrayList<Worker> getWorkers()
    {
        return workers;
    }

    public String menu() {
        return "empty";
    }

}
