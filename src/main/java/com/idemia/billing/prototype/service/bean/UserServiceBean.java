package com.idemia.billing.prototype.service.bean;

import java.util.function.Consumer;

import com.idemia.billing.prototype.domain.User;
import com.idemia.billing.prototype.service.UserService;

public class UserServiceBean implements UserService {

  @Override
  public void register(User user, Consumer<Boolean> onSuccess, Consumer<Exception> onError) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean disable(User user) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean update(User user) {
    // TODO Auto-generated method stub
    return false;
  }

}
