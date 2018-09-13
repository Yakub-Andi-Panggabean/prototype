package com.idemia.billing.prototype.service;

import java.util.function.Consumer;

import com.idemia.billing.prototype.domain.Credential;

public interface AuthenticationService {

  void authenticate(Credential credential, Consumer<Boolean> authenticated,
      Consumer<Exception> error);

}
