package com.idemia.billing.prototype.service;

import java.util.function.Consumer;

import com.idemia.billing.prototype.domain.Credential;
import com.idemia.billing.prototype.domain.User;

public interface AuthenticationService {

  void authenticate(Credential credential, Consumer<User> authenticated, Consumer<Exception> error);

}
