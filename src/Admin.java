package src;

import java.util.Scanner;

public class Admin extends User {

  private Restaurant restaurant;

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

  public Admin() {
    super();
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
  public void income_outcome() {
    System.out.println("The total income is " + restaurant.income);
    System.out.println("The total outcome is " + restaurant.outcome);
    System.out.println(
      "The profit is " + (restaurant.income - restaurant.outcome)
    );
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
      } else;
    }
  }

  /**
   * Updates all salaries by controling number of orders and scores
   */
  public void EditSalary() {
    //değişecek
    for (Worker worker : restaurant.workers) {
      if (worker.getScore() / worker.getVoteAmount() > 8) { // If score is more than 8
        worker.setSalary(
          worker.getSalary() +
          worker.getExperienceYear() *
          100 *
          (worker.getScore() / worker.getVoteAmount())
        );
        worker.setScore(4); //Reset the score
      } else;
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

  public void addFoodToMenu(Food food) {
    restaurant.addFoodtoMenu(food);
  }

  public boolean deleteFoodFromMenu(int id) {
    return this.restaurant.deleteFoodFromMenu(id);
  }

  public boolean deleteFoodFromMenu(Food food) {
    return this.restaurant.deleteFoodFromMenu(food);
  }

  public void createMenu(Menu menu) {
    this.restaurant.createNewMenu(menu);
  }

  public void seeMenu() {
    Menu.seeMenu();
  }

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
