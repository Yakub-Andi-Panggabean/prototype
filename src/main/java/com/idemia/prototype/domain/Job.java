package com.idemia.prototype.domain;

import java.time.LocalDateTime;

public class Job {


  private Company company;
  private String jobTitle;
  private String place;
  private double distance;
  private JobSpecialization specialization;
  private Level level;
  private Salary salary;
  private LocalDateTime postDate;
  private LocalDateTime expiredDate;

  public Job() {
    super();
  }

  public Job(Company company, String jobTitle, String place, double distance,
      JobSpecialization specialization, Level level, Salary salary, LocalDateTime postDate,
      LocalDateTime expiredDate) {
    super();
    this.jobTitle = jobTitle;
    this.place = place;
    this.distance = distance;
    this.specialization = specialization;
    this.level = level;
    this.salary = salary;
    this.postDate = postDate;
    this.expiredDate = expiredDate;
    this.company = company;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public JobSpecialization getSpecialization() {
    return specialization;
  }

  public void setSpecialization(JobSpecialization specialization) {
    this.specialization = specialization;
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

  public LocalDateTime getPostDate() {
    return postDate;
  }

  public void setPostDate(LocalDateTime postDate) {
    this.postDate = postDate;
  }

  public LocalDateTime getExpiredDate() {
    return expiredDate;
  }

  public void setExpiredDate(LocalDateTime expiredDate) {
    this.expiredDate = expiredDate;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  @Override
  public String toString() {
    return "Job [company=" + company + ", jobTitle=" + jobTitle + ", place=" + place + ", distance="
        + distance + ", specialization=" + specialization + ", level=" + level + ", salary="
        + salary + ", postDate=" + postDate + ", expiredDate=" + expiredDate + "]";
  }



}
