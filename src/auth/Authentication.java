package src.auth;

import java.util.Scanner;
import src.tree.BinarySearchTree;
import src.user.User;
import src.util.Utility;

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

    if (username == null) {
      return null;
    }

    password = getPassword(name, age, username, password);

    if (password == null) {
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
      System.err.println("User does not exist!");
      scanObj.close();
      return null;
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
      return null;
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
    BinarySearchTree<User> allUsers = Utility.getAllUsersFromDatabase();
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
    BinarySearchTree<User> allUsers = Utility.getAllUsersFromDatabase();
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
    User user = getUser(name, age, username, password);
    return user.getPassword();
  }
}
