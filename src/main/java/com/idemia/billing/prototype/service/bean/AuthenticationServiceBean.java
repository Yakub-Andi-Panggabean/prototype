package com.idemia.billing.prototype.service.bean;

import java.util.function.Consumer;

import com.idemia.billing.prototype.domain.Credential;
import com.idemia.billing.prototype.domain.User;
import com.idemia.billing.prototype.service.AuthenticationService;

public class AuthenticationServiceBean implements AuthenticationService {

  @Override
  public void authenticate(Credential credential, Consumer<User> authenticated,
      Consumer<Exception> error) {



  }



}
