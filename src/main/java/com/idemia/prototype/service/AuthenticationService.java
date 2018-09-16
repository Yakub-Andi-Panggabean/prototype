package com.idemia.prototype.service;

import java.util.function.Consumer;

import com.idemia.prototype.domain.Credential;
import com.idemia.prototype.domain.User;

public interface AuthenticationService {

  void authenticate(Credential credential, Consumer<User> authenticated, Consumer<Exception> error);

}
