package com.idemia.billing.prototype.domain;

import java.time.LocalDateTime;

public class Role {

  private int id;
  private String name;
  private String description;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  public Role() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Role(int id, String name, String description, LocalDateTime createdDate,
      LocalDateTime updatedDate) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
    return "Role [id=" + id + ", name=" + name + ", description=" + description + ", createdDate="
        + createdDate + ", updatedDate=" + updatedDate + "]";
  }



}
