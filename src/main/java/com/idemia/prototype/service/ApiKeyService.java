package com.idemia.prototype.service;

import java.util.function.Consumer;

import com.idemia.prototype.domain.Credential;
import com.idemia.prototype.domain.User;

public interface ApiKeyService {

  void generateApiKey(Credential credential, Consumer<String> secretKey, Consumer<Exception> error);

  boolean isApiKeyValid(User user, String secretKey);

}
