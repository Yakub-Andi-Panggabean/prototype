package com.idemia.billing.prototype.handler;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idemia.billing.prototype.domain.Credential;
import com.idemia.billing.prototype.domain.User;
import com.idemia.billing.prototype.dto.ErrorResponse;
import com.idemia.billing.prototype.service.AuthenticationService;
import com.idemia.billing.prototype.service.SecretKeyService;
import com.idemia.billing.prototype.service.TokenService;
import com.idemia.billing.prototype.service.UserService;
import com.idemia.billing.prototype.service.bean.AuthenticationServiceBean;
import com.idemia.billing.prototype.service.bean.SecretKeyServiceBean;
import com.idemia.billing.prototype.service.bean.UserServiceBean;
import com.idemia.billing.prototype.util.ErrorConstant;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class HttpHandler {

  private static final Logger LOG = LoggerFactory.getLogger(HttpHandler.class);

  private final String CONTENT_TYPE_HEADER = "content-type";
  private final String AUTHORIZATION_HEADER = "Authorization";
  private final String HTML_CONTENT_TYPE = "text/html";
  private final String JSON_CONTENT_TYPE = "application/json";



  private final AuthenticationService authenticationService;
  private final SecretKeyService secretKeyService;
  private final UserService userService;
  private TokenService tokenService;

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
    user.setBirthDate(LocalDateTime.now());
    user.setCountry(request.getParam("country"));
    user.setName(request.getParam("name"));

    userService.register(user, success -> {

    }, error -> {

    });

  }



  /**
   *
   * Handle authentication request, this handler will return JWT which will be used for the next
   * request until the JWT is expired
   *
   * @param context vert.x routing context
   */
  public void handleAuthenticationRequest(RoutingContext context) {

    final HttpServerRequest request = context.request();

    final Credential credential =
        new Credential(request.getParam("username"), request.getParam("password"));

    authenticationService.authenticate(credential, user -> {

      if (null != user) {

        tokenService.generateToken(user, token -> {

          context.response().putHeader(CONTENT_TYPE_HEADER, HTML_CONTENT_TYPE).end(token);

        }, err -> {

          context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
              .end(Json.encode(new ErrorResponse(ErrorConstant.INTERNAL_ERROR)));

        });

      } else {

        context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
            .end(Json.encode(new ErrorResponse(ErrorConstant.CREDENTIAL_ERROR)));

      }

    }, err -> {

      context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
          .end(Json.encode(new ErrorResponse(ErrorConstant.INTERNAL_ERROR)));

    });

  }

}
