package com.idemia.billing.prototype.service.bean;

import java.util.function.Consumer;

import com.idemia.billing.prototype.domain.User;
import com.idemia.billing.prototype.service.TokenService;

public class TokenServiceBean implements TokenService {


  @Override
  public void generateToken(User user, Consumer<String> token, Consumer<Exception> err) {



  }

}
