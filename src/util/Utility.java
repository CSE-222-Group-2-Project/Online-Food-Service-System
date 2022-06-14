package src.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.datastructures.skiplist.SkipList;
import src.datastructures.tree.AVLTree;
import src.datastructures.tree.BinarySearchTree;
import src.restaurant.Food;
import src.user.Customer;
import src.user.User;
import src.user.Worker;

public class Utility {

  private static final String USER_DATABASE_PATH =
    "../../database/user_database/users.txt";
  private static final String MENU_DATABASE_PATH =
    "../../database/restaurant_database/menu.txt";
  private static final String INGREDIENT_DATABASE_PATH =
    "../../database/ingredients_database/ingredients.txt";

  public static TreeMap<String, AVLTree<String>> getIngredientsFromDatabase() {
    try {
      TreeMap<String, AVLTree<String>> ingredients = new TreeMap<>();
      File file = new File(INGREDIENT_DATABASE_PATH);
      boolean isFoodName = true;
      StringBuffer sb = new StringBuffer();
      String foodName = "";
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String lineText = myReader.nextLine();
        String[] tokens = lineText.split(" ");
        AVLTree<String> allIngred = new AVLTree<>();

        for (int i = 1; i < tokens.length; i++) {
          if (tokens[i].equals(":")) {
            isFoodName = false;
          }
          if (isFoodName) {
            sb.append(tokens[i] + " ");
          } else {
            allIngred.add(tokens[i]);
          }
        }
        foodName = sb.toString().trim();
        ingredients.put(foodName, allIngred);
      }
      myReader.close();
      return ingredients;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return new TreeMap<>();
  }

  /**
   * It reads the menu database file and returns a linked list of food objects
   *
   * @return A LinkedList of Food objects.
   */
  public static CustomLinkedList<Food> getMenuFromDatabase() {
    try {
      CustomLinkedList<Food> menu = new CustomLinkedList<>();
      File file = new File(MENU_DATABASE_PATH);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String lineText = myReader.nextLine();
        menu.addLast(LineParsers.parseFoodLine(lineText));
      }
      myReader.close();
      return menu;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }

  /**
   * This function reads the user database file and returns an ArrayList of all the workers in the
   * database.
   *
   * @return An ArrayList of all the workers in the database.
   */
  public static ArrayList<Worker> getWorkersFromDatabase() {
    try {
      ArrayList<Worker> allWorkers = new ArrayList<>();
      File file = new File(USER_DATABASE_PATH);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String lineText = myReader.nextLine();
        User user = LineParsers.parseAndConvertUserLine(lineText);
        if (user instanceof Worker) {
          allWorkers.add((Worker) user);
        }
      }
      myReader.close();
      return allWorkers;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }

  /**
   * This function reads the user database file and returns an ArrayList of all the customers in the
   * database.
   *
   * @return An ArrayList of all the customers in the database.
   */
  public static SkipList<Customer> getCustomersFromDatabase() {
    try {
      SkipList<Customer> allCustomers = new SkipList<>();
      File file = new File(USER_DATABASE_PATH);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String lineText = myReader.nextLine();
        User user = LineParsers.parseAndConvertUserLine(lineText);
        if (user instanceof Customer) {
          allCustomers.add((Customer) user);
        }
      }
      myReader.close();
      return allCustomers;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }

  /**
   * This function reads the user database file and returns a binary search tree of all the users in the
   * database.
   *
   * @return A BinarySearchTree of User objects.
   */
  public static BinarySearchTree<User> getAllUsersFromDatabase() {
    try {
      BinarySearchTree<User> allUsers = new BinarySearchTree<>();
      File file = new File(USER_DATABASE_PATH);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String lineText = myReader.nextLine();
        allUsers.add(LineParsers.parseUserLine(lineText));
      }
      myReader.close();
      return allUsers;
    } catch (FileNotFoundException e) {
      System.err.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }
}
