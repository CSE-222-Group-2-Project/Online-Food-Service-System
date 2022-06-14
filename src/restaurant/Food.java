package src.restaurant;

/**
 * It's a class that represents a food item
 * @author Group 2
 * @version 1.0.0
 * @since 08.04.2022
 */

/**
 * It's a class that represents a food item
 */
public class Food implements Comparable<Food> {

  private int foodID;
  private String foodName;
  private double foodPrice;
  private String foodType;

  /**
   * Constructor of the Food class
   *
   * @param _food_id    the food id
   * @param _food_name  the food name
   * @param _food_price the food price
   * @param _food_type  the food type
   */
  public Food(
    int _food_id,
    String _food_name,
    double _food_price,
    String _food_type
  ) { // type is added for extra
    foodID = _food_id;
    foodName = _food_name;
    foodPrice = _food_price;
    foodType = _food_type;
  }

  /** Default Constructer of the Food class */
  public Food() {
    // Intentionally empty
  }

  /**
   * This function sets the foodID variable to the value of the id parameter.
   *
   * @param id The ID of the food item.
   */
  public void setFoodID(int id) {
    foodID = id;
  }

  /**
   * It sets the foodName variable to the value of the food_name parameter.
   *
   * @param food_name The name of the food.
   */
  public void setFoodName(String food_name) {
    foodName = food_name;
  }

  /**
   * It sets the price of the food.
   *
   * @param price The price of the food item
   */
  public void setFoodPrice(double price) {
    foodPrice = price;
  }

  /**
   * This function takes a string as an argument and sets the foodType variable to
   * that string
   *
   * @param type The type of food.
   */
  public void setFoodType(String type) {
    foodType = type;
  }

  /**
   * It returns the foodID.
   *
   * @return The foodID
   */
  public int getFoodID() {
    return foodID;
  }

  /**
   * It returns the value of the price of the food
   *
   * @return The price of the food is being returned.
   */
  public double getFoodPrice() {
    return foodPrice;
  }

  /**
   * This function returns the food type
   *
   * @return The type of the food is being returned.
   */
  public String getFoodType() {
    return foodType;
  }

  /**
   * This function returns the food name
   *
   * @return The name of the food is being returned.
   */
  public String getFoodName() {
    return foodName;
  }

  /**
   * The toString() method returns a string representation of the Food
   *
   * @return The string representation of the Food is being returned.
   */
  @Override
  public String toString() {
    StringBuilder foodInfo = new StringBuilder();
    foodInfo.append("Food Informations: ");
    foodInfo.append("\nFood ID : " + foodID + "\n");
    foodInfo.append("Food Name : " + foodName + "\n");
    foodInfo.append("Food Price : " + foodPrice + "\n");
    foodInfo.append("Food Type : " + foodType + "\n");
    return foodInfo.toString();
  }

  /**
   * If the account number of the current object is greater than the account
   * number of the object passed
   * in, return 1. If the account number of the current object is less than the
   * account number of the
   * object passed in, return -1. Otherwise, return 0
   *
   * @param o The object to be compared.
   */
  @Override
  public int compareTo(Food o) {
    if (getFoodPrice() > o.getFoodPrice()) return 1; else if (
      getFoodPrice() < o.getFoodPrice()
    ) return -1; else return 0;
  }
}
