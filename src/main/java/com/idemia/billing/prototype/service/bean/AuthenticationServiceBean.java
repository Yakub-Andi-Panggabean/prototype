package com.idemia.billing.prototype.service.bean;

import com.idemia.billing.prototype.domain.Credential;
import com.idemia.billing.prototype.service.AuthenticationService;

public class AuthenticationServiceBean implements AuthenticationService {

  @Override
  public boolean authenticate(Credential credential) {

    return false;
  }

}
