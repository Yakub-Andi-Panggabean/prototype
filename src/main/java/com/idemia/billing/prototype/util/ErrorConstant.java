package com.idemia.billing.prototype.util;

public enum ErrorConstant {


  INTERNAL_ERROR(0, "INTERNAL_ERROR"), CREDENTIAL_ERROR(1, "CREDENTIAL_ERROR");

  private final int code;
  private final String message;

  private ErrorConstant(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }



}
