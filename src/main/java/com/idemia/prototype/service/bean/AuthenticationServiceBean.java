package com.idemia.prototype.service.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idemia.prototype.domain.Credential;
import com.idemia.prototype.domain.Location;
import com.idemia.prototype.domain.User;
import com.idemia.prototype.exception.ApplicationException;
import com.idemia.prototype.service.AuthenticationService;
import com.idemia.prototype.util.Errors;

import io.vertx.core.json.JsonObject;

public class AuthenticationServiceBean implements AuthenticationService {

  private static final Logger LOG = LoggerFactory.getLogger(AuthenticationServiceBean.class);

  private final JsonObject configuration;

  public AuthenticationServiceBean(JsonObject configuration) {
    super();
    this.configuration = configuration;
  }


  @Override
  public void authenticate(Credential credential, Consumer<User> authenticated,
      Consumer<ApplicationException> error) {


    final String username = configuration.getString("prototype.user");
    final String password = configuration.getString("prototype.password");

    LOG.info("username : {}, password : {}, credential : {}", username, password, credential);

    if (username.equals(credential.getUsername()) && password.equals(credential.getPassword())) {

      authenticated.accept(new User(1, credential.getUsername(), credential.getPassword(),
          "Indonesia", true, LocalDate.of(1990, 12, 12), LocalDateTime.now().minusDays(30), null,
          null, new Location(1837434378, -1748734834)));

    } else {

      error.accept(new ApplicationException(Errors.CREDENTIAL_ERROR));

    }



  }



}
