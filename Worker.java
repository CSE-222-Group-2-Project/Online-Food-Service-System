public class Worker extends User {
  private String job;

  public Worker(String _name, int _age, String _job) {
    super(_name, _age);
    job = _job;
  }
}
