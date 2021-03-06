package src.restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;
import src.constants.District;
import src.datastructures.graph.*;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.datastructures.skiplist.SkipList;
import src.datastructures.tree.AVLTree;
import src.user.Chef;
import src.user.Courier;
import src.user.Customer;
import src.user.Worker;
import src.util.Utility;

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
  protected CustomLinkedList<Order> orders;
  private double score;
  private static Menu menu;
  /** the list of workers in the restaurant */
  protected ArrayList<Worker> workers;
  /** the list of past customers in the restaurant */
  protected SkipList<Customer> customers;

  private TreeMap<String, AVLTree<String>> ingredients;
  
  public static Graph districtsGraph = new ListGraph(District.values().length,false);

  // Constructor
  /**  Constructer for the Restaurant class. */
  public Restaurant() {
    workers = Utility.getWorkersFromDatabase();
    customers = Utility.getCustomersFromDatabase();
    menu = new Menu(Utility.getMenuFromDatabase());
    ingredients = Utility.getIngredientsFromDatabase();
    orders = new CustomLinkedList<>();
    score = calculateScore();
    income = 0;
    outcome = 10000;
    this.createGraph();
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

  public Customer getTestCustomer() {
    Iterator<Customer> iterator = customers.iterator();
    return  iterator.next();
  }


  /**
   * It creates a random order of food items from the menu
   *
   * @return A LinkedList of Food objects.
   */
  public CustomLinkedList<Food> createRandomFoods() {
    Random rand = new Random();
    CustomLinkedList<Food> foods = menu.getMenu();
    CustomLinkedList<Food> orderFoods = new CustomLinkedList<>();

    for (int i = 0; i < 4; i++) {
      int randomNumber = rand.nextInt(foods.size());
      System.out.print(randomNumber +  " ");
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

  /**
   * returns the customers
   * 
   * @return skiplist of customers
   */
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
   * This function returns the ingredients
   * @return An TreeMap of ingredients of foods
   */
  public TreeMap<String, AVLTree<String>> getIngredients() {
    return ingredients;
  }

  /**
   * getter for the income of the restaurant
   * 
   * @return returns the income data
   */
  public int getIncome() {
    return income;
  }

  /**
   * getter for the outcome of the restaurant
   * 
   * @return returns the outcome data
   */
  public int getOutcome() {
    return outcome;
  }

  /**
   * getter for the orders of the restaurant
   * 
   * @return returns the orders data
   */
  public CustomLinkedList<Order> getOrders() {
    return orders;
  }

  /**
   * getter for the score of the restaurant
   * 
   * @return returns the score data
   */
  public double getScore() {
    return score;
  }

  /**
   * getter for the menu of the restaurant
   * 
   * @return returns the menu data
   */
  public Menu getMenu() {
    return menu;
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
    CustomLinkedList<Food> temp = this.menu.getMenu();
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
    Food removed = this.menu.getMenu().remove(food);

    if (removed != null) return true; else return false;
  }

  /**
   * This function adds a food to the menu
   *
   * @param food The food object to be added to the menu
   */
  public void addFoodtoMenu(Food food) {
    this.menu.getMenu().add(food);
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
   * It creates a graph of the districts and the distances between them.
   */
  private void createGraph() {

    districtsGraph.insert(new Edge(0, 7, 1.5));
    districtsGraph.insert(new Edge(0, 4, 3.1));
    districtsGraph.insert(new Edge(0, 1, 2.9));
    districtsGraph.insert(new Edge(1, 2, 1.4));
    districtsGraph.insert(new Edge(1, 3, 2.0));
    districtsGraph.insert(new Edge(1, 7, 2.2));
    districtsGraph.insert(new Edge(1, 6, 3.6));
    districtsGraph.insert(new Edge(2, 4, 3.0));
    districtsGraph.insert(new Edge(2, 6, 2.4));
    districtsGraph.insert(new Edge(2, 7, 1.7));
    districtsGraph.insert(new Edge(3, 6, 3.2));
    districtsGraph.insert(new Edge(5, 6, 2.2));

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
