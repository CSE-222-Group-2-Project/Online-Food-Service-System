import src.auth.Authentication;
import src.user.User;

public class Driver {

  public static void main(String[] args) {
    User user = Authentication.login();
  }
}
