package com.idemia.prototype.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idemia.prototype.domain.Credential;
import com.idemia.prototype.repository.bean.JobRepositoryBean;
import com.idemia.prototype.service.AuthenticationService;
import com.idemia.prototype.service.JobService;
import com.idemia.prototype.service.TokenService;
import com.idemia.prototype.service.UserService;
import com.idemia.prototype.service.bean.AuthenticationServiceBean;
import com.idemia.prototype.service.bean.JobServiceBean;
import com.idemia.prototype.service.bean.TokenServiceBean;
import com.idemia.prototype.service.bean.UserServiceBean;
import com.idemia.prototype.util.BasicAuthEncoder;
import com.idemia.prototype.util.Errors;

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
  private final UserService userService;
  private final TokenService tokenService;
  private final JobService jobService;

  public HttpHandler() {
    super();
    authenticationService = new AuthenticationServiceBean();
    userService = new UserServiceBean();
    tokenService = new TokenServiceBean();
    jobService = new JobServiceBean(new JobRepositoryBean());
  }

  public void handleRootContext(RoutingContext context) {

    final HttpServerRequest request = context.request();

    LOG.debug("incoming request {} from {}", request.path(), request.remoteAddress());

    context.response().putHeader(CONTENT_TYPE_HEADER, HTML_CONTENT_TYPE)
        .end("<h1>root context</h1>");

  }



  public void handleSearchJobRequest(RoutingContext context) {

    final HttpServerRequest request = context.request();

    final String token = request.getHeader(AUTHORIZATION_HEADER);

    tokenService.parseToken(token, claim -> {

      // assume that all user is valid user

      jobService.displayJobs(null, res -> {

        context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE).end(Json.encode(res));

      }, err -> {

        context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
            .end(Json.encode(Errors.INTERNAL_ERROR.error()));


      });



    }, err -> {

      context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
          .end(Json.encode(Errors.INVALID_TOKEN_ERROR.error()));

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

    final String basicAuthentication = request.getHeader(AUTHORIZATION_HEADER);

    try {

      final String[] auth =
          BasicAuthEncoder.decodeBasicAuthentication(basicAuthentication).split(":");

      if (auth.length < 2) {

        context.response().putHeader(CONTENT_TYPE_HEADER, HTML_CONTENT_TYPE)
            .end(Json.encode(Errors.CREDENTIAL_ERROR.error()));

      } else {

        final Credential credential =
            new Credential(request.getParam(auth[0]), request.getParam(auth[1]));

        authenticationService.authenticate(credential, user -> {

          if (null != user) {

            tokenService.generateToken(user, token -> {

              context.response().putHeader(CONTENT_TYPE_HEADER, HTML_CONTENT_TYPE).end(token);

            }, err -> {

              context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
                  .end(Json.encode(Errors.INTERNAL_ERROR.error()));

            });

          } else {

            context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
                .end(Json.encode(Errors.CREDENTIAL_ERROR.error()));

          }

        }, err -> {

          context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
              .end(Json.encode(Errors.INTERNAL_ERROR.error()));

        });


      }

    } catch (final Exception e) {

      context.response().putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
          .end(Json.encode(Errors.INVALID_AUTHENTICATION_TOKEN.error()));


    }



  }

}
