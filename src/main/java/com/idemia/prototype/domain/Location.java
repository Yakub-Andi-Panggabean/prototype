package com.idemia.prototype.domain;

public class Location {

  private long longitude;
  private long latitude;

  public Location() {
    super();
  }

  public Location(long longitude, long latitude) {
    super();
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public long getLongitude() {
    return longitude;
  }

  public void setLongitude(long longitude) {
    this.longitude = longitude;
  }

  public long getLatitude() {
    return latitude;
  }

  public void setLatitude(long latitude) {
    this.latitude = latitude;
  }

  @Override
  public String toString() {
    return "Location [longitude=" + longitude + ", latitude=" + latitude + "]";
  }



}
