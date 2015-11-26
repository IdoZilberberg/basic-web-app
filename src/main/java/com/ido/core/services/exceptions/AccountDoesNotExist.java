package com.ido.core.services.exceptions;

/**
 * Created by Ido Zilberberg on 11/26/2015.
 */
public class AccountDoesNotExist extends RuntimeException {

  public AccountDoesNotExist(Throwable cause) {
    super(cause);
  }

  public AccountDoesNotExist(String message, Throwable cause) {
    super(message, cause);
  }

  public AccountDoesNotExist(String message) {
    super(message);
  }

}
