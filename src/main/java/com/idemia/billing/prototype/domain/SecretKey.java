package com.idemia.billing.prototype.domain;

import java.util.Date;

public class SecretKey {

  private int userId;
  private String token;
  private Date createdDate;
  private long timeToLive;

  public SecretKey() {
    super();
    // TODO Auto-generated constructor stub
  }

  public SecretKey(int userId, String token, Date createdDate, long timeToLive) {
    super();
    this.userId = userId;
    this.token = token;
    this.createdDate = createdDate;
    this.timeToLive = timeToLive;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public long getTimeToLive() {
    return timeToLive;
  }

  public void setTimeToLive(long timeToLive) {
    this.timeToLive = timeToLive;
  }



}
