package com.idemia.billing.prototype.service;

import com.idemia.billing.prototype.domain.Credential;

public interface AuthenticationService {

  boolean authenticate(Credential credential);

}
