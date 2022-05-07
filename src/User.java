package src;

/**
 * The user class includes all users in the system.
 * 
 * @since 03-03-2022
 *
 */
public class User implements Comparable<User> {

  private String name;
  private int age;
  private String username;
  private String password;

  public User(String _name, int _age, String _username, String _password) {
    name = _name;
    age = _age;
    username = _username;
    password = _password;
  }

  User() {
    name = "Mustafa";
    age = 24;
    username = "1234";
    password = "1234";
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void changeUsername(String _username) {
    username = _username;
  }

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

}
