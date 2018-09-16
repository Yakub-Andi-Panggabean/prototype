package com.idemia.prototype.service.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Consumer;

import com.idemia.prototype.domain.Credential;
import com.idemia.prototype.domain.Location;
import com.idemia.prototype.domain.User;
import com.idemia.prototype.service.AuthenticationService;

public class AuthenticationServiceBean implements AuthenticationService {

  @Override
  public void authenticate(Credential credential, Consumer<User> authenticated,
      Consumer<Exception> error) {

    authenticated.accept(new User(1, credential.getUsername(), credential.getPassword(),
        "Indonesia", true, LocalDate.of(1990, 12, 12), LocalDateTime.now().minusDays(30), null,
        null, new Location(1837434378, -1748734834)));

  }



}
