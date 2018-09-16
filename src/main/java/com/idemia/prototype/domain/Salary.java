package com.idemia.prototype.domain;

import java.math.BigDecimal;

public class Salary {

  private String currency;
  private BigDecimal minimumRange;
  private BigDecimal maximumRange;

  public Salary() {
    super();
  }

  public Salary(String currency, BigDecimal minimumRange, BigDecimal maximumRange) {
    super();
    this.minimumRange = minimumRange;
    this.maximumRange = maximumRange;
    this.currency = currency;
  }

  public BigDecimal getMinimumRange() {
    return minimumRange;
  }

  public void setMinimumRange(BigDecimal minimumRange) {
    this.minimumRange = minimumRange;
  }

  public BigDecimal getMaximumRange() {
    return maximumRange;
  }

  public void setMaximumRange(BigDecimal maximumRange) {
    this.maximumRange = maximumRange;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Salary [currency=" + currency + ", minimumRange=" + minimumRange + ", maximumRange="
        + maximumRange + "]";
  }



}
