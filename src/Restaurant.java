package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Restaurant {

  protected int income;
  protected int outcome;
  private LinkedList<Order> orders; // Linkedlist şeklinde depolanacak
  private LinkedList<Order> ordersPrepared; // Linkedlist şeklinde depolanacak
  private float score;
  private int numberofScores;
  private static Menu menu;
  protected ArrayList<Worker> workers;
  protected ArrayList<Customer> customers;

  public void Restaurant() {
    workers = Authentication.getWorkersFromDatabase();
    customers = Authentication.getCustomersFromDatabase();
    menu = new Menu(Authentication.getMenuFromDatabase());
  }

  public void inputScore(int score) {
    if (score > 5 || score < 0) return;

    float temp = this.score * numberofScores;
    this.score = (temp + score) / (++numberofScores);
  }

  public void getOrder(Order obj) {
    orders.add(obj);
  }

  public void sendChef() {
    // Azizcan bu comment önemli silme :D
    // chefleri arraylistte tutuyoruz ya mesela 3 tane chefden hangisini seçeceğimizi random yaparsın
  }

  public void sendCourier() {
    // Azizcan bu comment önemli silme :D
    // kuryeleri arraylistte tutuyoruz ya mesela 3 tane kuryeden hangisini seçeceğimizi random yaparsın
  }

  public ArrayList<Worker> getWorkers() {
    return workers;
  }

  public void showWorkers() {}

  public static String menu() {
    return menu.toString();
  }

  public boolean deleteFoodFromMenu(int id) {
    LinkedList<Food> temp = this.menu.get_foods();
    for (Food food : temp) {
      if (food.getFoodID() == id) {
        temp.remove(food);
        return true;
      }
    }
    return false;
  }

  public boolean deleteFoodFromMenu(Food food) {
    return this.menu.get_foods().remove(food);
  }

  public void addFoodtoMenu(Food food) {
    this.menu.get_foods().add(food);
  }

  public void createNewMenu(Menu menu) {
    this.menu = menu;
  }

  @Override
  public String toString() {
    StringBuilder restaurantInfo = new StringBuilder();
    restaurantInfo.append("Restaurant Info:\n");
    restaurantInfo.append("Income: " + this.income + "\n");
    restaurantInfo.append("Outcome: " + this.outcome + "\n");
    restaurantInfo.append("Score: " + this.score + "\n");
    restaurantInfo.append("Number of Scores: " + this.numberofScores + "\n");
    restaurantInfo.append("Menu: " + this.menu.toString() + "\n");
    restaurantInfo.append("Workers: " + this.workers.toString() + "\n");
    restaurantInfo.append("Customers: " + this.customers.toString() + "\n");
    return restaurantInfo.toString();
  }
}
