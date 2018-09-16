package com.idemia.prototype.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class User {

  private int id;
  private String name;
  private String password;
  private String country;
  private boolean active;
  private LocalDate birthDate;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private List<Role> roles;
  private Location currentLocation;

  public User() {
    super();

  }

  public User(int id, String name, String password, String country, boolean active,
      LocalDate birthDate, LocalDateTime createdDate, LocalDateTime updatedDate, List<Role> roles,
      Location currentLocation) {
    super();
    this.id = id;
    this.name = name;
    this.password = password;
    this.country = country;
    this.active = active;
    this.birthDate = birthDate;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.roles = roles;
    this.currentLocation = currentLocation;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
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

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public Location getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(Location currentLocation) {
    this.currentLocation = currentLocation;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", country=" + country + ", active=" + active
        + ", birthDate=" + birthDate + ", createdDate=" + createdDate + ", updatedDate="
        + updatedDate + ", roles=" + roles + ", currentLocation=" + currentLocation + "]";
  }



}
