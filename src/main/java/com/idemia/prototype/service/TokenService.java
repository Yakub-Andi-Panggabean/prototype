package com.idemia.prototype.service;

import java.util.function.Consumer;

import com.idemia.prototype.domain.User;
import com.idemia.prototype.exception.ApplicationException;

import io.jsonwebtoken.Claims;

public interface TokenService {

  void generateToken(User user, Consumer<String> token, Consumer<Exception> err);

  void parseToken(String token, Consumer<Claims> isValid, Consumer<ApplicationException> err);

}
