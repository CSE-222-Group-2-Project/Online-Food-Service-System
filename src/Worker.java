package src;

public class Worker extends User {

  private String job;
  private double salary;
  private double score = 30;  // 10'un altına düşerse o işçi kovulsun
  private int experienceYear;

  public Worker(
    String _name,
    int _age,
    String _username,
    String _password,
    String _job
  ) {
    super(_name, _age, _username, _password);
    job = _job;
  }

  public String getJob() {
    return job;
  }

  public double getSalary() {
    return salary;
  }

  public double getScore() {
    return score;
  }

  public int getExperienceYear() {
    return experienceYear;
  }

  public void setSalary(double newSalary){
    salary = newSalary;
  }

  private void calculateSalary() {}
}
