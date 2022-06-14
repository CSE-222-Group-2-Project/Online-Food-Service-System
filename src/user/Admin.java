package src.user;

import java.util.Scanner;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;

/**
 * Admin class is a subclass of User class and it has some methods to control the restaurant
 * @author Group 2
 * @version 1.0.0
 * @since 08.04.2022
 */

/**
 * Admin class is a subclass of User class and it has some methods to control the restaurant
 */
public class Admin extends User {

  // Data Fields
  private Restaurant restaurant;

  // Constructors

  /** Constructor of the Admin class
   * @param restaurant the restaurant object
   * @param username the username of the admin
   * @param password the password of the admin
   * @param name the name of the admin
   * @param age the age of the admin
   */
  public Admin(
    Restaurant restaurant,
    String name,
    int age,
    String username,
    String password
  ) {
    super(name, age, username, password);
    this.restaurant = restaurant;
  }

  // Methods
  /**
   * Shows the informations which are about workers are Job, Name, Age and Certificate number if it exists
   */
  public void showWorkersInfo() {
    for (Worker worker : restaurant.getWorkers()) {
      System.out.println("Job: " + worker.getJob());
      System.out.println("Name: " + worker.getName());
      System.out.println("Age: " + worker.getAge());

      if (worker instanceof Chef) System.out.println(
        "Certification Number: " + ((Chef) worker).getCertificateNumber()
      );
      System.out.println("---------------");
    }
  }

  /**
   * Shows the informations which are about customers are Job, Name, Age, Balance, Order number and Phone number
   */
  public void showCustomersInfo() {
    for (Customer customer : restaurant.getCustomers()) {
      System.out.println("Name: " + customer.getName());
      System.out.println("Job: " + customer.getJob());
      System.out.println("Age: " + customer.getAge());
      System.out.println("Balance: " + customer.getBudget());
      System.out.println("Last Order number: " + customer.getOrderNumber());
      System.out.println("Phone Number: " + customer.getPhoneNumber());
      System.out.println("---------------");
    }
  }

  /**
   * Shows the incomes and outcomes and the total profit
   */
  public void printIncomeAndOutcome() {
    System.out.println("The total income is " + restaurant.getIncome());
    System.out.println("The total outcome is " + restaurant.getOutcome());
    System.out.println(
      "The profit is " + (restaurant.getIncome() - restaurant.getOutcome())
    );
  }

  /**
   * Prints all restaurant's order
   */
  public void printAllOrders() {
    for (Order anOrder : restaurant.getOrders()) System.out.println(
      anOrder.toString()
    );
    System.out.println("Orders have been printed.");
  }

  /**
   * Removes workers which have score that is less than 4.0 from ArrayList
   */
  public void fireWorker() {
    for (Worker worker : restaurant.getWorkers()) {
      if (
        worker.getVoteAmount() > 10 &&
        worker.getScore() / worker.getVoteAmount() < 4 //workers with more than 10 number of orders
      ) { //and workers with less than 4.0 score
        System.out.println(
          worker.getName() +
          " has been fired with " +
          worker.getScore() /
          worker.getVoteAmount() +
          " score."
        );
        restaurant.getWorkers().remove(worker); //Remove workers from array list
      }
    }
    System.out.println("Worker has been fired.");
  }

  /**
   * Adds new worker to array list
   * @param newWorker Accepts new worker
   */
  public void hiringWorker(Worker newWorker) {
    restaurant.getWorkers().add(newWorker);
    System.out.println("New worker has been hired.");
  }

  /**
   * Updates all salaries by controling number of orders and scores
   */
  public void editSalary() {
    for (Worker worker : restaurant.getWorkers()) {
      if (worker.getScore() / worker.getVoteAmount() > 8) { // If score is more than 8
        worker.setSalary(
          worker.getSalary() +
          worker.getExperienceYear() *
          100 *
          (worker.getScore() / worker.getVoteAmount())
        );
        worker.setScore(4); //Reset the score
      }
    }
    System.out.println("Salaries have been updated.");
  }

  /**
   * Creates a new food by taking information from cheif
   * @return Returns the new Food object
   */
  public Food createFood() {
    Scanner scanner = new Scanner(System.in);
    String foodName, foodType;
    double foodPrice;
    int foodId;
    System.out.println("Enter food name :");
    foodName = scanner.nextLine();
    System.out.println("Enter food type :");
    foodType = scanner.nextLine();
    System.out.println("Enter food price :");
    foodPrice = Double.parseDouble(scanner.nextLine());
    System.out.println("Enter food ID  :");
    foodId = Integer.parseInt(scanner.nextLine());
    return createFood(foodId,foodName,foodPrice,foodType);
  }

  /**
   * This function creates a new Food object and returns it.
   *
   * @param foodId The id of the food.
   * @param foodName The name of the food.
   * @param foodPrice The price of the food.
   * @param foodType The type of food.
   * @return A new instance of the Food class.
   */
  public Food createFood(
    int foodId,
    String foodName,
    double foodPrice,
    String foodType
  ) {
    System.out.println("Food has been created.");
    return new Food(foodId, foodName, foodPrice, foodType);
  }

  /**
   * This function adds a food to the menu of the restaurant.
   *
   * @param food The food object that you want to add to the menu.
   */
  public void addFoodToMenu(Food food) {
    restaurant.addFoodtoMenu(food);
    System.out.println("Food added to Menu.");

  }

  /**
   * This function deletes a food from the menu of the restaurant.
   *
   * @param id the id of the food to be deleted
   * @return A boolean value.
   */
  public boolean deleteFoodFromMenu(int id) {
    System.out.println("Food deleted from Menu.");
    return this.restaurant.deleteFoodFromMenu(id);
  }

  /**
   * This function deletes a food from the menu of the restaurant.
   *
   * @param food The food to be deleted from the menu.
   * @return A boolean value to return if it is deleted
   */
  public boolean deleteFoodFromMenu(Food food) {
    System.out.println("Food deleted from Menu.");
    return this.restaurant.deleteFoodFromMenu(food);
  }

  /**
   * Create a new menu for the restaurant.
   *
   * @param menu The menu to be created.
   */
  public void createMenu(Menu menu) {
    this.restaurant.createNewMenu(menu);
    System.out.println("New menu has been created.");
  }

  /**
   * This function prints the menu to the screen.
   */
  public void seeMenu() {
    Menu.seeMenu();
    System.out.println("Menu has been shown");
  }

  /**
   * Print the name of the customer of the month.
   */
  public void customerOfTheMonth(){
    System.out.println("Best Of the Month is : ");
     System.out.println(restaurant.monthOfTheCustomer());
  }

  /**
   * The setRestaurant function takes in a Restaurant object and sets the restaurant instance variable to the Restaurant
   * object that was passed in
   *
   * @param restaurant The restaurant object that is being passed in.
   */
  public void setRestaurant(Restaurant restaurant){
    this.restaurant = restaurant;
  }


  /**
 * If the other object is an instance of the User class, then return true if the username is the same,
 * otherwise return false
 * 
 * @param other The object to compare this Admin against
 * @return The hashcode of the username.
 */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Admin) {
      User otherUser = (User) other;
      return getUsername().equals(otherUser.getUsername());
    }
    return false;
  }



/**
 * If the name of this user is less than the name of the other user, return a negative number; if the
 * name of this user is greater than the name of the other user, return a positive number; if the names
 * are equal, return 0.
 * 
 * @param other The other user to compare to.
 * @return The name of the user.
 */
  @Override
  public int compareTo(User other) {
    return getName().compareTo(other.getName());
  }

  /**
   * The toString() method returns a string representation of the Admin object
   *
   * @return String representation of the Admin object is being returned.
   */
  @Override
  public String toString() {
    StringBuilder adminInfo = new StringBuilder();
    adminInfo.append("Admin Info: " + "\n");
    adminInfo.append(super.toString() + "\n");
    return adminInfo.toString();
  }
}
