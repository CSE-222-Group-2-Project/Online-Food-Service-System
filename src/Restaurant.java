package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import src.skiplist.SkipList;

/**
 *  This class represents the Restaurant in the system.
 * @author Group 2
 * @version 1.0.0
 * @since 08.04.2022
 */

/**
 * This class represents the Restaurant in the system.
 */
public class Restaurant {

  // Data Fields
  /** income of the restaurant */
  protected int income;
  /** outcome of the restaurant */
  protected int outcome;
  /** the list of the orders in the restaurant */
  protected LinkedList<Order> orders;
  private double score;
  private static Menu menu;
  /** the list of workers in the restaurant */
  protected ArrayList<Worker> workers;
  /** the list of past customers in the restaurant */
  protected SkipList<Customer> customers;

  // Constructor
  /**  Constructer for the Restaurant class. */
  public Restaurant() {
    workers = Authentication.getWorkersFromDatabase();
    customers = Authentication.getCustomersFromDatabase();
    menu = new Menu(Authentication.getMenuFromDatabase());
    orders = new LinkedList<>();
    score = calculateScore();
    income = 0;
    outcome = 10000;
  }

  /**
   * Return the first element of the workers list.
   *
   * @return A Chef object.
   */
  public Chef getTestChef() {
    return (Chef) workers.get(0);
  }

  /**
   * Return a random Courier from the workers list.
   *
   * @return A random Courier object.
   */
  public Courier getTestCourier() {
    return (Courier) workers.get(2);
  }

  /**
   * It creates a random order of food items from the menu
   *
   * @return A LinkedList of Food objects.
   */
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

  /**
   * For each worker in the workers list, add the worker's score to the score variable.
   *
   * @return The average score of all the workers.
   */
  public double calculateScore() {
    double score = 0;

    for (Worker anworker : workers) score += anworker.getScore();

    return score / workers.size();
  }

  /**
   * Add an order to the list of orders and update the income.
   *
   * @param order the order to be added to the list of orders.
   */
  public void addOrder(Order order) {
    orders.addLast(order);
    income += order.getAccount();
  }

  /**
   *  Choose the chef with the least amount of orders and assign the order to him
   *
   * @param order the order that needs to be processed
   * @return A Chef object.
   */
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

  /**
   * Choose a courier and assign the order to him
   *
   * @param order the order that needs to be delivered
   * @return Courier
   */
  public Courier chooseCourier(Order order) {
    if (order == null) return null;

    int workerId = 0, minOrder = 0;

    for (int i = 0; i < workers.size(); i++) {
      if (workers.get(i) instanceof Courier) {
        if (minOrder >= ((Courier) workers.get(i)).getSizeOfOrders()) {
          minOrder = ((Courier) workers.get(i)).getSizeOfOrders();
          workerId = i;
        }
      }
    }
    ((Courier) workers.get(workerId)).addOrder(order);
    return (Courier) workers.get(workerId);
  }

  public SkipList<Customer> getCustomers() {
    return customers;
  }

  /**
   * This function returns the workers
   *
   * @return An ArrayList of Worker objects.
   */
  public ArrayList<Worker> getWorkers() {
    return workers;
  }

  /**
   * This function prints out all the workers
   */
  public void showWorkers() {
    for (int i = 0; i < workers.size(); i++) {
      System.out.println(workers.toString());
    }
  }

  /**
   * this method returns a string representation of the menu
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
