package com.idemia.prototype.service;

import java.util.function.Consumer;

import com.idemia.prototype.domain.Credential;
import com.idemia.prototype.domain.User;
import com.idemia.prototype.exception.ApplicationException;

public interface AuthenticationService {

  void authenticate(Credential credential, Consumer<User> authenticated,
      Consumer<ApplicationException> error);

}
