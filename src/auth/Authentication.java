package src.auth;

import java.util.Scanner;
import src.datastructures.tree.BinarySearchTree;
import src.user.User;
import src.util.Utility;

/**
 *This class contains the login methods of the program
 * @author Group 2
 * @version 2.0.0
 * @since 14.06.2022
 */

/**
 * Authentication methods of the program
 */
public class Authentication {

  /**
   * Binary Tree of users
   */
  private BinarySearchTree<User> allUsers = new BinarySearchTree<>();

  /*
   * Scanner object for to detect user actions
   */
  private static Scanner scanObj = new Scanner(System.in);

  /**
   * user can login to the app within this method
   *
   * @return User object
   */
  public static User login() {
    String username = "";
    String password = "";

    System.out.println("\n** WELCOME TO THE HoldON **\n\n");

    username = getUsername();

    if (username == null) {
      System.err.println("User does not exist!");
      return null;
    }
    password = getPassword(username);

    if (password == null) {
      System.err.println("Password is not correct! Could not login.");
      return null;
    }

    return getUser(username, password);
  }

  /**
   * It asks the user to enter a username, and if the username exists in the database, it returns the
   * username, otherwise it returns null
   *
   * @return The username is being returned.
   */
  private static String getUsername() {
    System.out.print("Enter your username please: ");
    String username = scanObj.next();

    if (!isUserExist(username, "")) {
      return null;
    }
    return username;
  }

  /**
   * It asks the user to enter their password, and if the password is correct, it returns the password
   *
   * @param username The username of the user who is trying to log in.
   * @return The password is being returned.
   */
  private static String getPassword(String username) {
    System.out.print("\nEnter your password please: ");
    String password = scanObj.next();

    if (!isPasswordTrue(username, password)) {
      return null;
    }
    return password;
  }

  /**
   * Get all users from the database, and then find the user with the given
   * username.
   *
   * @param username The username of the user you want to get.
   * @param password The password of the user.
   * @return A User object.
   */
  private static User getUser(String username, String password) {
    BinarySearchTree<User> allUsers = Utility.getAllUsersFromDatabase();
    return allUsers.find(new User(" ", -1, username, password));
  }

  /**
   * If the user exists in the database, return true, otherwise return false.
   *
   * @param name     The name of the user.
   * @param age      The age of the user.
   * @param username The username of the user.
   * @param password The password of the user.
   * @return A boolean value.
   */
  private static boolean isUserExist(String username, String password) {
    BinarySearchTree<User> allUsers = Utility.getAllUsersFromDatabase();
    return allUsers.contains(new User(" ", 10, username, password));
  }

  /**
   * If the password is correct, return true, otherwise return false.
   *

   * @param username The username of the user
   * @param password The password the user entered
   * @return The method is returning a boolean value.
   */
  private static boolean isPasswordTrue(String username, String password) {
    String correctPassword = "";
    correctPassword = getUserPassword(username, password);
    return correctPassword.equals(password);
  }

  /**
   * Get the user's password from the username.
   *
   * @param name     The name of the user
   * @param age      The age of the user
   * @param username The username of the user you want to get the password of.
   * @param password The password of the user.
   * @return The password of the user.
   */
  private static String getUserPassword(String username, String password) {
    User user = getUser(username, password);
    return user.getPassword();
  }

  /**
   * This function adds a new user to the list of all users.
   *
   * @param newUser The user object that is being created.
   */
  public void createUser(User newUser) {
    allUsers.add(newUser);
  }
}
