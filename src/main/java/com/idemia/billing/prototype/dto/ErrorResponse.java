package com.idemia.billing.prototype.dto;

import com.idemia.billing.prototype.util.ErrorConstant;

public class ErrorResponse {

  private int errorCode;
  private String description;

  public ErrorResponse() {
    super();
  }

  public ErrorResponse(ErrorConstant constant) {
    super();
    errorCode = constant.getCode();
    description = constant.getMessage();
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }



}
