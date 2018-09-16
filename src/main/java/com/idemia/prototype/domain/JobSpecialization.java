package com.idemia.prototype.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JobSpecialization {

  private String name;
  @JsonIgnore
  private LocalDateTime createdDate;
  @JsonIgnore
  private LocalDateTime updatedDate;

  public JobSpecialization() {
    super();
  }

  public JobSpecialization(String name, LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.name = name;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }



  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public LocalDateTime getCreatedDate() {
    return createdDate;
  }



  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }



  public LocalDateTime getUpdatedDate() {
    return updatedDate;
  }



  public void setUpdatedDate(LocalDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }



  @Override
  public String toString() {
    return "JobSpecialization [name=" + name + ", createdDate=" + createdDate + ", updatedDate="
        + updatedDate + "]";
  }



}
