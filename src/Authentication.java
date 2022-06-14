package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import src.linkedlistwithmergesort.CustomLinkedList;
import src.skiplist.SkipList;
import src.tree.AVLTree;
import src.tree.BinarySearchTree;

/**
 *Authentication methods of the program
 * @author Group 2
 * @version 1.0.0
 * @since 08.04.2022
 */

/**
 * Authentication methods of the program
 */
public class Authentication {

  private static final String USER_DATABASE_PATH =
    "../src/database/user_database/users.txt";
  private static final String MENU_DATABASE_PATH =
    "../src/database/restaurant_database/menu.txt";
  private static final String INGREDIENT_DATABASE_PATH =
    "../src/database/ingredients_database/ingredients.txt";

  private BinarySearchTree<User> allUsers = new BinarySearchTree<>();

  /**
   * If the user enters a valid username and password, return the User object associated with that
   * username and password, otherwise return null.
   *
   * @return A User object.
   */
  public static User login() {
    String name = "";
    int age = 0;
    String username = "";
    String password = "";

    System.out.println("WELCOME TO THE HoldON");

    username = getUsername(name, age, username, password);

    if (username.equals("login-failed")) {
      return null;
    }

    password = getPassword(name, age, username, password);

    if (password.equals("login-failed")) {
      return null;
    }

    return getUser(name, age, username, password);
  }

  /**
   * It takes in the user's name, age, username, and password, and returns the username if the user
   * exists, and returns "login-failed" if the user does not exist
   *
   * @param name The name of the user.
   * @param age The age of the user.
   * @param username The username of the user.
   * @param password The password of the user.
   * @return The username is being returned.
   */
  private static String getUsername(
    String name,
    int age,
    String username,
    String password
  ) {
    Scanner scanObj = new Scanner(System.in);

    System.out.println("Enter your username please: ");
    username = scanObj.next();
    if (isUserExist(name, age, username, password)) {
      System.err.println("User does not exist! Please sign up.");
      scanObj.close();
      return "login-failed";
    }
    scanObj.close();
    return username;
  }

  /**
   * It asks the user to enter their password, and if the password is correct, it returns the password,
   * otherwise it returns "login-failed"
   *
   * @param name The name of the user
   * @param age The age of the user
   * @param username The username of the user
   * @param password The password that the user entered.
   * @return A string
   */
  private static String getPassword(
    String name,
    int age,
    String username,
    String password
  ) {
    Scanner scanObj = new Scanner(System.in);

    System.out.println("Enter your password please");
    password = scanObj.next();

    if (isPasswordTrue(name, age, username, password)) {
      System.out.println("Password is not correct! Could not login.");
      scanObj.close();
      return "login-failed";
    }
    scanObj.close();
    return password;
  }

  /**
   * Get all users from the database, and then find the user with the given username.
   *
   * @param name The name of the user.
   * @param age The age of the user
   * @param username The username of the user you want to get.
   * @param password The password of the user.
   * @return A User object.
   */
  private static User getUser(
    String name,
    int age,
    String username,
    String password
  ) {
    BinarySearchTree<User> allUsers = getAllUsersFromDatabase();
    return allUsers.find(new User(name, age, username, password));
  }

  /**
   * This function adds a new user to the list of all users.
   *
   * @param newUser The user object that is being created.
   */
  public void createUser(User newUser) {
    allUsers.add(newUser);
  }

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
        menu.addLast(parseFoodLine(lineText));
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
        User user = parseAndConvertUserLine(lineText);
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
        User user = parseAndConvertUserLine(lineText);
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
        allUsers.add(parseUserLine(lineText));
      }
      myReader.close();
      return allUsers;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }

  /**
   * If the user exists in the database, return true, otherwise return false.
   *
   * @param name The name of the user.
   * @param age The age of the user.
   * @param username The username of the user.
   * @param password The password of the user.
   * @return A boolean value.
   */
  private static boolean isUserExist(
    String name,
    int age,
    String username,
    String password
  ) {
    BinarySearchTree<User> allUsers = getAllUsersFromDatabase();
    return allUsers.contains(new User(name, age, username, password));
  }

  /**
   * If the password is correct, return true, otherwise return false.
   *
   * @param name The name of the user
   * @param age The age of the user
   * @param username The username of the user
   * @param password The password the user entered
   * @return The method is returning a boolean value.
   */
  private static boolean isPasswordTrue(
    String name,
    int age,
    String username,
    String password
  ) {
    String correctPassword = "";
    correctPassword = getUserPassword(name, age, username, password);
    return correctPassword.equals(password);
  }

  /**
   * Get the user's password from the username.
   *
   * @param name The name of the user
   * @param age The age of the user
   * @param username The username of the user you want to get the password of.
   * @param password The password of the user.
   * @return The password of the user.
   */
  private static String getUserPassword(
    String name,
    int age,
    String username,
    String password
  ) {
    User user = getUserFromUsername(name, age, username, password);
    return user.getPassword();
  }

  /**
   * It takes a line of text from the food.txt file, splits it into tokens, and then creates a Food
   * object with the tokens
   *
   * @param lineText The line of text that we're parsing.
   * @return A Food object
   */
  private static Food parseFoodLine(String lineText) {
    String[] tokens = lineText.split(" ");
    StringBuilder foodName = new StringBuilder();
    Food food = new Food();

    food.setFoodID(Integer.parseInt(tokens[0]));

    for (int i = 1; i < tokens.length - 2; i++) {
      foodName.append(tokens[i] + " ");
    }
    food.setFoodName(foodName.toString());
    food.setFoodPrice(Integer.parseInt(tokens[tokens.length - 2]));
    food.setFoodType(tokens[tokens.length - 1]);

    return food;
  }

  /**
   * It takes a line of text, splits it into tokens, and then creates a new User object based on the
   * first token
   *
   * @param lineText The line of text that we're parsing.
   * @return A User object.
   */
  private static User parseUserLine(String lineText) {
    String[] tokens = lineText.split(" ");
    String userType = tokens[0];

    if (userType.equals("admin")) {
      return new User(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("chef")) {
      return new User(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("courier")) {
      return new User(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("customer")) {
      return new User(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[4],
        tokens[5]
      );
    } else {
      return null;
    }
  }

  /**
   * It takes a line of text, splits it into tokens, and then uses the first token to determine which
   * type of user to create
   *
   * @param lineText The line of text that we're parsing.
   * @return A User object.
   */
  private static User parseAndConvertUserLine(String lineText) {
    String[] tokens = lineText.split(" ");
    String userType = tokens[0];

    if (userType.equals("admin")) {
      return new Admin(
        null,
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("chef")) {
      return new Chef(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        Integer.parseInt(tokens[5]),
        Integer.parseInt(tokens[6])
      );
    } else if (userType.equals("courier")) {
      return new Courier(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        tokens[5],
        Integer.parseInt(tokens[6])
      );
    } else if (userType.equals("customer")) {
      return new Customer(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        tokens[5],
        tokens[6],
        Double.parseDouble(tokens[7])
      );
    } else {
      return null;
    }
  }
}
