package com.idemia.prototype.domain;

import java.util.List;

public class JobSearch {

  private Location location;
  private Level level;
  private Salary salary;
  private List<JobSpecialization> specialization;

  public JobSearch(Location location, Level level, Salary salary,
      List<JobSpecialization> specialization) {
    super();
    this.location = location;
    this.level = level;
    this.salary = salary;
    this.specialization = specialization;
  }

  public JobSearch() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public Salary getSalary() {
    return salary;
  }

  public void setSalary(Salary salary) {
    this.salary = salary;
  }

  public List<JobSpecialization> getSpecialization() {
    return specialization;
  }

  public void setSpecialization(List<JobSpecialization> specialization) {
    this.specialization = specialization;
  }

  @Override
  public String toString() {
    return "JobSearch [location=" + location + ", level=" + level + ", salary=" + salary
        + ", specialization=" + specialization + "]";
  }



}
