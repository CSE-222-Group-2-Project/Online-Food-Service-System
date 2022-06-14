package src.restaurant;

import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.util.Utility;

/**
 *The Menu class is a class that contains  Food objects.
 * @author Group 2
 * @version 2.0.0
 * @since 14.06.2022
 */

/**
 * The Menu class is a class that contains  Food objects.
 */
public class Menu {

  /** Creating a new LinkedList of Food objects.*/ 
  private static CustomLinkedList<Food> menu = new CustomLinkedList<>();

  /**
   * Default Constructor of the Menu class
   */
  public Menu() {
    menu = Utility.getMenuFromDatabase();
  }

  /**
   * A constructor that takes a LinkedList of Food objects as a parameter.
   * @param otherMenu The LinkedList of Food objects.
   */
  public Menu(CustomLinkedList<Food> otherMenu) {
    menu = otherMenu;
  }

  /**
   * This function returns the menu.
   *
   * @return The menu list is being returned.
   */
  public CustomLinkedList<Food> getMenu() {
    return menu;
  }

  public Food getFood(int foodID) {
    for (Food food : menu) {
      if (food.getFoodID() == foodID) {
        return food;
      }
    }
    return null;
  }

  /**
   * We're going to create a new StringBuilder object, then we're going to loop through the menu array, and for each food
   * in the menu array, we're going to append that food to the stringBuilder object, and then we're going to print out the
   * stringBuilder object.
   */
  public static void seeMenu() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Food food : menu) {
      stringBuilder.append(food + "\n");
    }
    System.out.print(stringBuilder);
  }

  /**
   * The toString() method returns a string representation of the object
   *
   * @return The toString method is being returned.
   */
  @Override
  public String toString() {
    StringBuilder menuInfo = new StringBuilder();
    for (Food food : menu) {
      menuInfo.append(food + "\n");
    }
    return menuInfo.toString();
  }
}
