package com.idemia.prototype.exception;

import com.idemia.prototype.util.Errors;

public class InvalidTokenException extends Exception {

  private static final long serialVersionUID = 8634045407976367951L;

  private Errors error;

  public InvalidTokenException() {
    super();
  }

  public InvalidTokenException(Errors error) {
    super(error.toString());
    this.error = error;
  }

  public InvalidTokenException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidTokenException(String message) {
    super(message);
  }

  public InvalidTokenException(Throwable cause) {
    super(cause);
  }

  public Errors toError() {
    return error;
  }



}
