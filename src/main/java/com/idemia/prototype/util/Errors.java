package com.idemia.prototype.util;

import java.io.Serializable;

public enum Errors {


  INTERNAL_ERROR(0, "INTERNAL_ERROR"), CREDENTIAL_ERROR(1, "CREDENTIAL_ERROR"), INVALID_TOKEN_ERROR(
      3, "INVALID_TOKEN"), EXPIRED_TOKEN_ERROR(31, "EXPIRED_TOKEN_ERROR"), NOT_BEFORE_TOKEN_ERROR(
          32, "NOT_BEFORE_TOKEN_ERROR"), INVALID_AUTHENTICATION_TOKEN(33,
              "INVALID_AUTHENTICATION_TOKEN");


  private ApiError apiError;

  private Errors(int code, String message) {
    apiError = new ApiError(code, message);
  }


  public ApiError error() {

    return apiError;

  }



  class ApiError implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int code;
    private final String message;

    public ApiError(int code, String message) {
      super();
      this.code = code;
      this.message = message;
    }


    public int getCode() {
      return code;
    }

    public String getMessage() {
      return message;
    }

    @Override
    public String toString() {
      return "ApiError [code=" + code + ", message=" + message + "]";
    }



  }



}
