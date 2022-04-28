public class Worker extends User {
  private String job;

  public Worker(String _name, int _age, int _ID, String _password, String _job) {
    super(_name, _age, _ID, _password);
    job = _job;
  }
}
