package src;

public class Worker extends User {
  public enum workerStatus { // experience year/score'a göre chef statüsü değişsin. 
  beginner, // -4
  junior,   // 4-6
  midLevel, // 6-8
  senior    // +8
  }
  private String job;
  private double salary;
  private double score = 4;  // Kovulma şartı: vote min 10 olsun. 4 altına düşünce kovulsun.
  private int experienceYear;
  private int voteAmount = 0; // Vote kısmı atacanla konusulacak, burayi customer güncelleyecek cunku
  // totalScore degiskeni olusturmak yerine score*voteAmounttan bul. (aritmetik ort soruları gibi)

  public Worker( 
    String _name,
    int _age,
    String _username,
    String _password,
    String _job,
    int _experienceYear
   ){
    super(_name, _age, _username, _password);
    job = _job;
    experienceYear = _experienceYear;
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

  private void calculateScore() {} // oyların toplamı/oy sayisi
}
