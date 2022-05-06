package src;

public class Worker extends User 
{
  /**
   Status of the worker will be change according to it's experience year, certificate number etc. 
  */
  public enum WorkerStatus 
  { 
    BEGINNER, 
    JUNIOR, 
    MID_LEVEL, 
    SENIOR, 
  }

  public enum AvailabilityStatus {
    AVAILABLE,
    BUSY,
  }

  private String job;
  private double salary;
  private double score = 4.0; 
  private int experienceYear;
  private int voteAmount = 0; // Vote kısmı atacanla konusulacak, burayi customer güncelleyecek cunku
  protected WorkerStatus workerStat;

  public Worker(
    String _name,
    int _age,
    String _username,
    String _password,
    String _job,
    int _experienceYear
  ) {
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

  public void setSalary(double newSalary) {
    salary = newSalary;
  }

  public int getVoteAmount() {
    return voteAmount;
  }

  /**
   * Salary of the worker will be calculated according to that worker's WorkerStatus.
   * An initial amount will be assigned to beginner status, and it will increase with increment of status. 
  */
  protected void calculateSalary(double initialSalary) {
    switch(workerStat)
    {
      case BEGINNER: 
        this.setSalary(initialSalary+(50*getExperienceYear()));
        break;
      case JUNIOR:
        this.setSalary(initialSalary+1000+(100*getExperienceYear()));
        break; 
      case MID_LEVEL: 
        this.setSalary(initialSalary+3000+(150*getExperienceYear()));
        break;
      case SENIOR:
        this.setSalary(initialSalary+5000+(200*getExperienceYear()));
        break;
    }
  }

  public double calculateAverageScore(int _score) {
    double temp = score*(voteAmount-1); // Total score before adding new incoming score
    score = (temp+_score)/(voteAmount); // New incoming score is adding to total score and average is calculating again, according to updated vote amount.
    return score;
  }

  /**
     Dismissal Conditions:
     * There should be at least 10 given votes for considering score.
     * If vote amount is reasonable, workers that has less score value than 4 should be fired.
     * @return boolean value is false for "don't fire", and true for "fire"
  */
  public boolean dismissalControl(){
    if(this.getVoteAmount() < 10)
      return false;
    else{
      if(this.getScore() < 4)
        return true;
      else 
        return false;
    }
  }
}
