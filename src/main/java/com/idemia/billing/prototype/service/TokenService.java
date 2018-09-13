package com.idemia.billing.prototype.service;

import java.util.function.Consumer;

import com.idemia.billing.prototype.domain.User;

public interface TokenService {

  void generateToken(User user, Consumer<String> token, Consumer<Exception> err);

}
