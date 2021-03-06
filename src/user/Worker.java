package src.user;

import src.constants.WorkerStatus;

/**
 * Worker class is a subclass of User class which represents the Workers of the restaurant.
 */
public class Worker extends User {

  /**
   Status of the worker will be change according to it's experience year, certificate number etc. 
  */

  /** job of the worker */
  private String job;
  /** salary of the worker */
  private double salary;
  /** score of the worker */
  private double score = 4.0;
  /** experience of the worker */
  private int experienceYear;
  /**  number of votes given to the worker*/
  private int voteAmount = 1;
  /** status of the worker */
  protected WorkerStatus workerStat;

  /**
   * Constructor of the Worker class
   * @param _name the name of the worker
   * @param _age the age of the worker
   * @param _username the username of the worker
   * @param _password the password of the worker
   * @param _job the job of the worker
   * @param _experienceYear the experience year of the worker
   */
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

  /**
   * This function returns the job of the worker.
   *
   * @return The job of the worker is being returned.
   */
  public String getJob() {
    return job;
  }

  /**
   * This function returns the salary of the worker.
   *
   * @return The salary of the worker.
   */
  public double getSalary() {
    return salary;
  }

  /**
   * This function returns the score of the worker
   *
   * @return The score of the worker.
   */
  public double getScore() {
    return score;
  }

  /**
   * This function returns the experienceYear of the worker.
   *
   * @return The experienceYear of the worker.
   */
  public int getExperienceYear() {
    return experienceYear;
  }

  /**
   * This function sets the salary of the worker to the value of the parameter newSalary.
   *
   * @param newSalary The new salary for the worker.
   */
  public void setSalary(double newSalary) {
    salary = newSalary;
  }

  /**
   * This function sets the score of the worker to the value of the parameter score.
   *
   * @param score The score of the worker.
   */
  public void setScore(double score) {
    this.score = score;
  }

  /**
   * This function returns the vote amount.
   *
   * @return The voteAmount of the worker
   */
  public int getVoteAmount() {
    return voteAmount;
  }

  /**
   * Salary of the worker will be calculated according to that worker's WorkerStatus.
   * An initial amount will be assigned to beginner status, and it will increase with increment of status.
   * @param initialSalary The initial salary of the worker.
   */
  protected void calculateSalary(double initialSalary) {
    switch (workerStat) {
      case BEGINNER:
        this.setSalary(initialSalary + (50 * getExperienceYear()));
        break;
      case JUNIOR:
        this.setSalary(initialSalary + 1000 + (100 * getExperienceYear()));
        break;
      case MID_LEVEL:
        this.setSalary(initialSalary + 3000 + (150 * getExperienceYear()));
        break;
      case SENIOR:
        this.setSalary(initialSalary + 5000 + (200 * getExperienceYear()));
        break;
    }
  }

  /**
   * The function calculates the average score of the worker by adding the new incoming score to the total
   * score and dividing it by the updated vote amount.
   *
   * @param _score The score that is coming from the user.
   * @return The average score of the worker.
   */
  public double calculateAverageScore(int _score) {
    // Total score before adding new incoming score
    double temp = score * (voteAmount);
    // New incoming score is adding to total score and average is calculating again, according to updated vote amount.
    score = (temp + _score) / (++voteAmount);
    return score;
  }

  /**
     Dismissal Conditions:
     * There should be at least 10 given votes for considering score.
     * If vote amount is reasonable, workers that has less score value than 4 should be fired.
     * @return boolean value is false for "don't fire", and true for "fire"
  */
  public boolean dismissalControl() {
    if (this.getVoteAmount() < 10) return false; else {
      if (this.getScore() < 4) return true; else return false;
    }
  }


/**
 * If the name of this user is less than the name of the other user, return a negative number; if the
 * name of this user is greater than the name of the other user, return a positive number; if the names
 * are equal, return 0.
 * 
 * @param other The other user to compare to.
 * @return The name of the user.
 */
  @Override
  public int compareTo(User other) {
    return getName().compareTo(other.getName());
  }

  /**
   * The function returns a string that contains the information of the worker
   *
   * @return The toString method is being returned.
   */
  @Override
  public String toString() {
    StringBuilder workerInfo = new StringBuilder();
    workerInfo.append(super.toString() + "\n");
    workerInfo.append("Job: " + this.getJob() + "\n");
    workerInfo.append("Salary: " + this.getSalary() + "\n");
    workerInfo.append("Score: " + this.getScore() + "\n");
    workerInfo.append("Experience Year: " + this.getExperienceYear() + "\n");
    workerInfo.append("Vote Amount: " + this.getVoteAmount() + "\n");
    workerInfo.append("Worker Status: " + this.workerStat + "\n");
    return workerInfo.toString();
  }
}
