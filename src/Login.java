import java.util.Scanner;
import tree.BinarySearchTree;

public class Login {

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
    String correctPassword = "";
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

    correctPassword = getUserPassword(username);

    while (isPasswordValidCheck) {
      System.out.println("Enter your password please");
      password = scanObj.next();

      if (!isPasswordValid(password)) {
        System.out.println("Password is not correct! Could not login.");
      }
    }
    return null;
  }

  public static void signUp() {}

  private static boolean isUserExist(String username) {
    return false;
  }

  private static boolean isPasswordValid(String password) {
    return false;
  }

  private static String getUserPassword(String username) {
    return "deneme";
  }

  private static User getUserFromUsername(String username) {
    return null;
  }

  private static void addUserToDatabase() {}

  private static void deleteUserFromDatabase() {}

  private static void updateUserInDatabase() {}

  private static void getAllUsers() {}
}
