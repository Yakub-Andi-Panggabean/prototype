package com.idemia.prototype.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Level {

  private int id;
  private String name;
  @JsonIgnore
  private LocalDateTime createdDateTime;
  @JsonIgnore
  private LocalDateTime updatedDateTime;

  public Level() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Level(int id, String name, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
    super();
    this.id = id;
    this.name = name;
    this.createdDateTime = createdDateTime;
    this.updatedDateTime = updatedDateTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(LocalDateTime createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public LocalDateTime getUpdatedDateTime() {
    return updatedDateTime;
  }

  public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
    this.updatedDateTime = updatedDateTime;
  }



}
