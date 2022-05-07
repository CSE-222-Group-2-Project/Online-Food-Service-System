package src;

import java.util.Scanner;

/**
 * Admin class is a subclass of User class and it has some methods to control the restaurant
 */
public class Admin extends User {

  private Restaurant restaurant;

  /* Constructor Of Admin Class*/
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

  /**
   * Shows the informations which are about workers are Job, Name, Age and Certificate number if it exists
   */
  public void showWorkersInfo() {
    for (Worker worker : restaurant.workers) {
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
    for (Customer customer : restaurant.customers) {
      System.out.println("Name: " + customer.getName());
      System.out.println("Job: " + customer.getJob());
      System.out.println("Age: " + customer.getAge());
      System.out.println("Balance: " + customer.getBalance());
      System.out.println("Last Order number: " + customer.getOrderNumber());
      System.out.println("Phone Number: " + customer.getPhone());
      System.out.println("---------------");
    }
  }

  /**
   * Shows the incomes and outcomes and the total profit
   */
  public void printIncomeAndOutcome() {
    System.out.println("The total income is " + restaurant.income);
    System.out.println("The total outcome is " + restaurant.outcome);
    System.out.println(
      "The profit is " + (restaurant.income - restaurant.outcome)
    );
  }

  /**
   * Prints all restaurant's order
   */
  public void printAllOrders() {
    for(Order anOrder : restaurant.orders)
      System.out.println(anOrder.toString());
  }

  /**
   * Removes workers which have score that is less than 4.0 from ArrayList
   */
  public void fireWorker() {
    for (Worker worker : restaurant.workers) {
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
        restaurant.workers.remove(worker); //Remove workers from array list
      }
    }
  }

  /**
   * Updates all salaries by controling number of orders and scores
   */
  public void editSalary() {
    for (Worker worker : restaurant.workers) {
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
    return new Food(foodId, foodName, foodPrice, foodType);
  }

  /**
   * This function adds a food to the menu of the restaurant.
   *
   * @param food The food object that you want to add to the menu.
   */
  public void addFoodToMenu(Food food) {
    restaurant.addFoodtoMenu(food);
  }

  /**
   * This function deletes a food from the menu of the restaurant.
   *
   * @param id the id of the food to be deleted
   * @return A boolean value.
   */
  public boolean deleteFoodFromMenu(int id) {
    return this.restaurant.deleteFoodFromMenu(id);
  }

  /**
   * This function deletes a food from the menu of the restaurant.
   *
   * @param food The food to be deleted from the menu.
   * @return A boolean value to return if it is deleted
   */
  public boolean deleteFoodFromMenu(Food food) {
    return this.restaurant.deleteFoodFromMenu(food);
  }

  /**
   * Create a new menu for the restaurant.
   *
   * @param menu The menu to be created.
   */
  public void createMenu(Menu menu) {
    this.restaurant.createNewMenu(menu);
  }

  /**
   * This function prints the menu to the screen.
   */
  public void seeMenu() {
    Menu.seeMenu();
  }

  /**
   * The toString() method returns a string representation of the Admin object
   *
   * @return String representation of the Admin object is being returned.
   */
  @Override
  public String toString() {
    StringBuilder adminInfo = new StringBuilder();
    adminInfo.append("Admin: ");
    adminInfo.append(super.toString());
    adminInfo.append("\n");
    adminInfo.append("Restaurant Info " + restaurant.toString());
    return adminInfo.toString();
  }
}
