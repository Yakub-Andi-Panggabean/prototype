package com.idemia.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idemia.prototype.handler.HttpHandler;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;


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
  public static final String JOB_PATH = "/job";


  private final JsonObject configuration;

  public ServerVerticle(JsonObject configuration) {
    super();
    this.configuration = configuration;
  }

  @Override
  public void start() throws Exception {

    LOG.info("starting Http Server Verticle");

    final Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());

    final HttpHandler httpHandler = new HttpHandler(configuration);

    router.get("/").handler(httpHandler::handleRootContext);
    router.post(AUTHENTICATION_PATH).handler(httpHandler::handleAuthenticationRequest);
    router.post(JOB_PATH).handler(httpHandler::handleSearchJobRequest);

    vertx.createHttpServer().requestHandler(router::accept)
        .listen(configuration.getInteger("server.port"), handler -> {

          if (handler.failed()) {

            LOG.error("failed to start server with port : {} cause : {}",
                configuration.getInteger("server.port"), handler.cause().getMessage());

          } else {

            LOG.info("successfully start server with port {}",
                configuration.getInteger("server.port"));

          }

        });

  }

  @Override
  public void stop() throws Exception {

    super.stop();
    LOG.info("stoping server verticle");


  }



}
