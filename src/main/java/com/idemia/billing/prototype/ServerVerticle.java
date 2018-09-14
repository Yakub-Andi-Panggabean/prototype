package com.idemia.billing.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idemia.billing.prototype.handler.HttpHandler;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;


/**
 *
 *
 * Http Server entry point
 *
 * @author yakub
 */
public class ServerVerticle extends AbstractVerticle {


  private static final Logger LOG = LoggerFactory.getLogger(ServerVerticle.class);

  public static final String AUTHENTICATION_PATH = "/auth";
  public static final String SECRET_KEY_PATH = "/key";

  private final int port;

  public ServerVerticle(int port) {
    super();
    this.port = port;
  }

  @Override
  public void start() throws Exception {

    LOG.info("starting Http Server Verticle");

    final Router router = Router.router(vertx);

    final HttpHandler httpHandler = new HttpHandler();

    router.get("/").handler(httpHandler::handleRootContext);
    router.post(AUTHENTICATION_PATH).handler(httpHandler::handleAuthenticationRequest);
    router.post(SECRET_KEY_PATH).handler(httpHandler::handleSecretKeyRequest);

    vertx.createHttpServer().requestHandler(router::accept).listen(port, handler -> {

      if (handler.failed()) {

        LOG.error("failed to start server with port : {} cause : {}", port,
            handler.cause().getMessage());

      } else {

        LOG.info("successfully start server with port {}", port);

      }

    });

  }

  @Override
  public void stop() throws Exception {

    super.stop();
    LOG.info("stoping server verticle");


  }



}
