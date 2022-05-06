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
        // Azizcan bu comment önemli silme :D
        // chefleri arraylistte tutuyoruz ya mesela 3 tane chefden hangisini seçeceğimizi random yaparsın
    }

    public void sendCourier() {
        // Azizcan bu comment önemli silme :D
        // kuryeleri arraylistte tutuyoruz ya mesela 3 tane kuryeden hangisini seçeceğimizi random yaparsın
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



    public boolean deleteFoodFromMenu(int id){
        LinkedList<Food> temp = this.menu.get_foods();
        for (Food food:
                temp) {
            if(food.get_foodID() == id){
                temp.remove(food);
                return  true;
            }
        }
        return false;
    }

    public boolean deleteFoodfromMenu(Food food){

        return this.menu.get_foods().remove(food);

    }
    public void addFoodtoMenu(Food food){
        this.menu.get_foods().add(food);
    }

    public void createMenu(Menu menu){
        this.menu = menu;
    }

}
