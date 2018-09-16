package com.idemia.prototype.exception;

import com.idemia.prototype.util.Errors;

public class ApplicationException extends Exception {

  private static final long serialVersionUID = 8634045407976367951L;

  private Errors error;

  public ApplicationException() {
    super();
  }

  public ApplicationException(Errors error) {
    super(error.toString());
    this.error = error;
  }

  public ApplicationException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApplicationException(String message) {
    super(message);
  }

  public ApplicationException(Throwable cause) {
    super(cause);
  }

  public Errors toError() {
    return error;
  }



}
