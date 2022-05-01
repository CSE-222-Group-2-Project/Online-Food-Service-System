package src;

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

  public boolean login() {
    return false;
  }

  public void logout() {} // ??

  public int compareTo(User other) {
    return getUsername().compareTo(other.getUsername());
  }

  //public boolean add() {}

  public void makeOrderReady() {}
}
