package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import src.tree.BinarySearchTree;

public class Login {

  private static final String DATABASE_FILE_PATH =
    "../src/user_database/users.txt";

  public static void showLoginMenu() {
    System.out.println("ONLINE FOOD SERVICE SYSTEM\n");
    System.out.println("\tLOGIN MENU");
    System.out.println("1. Log In");
    System.out.println("2. Sign Up");
    System.out.println("3. Exit");
  }

  public static User logIn() {
    String username = "";
    String password = "";
    boolean isUserExistCheck = true;
    boolean isPasswordValidCheck = true;
    Scanner scanObj = new Scanner(System.in);

    while (isUserExistCheck) {
      System.out.println("Enter your username please: ");
      username = scanObj.next();
      isUserExistCheck = isUserExist(username);
      if (!isUserExistCheck) {
        System.out.println("User does not exist! Please sign up.");
      }
    }

    while (isPasswordValidCheck) {
      System.out.println("Enter your password please");
      password = scanObj.next();
      isPasswordValidCheck = isPasswordValid(username, password);
      if (!isPasswordValidCheck) {
        System.out.println("Password is not correct! Could not login.");
      }
    }
    return null;
  }

  public static void signUp() {}

  private static boolean isUserExist(String username) {
    BinarySearchTree<User> allUsers = new BinarySearchTree<User>();
    allUsers = getAllUsersFromDatabase();
    return allUsers.contains(new User(username, 0, "", ""));
  }

  private static boolean isPasswordValid(String username, String password) {
    String correctPassword = "";
    correctPassword = getUserPassword(username);
    return correctPassword.equals(password);
  }

  private static String getUserPassword(String username) {
    return "deneme";
  }

  private static User getUserFromUsername(String username) {
    BinarySearchTree<User> allUsers = new BinarySearchTree<User>();
    allUsers = getAllUsersFromDatabase();
    return allUsers.find(new User(username, 0, "", ""));
  }

  private static void addUserToDatabase() {}

  private static void deleteUserFromDatabase() {}

  private static void updateUserInDatabase() {}

  private static BinarySearchTree<User> getAllUsersFromDatabase() {
    try {
      BinarySearchTree<User> allUsers = new BinarySearchTree<>();
      File file = new File(DATABASE_FILE_PATH);
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
    User user = new User(
      tokens[0],
      Integer.parseInt(tokens[1]),
      tokens[2],
      tokens[3]
    );
    return user;
  }
}
