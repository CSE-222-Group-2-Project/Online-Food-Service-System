package src;

/**
 *  The user class includes all users in the system.
 * @author Group 2
 * @version 1.0.0
 * @since 08.04.2022
 */

/**
 * The user class includes all users in the system.
 *
 */
public class User implements Comparable<User> {

  private String name;
  private int age;
  private String username;
  private String password;

  /*  Constructer of the User class */
  public User(String _name, int _age, String _username, String _password) {
    name = _name;
    age = _age;
    username = _username;
    password = _password;
  }

  /**
   * This function returns the age of the User
   *
   * @return The age of the User.
   */
  public int getAge() {
    return age;
  }

  /**
   * It returns the name of the User.
   *
   * @return The name of the User.
   */
  public String getName() {
    return name;
  }

  /**
   * It returns the username of the User.
   *
   * @return The username of the User.
   */
  public String getUsername() {
    return username;
  }

  /**
   * It returns the password of the User.
   *
   * @return The password of the User.
   */
  public String getPassword() {
    return password;
  }

  /**
   * This function changes the username of the user.
   *
   * @param _username The new username
   */
  public void changeUsername(String _username) {
    username = _username;
  }

  /**
   * This function changes the password of the user.
   *
   * @param _password The new password for the user.
   */
  public void changePassword(String _password) {
    password = _password;
  }

  /**
   * Compares users by String usernames for binary search in Authentication class.
   *
   * @param other Other user to compare
   * @return Returns 1 -1 0 based on the status of the comparison
   */
  public int compareTo(User other) {
    return getUsername().compareTo(other.getUsername());
  }

  /**
   * The toString() method returns a string representation of the User
   *
   * @return The String representation of the User is being returned.
   */
  @Override
  public String toString() {
    StringBuilder userInfo = new StringBuilder();
    userInfo.append("Name: " + name + "\n");
    userInfo.append("Age: " + age + "\n");
    userInfo.append("Username: " + username + "\n");
    userInfo.append("Password: " + password + "\n\n");
    return userInfo.toString();
  }
}
