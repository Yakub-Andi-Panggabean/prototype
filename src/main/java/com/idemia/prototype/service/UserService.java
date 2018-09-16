package com.idemia.prototype.service;

import java.util.function.Consumer;

import com.idemia.prototype.domain.User;

public interface UserService {

  void register(User user, Consumer<Boolean> onSuccess, Consumer<Exception> onError);

  boolean disable(User user);

  boolean update(User user);

}
