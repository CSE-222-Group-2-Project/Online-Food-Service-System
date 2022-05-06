package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import src.tree.BinarySearchTree;

public class Authentication {

  private static final String USER_DATABASE_PATH =
    "../src/database/admin_database/admins.txt";
  private static final String MENU_DATABASE_PATH =
    "../src/database/restaurant_database/menu.txt";

  public static void showLoginMenu() {
    System.out.println("ONLINE FOOD SERVICE SYSTEM\n");
    System.out.println("\tLOGIN MENU");
    System.out.println("1. Log In");
    System.out.println("2. Sign Up");
    System.out.println("3. Exit");
  }

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

  private static BinarySearchTree<User> getAllUsersFromDatabase() {
    try {
      BinarySearchTree<User> allUsers = new BinarySearchTree<>();
      File file = new File(USER_DATABASE_PATH);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String lineText = myReader.nextLine();
        allUsers.add(parseLine(lineText));
      }
      myReader.close();
      return allUsers;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }

  private static User parseLine(String lineText) {
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
        Integer.parseInt(tokens[1]),
        tokens[2],
        tokens[3],
        Integer.parseInt(tokens[4]),
        Integer.parseInt(tokens[5])
      );
    } else if (userType.equals("courier")) {
      return new Courier(
        tokens[1],
        Integer.parseInt(tokens[1]),
        tokens[2],
        tokens[3],
        tokens[4],
        Integer.parseInt(tokens[5])
      );
    } else {
      return null;
    }
  }
}
