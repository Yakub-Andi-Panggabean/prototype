package com.idemia.billing.prototype.domain;

import java.util.Date;

public class User {

  private int id;
  private String name;
  private String country;
  private boolean active;
  private Date birthDate;



  public User() {
    super();
    // TODO Auto-generated constructor stub
  }

  public User(int id, String name, String country, boolean active, Date birthDate) {
    super();
    this.id = id;
    this.name = name;
    this.country = country;
    this.active = active;
    this.birthDate = birthDate;
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }



}
