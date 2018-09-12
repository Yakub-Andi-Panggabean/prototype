package com.idemia.billing.prototype.service;

import java.util.function.Consumer;

import com.idemia.billing.prototype.domain.Credential;

public interface SecretKeyService {

  void generateSecretKey(Credential credential, Consumer<String> secretKey,
      Consumer<Exception> error);

  boolean isSecretKeyValid(String secretKey);

}
