package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    signUp();
  }

  public static User logIn() {
    String username = getUsernameFromUserForLogIn();
    String password = getPasswordFromUserForLogIn(username);

    return getUserFromUsername(username);
  }

  public static User signUp() {
    User newUser = null;

    String name = getNameFromUser();
    int age = getAgeFromUser();
    String username = getUsernameFromUserForSignUp();
    String password = getPasswordFromUserForSignUp();

    newUser = new User(name, age, username, password);
    addUserToDatabase(newUser);
    return newUser;
  }

  private static String getUsernameFromUserForLogIn() {
    String username = "";
    boolean isUserExistCheck = true;
    Scanner scanObj = new Scanner(System.in);

    while (isUserExistCheck) {
      System.out.println("Enter your username please: ");
      username = scanObj.next();
      isUserExistCheck = isUserExist(username);
      if (!isUserExistCheck) {
        System.out.println("User does not exist! Please sign up.");
      }
    }
    return username;
  }

  private static String getPasswordFromUserForLogIn(String username) {
    String password = "";
    boolean isPasswordTrueCheck = true;
    Scanner scanObj = new Scanner(System.in);

    while (isPasswordTrueCheck) {
      System.out.println("Enter your password please");
      password = scanObj.next();
      isPasswordTrueCheck = isPasswordTrue(username, password);
      if (!isPasswordTrueCheck) {
        System.out.println("Password is not correct! Could not login.");
      }
    }
    return password;
  }

  private static String getUsernameFromUserForSignUp() {
    String username = "";
    boolean isUsernameValidCheck = false;
    Scanner scanObj = new Scanner(System.in);

    while (!isUsernameValidCheck) {
      System.out.println("Enter your username please: ");
      username = scanObj.next();
      isUsernameValidCheck = isUsernameValid(username);
      if (!isUsernameValidCheck) {
        System.out.println("User does not exist! Please sign up.");
      }
    }

    return username;
  }

  private static String getPasswordFromUserForSignUp() {
    String password = "";
    boolean isPasswordValidCheck = false;
    Scanner scanObj = new Scanner(System.in);
    while (!isPasswordValidCheck) {
      System.out.println("Enter your password please");
      password = scanObj.next();
      isPasswordValidCheck = isPasswordValid(password);
      if (!isPasswordValidCheck) {
        System.out.println("Password is not correct! Could not login.");
      }
    }
    return password;
  }

  private static String getNameFromUser() {
    String name = "";
    boolean isNameValidCheck = false;
    Scanner scanObj = new Scanner(System.in);

    while (!isNameValidCheck) {
      System.out.println("Enter your name please: ");
      name = scanObj.next();
      isNameValidCheck = isNameValid(name);
      if (!isNameValidCheck) {
        System.out.println("Name is not valid! Please try again.");
      }
    }
    return name;
  }

  private static int getAgeFromUser() {
    int age = 0;
    boolean isAgeValidCheck = false;
    Scanner scanObj = new Scanner(System.in);

    while (!isAgeValidCheck) {
      System.out.println("Enter your age please: ");
      age = scanObj.nextInt();
      isAgeValidCheck = isAgeValid(age);
      if (!isAgeValidCheck) {
        System.out.println("Age is not valid! Please try again.");
      }
    }

    return age;
  }

  private static boolean isUsernameValid(String username) {
    return true;
  }

  private static boolean isPasswordValid(String password) {
    return true;
  }

  private static boolean isNameValid(String name) {
    return true;
  }

  private static boolean isAgeValid(int age) {
    return true;
  }

  private static boolean isUserExist(String username) {
    BinarySearchTree<User> allUsers = new BinarySearchTree<User>();
    allUsers = getAllUsersFromDatabase();
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
    BinarySearchTree<User> allUsers = new BinarySearchTree<>();
    allUsers = getAllUsersFromDatabase();
    return allUsers.find(new User(username, 0, "", ""));
  }

  private static void addUserToDatabase(User newUser) {
    try {
      String filename = DATABASE_FILE_PATH;
      FileWriter fw = new FileWriter(filename, true);
      fw.write(
        newUser.getName() +
        " " +
        newUser.getAge() +
        " " +
        newUser.getUsername() +
        " " +
        newUser.getPassword() +
        "\n"
      );
      fw.close();
    } catch (IOException ioe) {
      System.err.println("IOException: " + ioe.getMessage());
    }
  }

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
