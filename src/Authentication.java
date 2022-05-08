package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import src.tree.BinarySearchTree;

public class Authentication {

  private static final String USER_DATABASE_PATH =
    "../src/database/user_database/users.txt";
  private static final String MENU_DATABASE_PATH =
    "../src/database/restaurant_database/menu.txt";

  public static void showLoginMenu() {
    System.out.println("ONLINE FOOD SERVICE SYSTEM\n");
    System.out.println("\tLOGIN MENU");
    System.out.println("1. Log In");
    System.out.println("3. Exit");
  }

  /**
   * If the user enters a valid username and password, return the User object associated with that
   * username and password, otherwise return null.
   *
   * @return A User object.
   */
  public static User logIn() {
    String username = getUsernameFromUserForLogIn();

    if (username.equals("login-failed")) {
      return null;
    }

    String password = getPasswordFromUserForLogIn(username);

    if (password.equals("login-failed")) {
      return null;
    }

    return getUserFromUsername(username);
  }

  public static User logIn(String username, String password) {
    return getUserFromUsername(username);
  }

  /**
   * It reads the menu database file and returns a linked list of food objects
   *
   * @return A LinkedList of Food objects.
   */
  public static LinkedList<Food> getMenuFromDatabase() {
    try {
      LinkedList<Food> menu = new LinkedList<>();
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

  public static ArrayList<Worker> getWorkersFromDatabase() {
    try {
      ArrayList<Worker> allWorkers = new ArrayList<>();
      File file = new File(USER_DATABASE_PATH);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String lineText = myReader.nextLine();
        User user = parseUserLine(lineText);
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

  public static ArrayList<Customer> getCustomersFromDatabase() {
    try {
      ArrayList<Customer> allCustomers = new ArrayList<>();
      File file = new File(USER_DATABASE_PATH);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String lineText = myReader.nextLine();
        User user = parseUserLine(lineText);
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

  private static String getUsernameFromUserForLogIn() {
    String username = "";
    Scanner scanObj = new Scanner(System.in);

    System.out.println("Enter your username please: ");
    username = scanObj.next();
    if (isUserExist(username)) {
      System.err.println("User does not exist! Please sign up.");
      scanObj.close();
      return "login-failed";
    }
    scanObj.close();
    return username;
  }

  private static String getPasswordFromUserForLogIn(String username) {
    String password = "";
    Scanner scanObj = new Scanner(System.in);

    System.out.println("Enter your password please");
    password = scanObj.next();

    if (isPasswordTrue(username, password)) {
      System.out.println("Password is not correct! Could not login.");
      scanObj.close();
      return "login-failed";
    }
    scanObj.close();
    return password;
  }

  private static boolean isUserExist(String username) {
    BinarySearchTree<User> allUsers = getAllUsersFromDatabase();
    return allUsers.contains(new User(username, 0, "", ""));
  }

  private static boolean isPasswordTrue(String username, String password) {
    String correctPassword = "";
    correctPassword = getUserPassword(username);
    return correctPassword.equals(password);
  }

  private static String getUserPassword(String username) {
    User user = getUserFromUsername(username);
    return user.getPassword();
  }

  private static User getUserFromUsername(String username) {
    BinarySearchTree<User> allUsers = getAllUsersFromDatabase();
    return allUsers.find(new User(username, 0, "", ""));
  }

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

  private static User parseUserLine(String lineText) {
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
