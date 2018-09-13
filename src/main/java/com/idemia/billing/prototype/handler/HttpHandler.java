package com.idemia.billing.prototype.handler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idemia.billing.prototype.domain.Credential;
import com.idemia.billing.prototype.domain.User;
import com.idemia.billing.prototype.service.AuthenticationService;
import com.idemia.billing.prototype.service.SecretKeyService;
import com.idemia.billing.prototype.service.UserService;
import com.idemia.billing.prototype.service.bean.AuthenticationServiceBean;
import com.idemia.billing.prototype.service.bean.SecretKeyServiceBean;
import com.idemia.billing.prototype.service.bean.UserServiceBean;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;

public class HttpHandler {

  private static final Logger LOG = LoggerFactory.getLogger(HttpHandler.class);

  private final String CONTENT_TYPE_HEADER = "content-type";
  private final String AUTHORIZATION_HEADER = "Authorization";
  private final String HTML_CONTENT_TYPE = "";



  private final AuthenticationService authenticationService;
  private final SecretKeyService secretKeyService;
  private final UserService userService;

  public HttpHandler() {
    super();
    authenticationService = new AuthenticationServiceBean();
    secretKeyService = new SecretKeyServiceBean();
    userService = new UserServiceBean();
  }

  public void handleRootContext(RoutingContext context) {

    final HttpServerRequest request = context.request();

    LOG.debug("incoming request {} from {}", request.path(), request.remoteAddress());

    context.response().putHeader(CONTENT_TYPE_HEADER, HTML_CONTENT_TYPE)
        .end("<h1>root context</h1>");

  }

  public void handleSecretKeyRequest(RoutingContext context) {


    final HttpServerRequest request = context.request();


    // get authorization header
    final String token = request.getHeader(AUTHORIZATION_HEADER);

    final Credential credential =
        new Credential(request.getParam("username"), request.getParam("password"));

    secretKeyService.generateSecretKey(credential, secretKey -> {

    }, error -> {

    });


  }

  public void handleUserRegistrationRequest(RoutingContext context) {

    final HttpServerRequest request = context.request();

    final User user = new User();

    user.setActive(false);
    user.setBirthDate(new Date());
    user.setCountry(request.getParam("country"));
    user.setName(request.getParam("name"));

    userService.register(user, success -> {



    }, error -> {



    });

  }


  public void handleAuthenticationRequest(RoutingContext context) {

    final HttpServerRequest request = context.request();

    final Credential credential =
        new Credential(request.getParam("username"), request.getParam("password"));

    authenticationService.authenticate(credential, authenticated -> {



      if (authenticated) {

      }

    }, err -> {

    });



  }

}
