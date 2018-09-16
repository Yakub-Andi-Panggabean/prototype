package com.idemia.prototype.domain;

public class Company {

  private String name;
  private String address;

  public Company() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Company(String name, String address) {
    super();
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Company [name=" + name + ", location=" + address + "]";
  }



}
