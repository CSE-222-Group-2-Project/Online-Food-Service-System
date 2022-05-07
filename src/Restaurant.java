package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Restaurant {

  protected int income;
  protected int outcome;
  private LinkedList<Order> orders;
  private double score;
  private static Menu menu;
  protected ArrayList<Worker> workers;
  protected ArrayList<Customer> customers;

  public Restaurant() {
    workers = Authentication.getWorkersFromDatabase();
    customers = Authentication.getCustomersFromDatabase();
    menu = new Menu(Authentication.getMenuFromDatabase());
    orders = new LinkedList<>();
    score = calculateScore();
    income = 0;
    outcome = 10000;

    System.out.println(customers.size());
    for(Customer ancustomer : customers)
      System.out.println(ancustomer.getName());
  }

  public Customer getRandomCustomer() {
    Random rand = new Random();
    System.out.println(customers.size());
    return customers.get(rand.nextInt(customers.size()));
  }

  public double calculateScore() {
    double score = 0;

    for (Worker anworker : workers) score += anworker.getScore();

    return score / workers.size();
  }

  public void addOrder(Order order) {
    orders.addLast(order);
    sendChef(order);
    sendCourier(order);
  }

  public void sendChef(Order order) {
    int workerId = 0, minOrder = 0;

    for (int i = 0; i < workers.size(); i++) {
      if (workers.get(i) instanceof Courier) {
        if (minOrder >= ((Chef) workers.get(i)).getSizeOfOrders()) {
          minOrder = ((Chef) workers.get(i)).getSizeOfOrders();
          workerId = i;
        }
      }
    }

    ((Chef) workers.get(workerId)).addOrder((order));
  }

  public void sendCourier(Order order) {
    for (int i = 0; i < workers.size(); i++) {
      if (workers.get(i) instanceof Courier) {
        if (((Courier) workers.get(i)).isOrdersEmpty()) {
          ((Courier) workers.get(i)).addOrder(order);
        }
      }
    }
  }

  public ArrayList<Worker> getWorkers() {
    return workers;
  }

  public void showWorkers() {
    for (int i = 0; i < workers.size(); i++) {
      System.out.println(workers.toString());
    }
  }

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
    restaurantInfo.append("Menu: " + this.menu.toString() + "\n");
    restaurantInfo.append("Workers: " + this.workers.toString() + "\n");
    restaurantInfo.append("Customers: " + this.customers.toString() + "\n");
    return restaurantInfo.toString();
  }
}
