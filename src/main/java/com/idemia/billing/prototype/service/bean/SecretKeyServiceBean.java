package com.idemia.billing.prototype.service.bean;

import java.util.function.Consumer;

import com.idemia.billing.prototype.domain.Credential;
import com.idemia.billing.prototype.service.SecretKeyService;

public class SecretKeyServiceBean implements SecretKeyService {

  @Override
  public void generateSecretKey(Credential credential, Consumer<String> secretKey,
      Consumer<Exception> error) {

  }

  @Override
  public boolean isSecretKeyValid(String secretKey) {

    return false;
  }

}
