package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Restaurant {
    protected int income;
    protected int outcome;
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
/*
    public static String menu() { // see menu ?
        return  Menu.seeMenu();
        //return "empty";
    } // see menu
*/
    public void addFoodToMenu(Food food){
        this.menu.addFood(food);
    }

    public boolean deleteFood(int id){
       // return this.menu.delete_food(id);

    return false;
    }
    public  boolean deleteFood(Food food){
        //return this.menu.delete_food(food);
    return true;
    }



}
