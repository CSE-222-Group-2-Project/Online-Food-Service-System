package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Restaurant {

  protected int income;
  protected int outcome;
  protected LinkedList<Order> orders;
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
  }

  public Customer getRandomCustomer() {
    Random rand = new Random();
    return customers.get(rand.nextInt(customers.size()));
  }

  public LinkedList<Food> createRandomFoods() {
    Random rand = new Random();
    LinkedList<Food> foods = menu.get_foods();
    LinkedList<Food> orderFoods = new LinkedList<>();

    for (int i = 0; i < 4; i++) {
      int randomNumber = rand.nextInt(foods.size());
      orderFoods.add(foods.get(randomNumber));
    }

    return orderFoods;
  }

  public double calculateScore() {
    double score = 0;

    for (Worker anworker : workers) score += anworker.getScore();

    return score / workers.size();
  }

  public void addOrder(Order order) {
    orders.addLast(order);
    income += order.getAccount();
  }

  public Chef chooseChef(Order order) {
    if (order == null) return null;

    int workerId = 0, minOrder = 0;

    for (int i = 0; i < workers.size(); i++) {
      if (workers.get(i) instanceof Chef) {
        if (minOrder >= ((Chef) workers.get(i)).getSizeOfOrders()) {
          minOrder = ((Chef) workers.get(i)).getSizeOfOrders();
          workerId = i;
        }
      }
    }

    ((Chef) workers.get(workerId)).addOrder((order));

    return (Chef) workers.get(workerId);
  }

  public Courier chooseCourier(Order order) {
    if (order == null) return null;

    int workerId = 0, minOrder = 0;

    for (int i = 0; i < workers.size(); i++) {
      if (workers.get(i) instanceof Courier) {
        //if (minOrder >= ((Courier) workers.get(i)).getSizeOfOrders()) {
        // minOrder = ((Courier) workers.get(i)).getSizeOfOrders();
        // workerId = i;
        // }
        workerId = i;
        break;
      }
    }
    ((Courier) workers.get(workerId)).addOrder(order);
    return (Courier) workers.get(workerId);
  }

  public ArrayList<Worker> getWorkers() {
    return workers;
  }

  public void showWorkers() {
    for (int i = 0; i < workers.size(); i++) {
      System.out.println(workers.toString());
    }
  }

  /**
   * `menu()` returns a string representation of the menu
   *
   * @return The menu is being returned.
   */
  public static String menu() {
    return menu.toString();
  }

  /**
   * > This function deletes a food from the menu by iterating through the menu and removing the food with the given id
   *
   * @param id the id of the food to be deleted
   * @return A boolean value.
   */
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

  /**
   * This function removes a food from the menu
   *
   * @param food The food to be deleted from the menu.
   * @return A boolean value.
   */
  public boolean deleteFoodFromMenu(Food food) {
    return this.menu.get_foods().remove(food);
  }

  /**
   * This function adds a food to the menu
   *
   * @param food The food object to be added to the menu
   */
  public void addFoodtoMenu(Food food) {
    this.menu.get_foods().add(food);
  }

  /**
   * This function creates a new menu.
   *
   * @param menu The menu object that you want to create.
   */
  public void createNewMenu(Menu menu) {
    this.menu = menu;
  }

  /**
   * The function returns a string that contains the restaurant's income, outcome, score, menu, workers, and customers
   *
   * @return The restaurant's information.
   */
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
