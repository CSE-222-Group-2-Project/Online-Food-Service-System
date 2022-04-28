public class Worker extends User {
  private String job;

  public Worker(String _name, int _age, String _username, String _password, String _job) {
    super(_name, _age, _username, _password);
    job = _job;
  }
}
