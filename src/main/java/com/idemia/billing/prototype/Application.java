package com.idemia.billing.prototype;

import com.idemia.billing.prototype.handler.HttpHandler;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;


/**
 *
 * @author yakub
 *
 *
 */
public class Application extends AbstractVerticle {


  @Override
  public void start() throws Exception {

    final Router router = Router.router(vertx);

    final HttpHandler httpHandler = new HttpHandler();

    router.get("/").handler(httpHandler::handleRootContext);


    vertx.createHttpServer().requestHandler(router::accept).listen(9090);

  }



}
