package com.idemia.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idemia.prototype.util.Configuration;

import io.vertx.core.Vertx;

public class Application {

  private static final Logger LOG = LoggerFactory.getLogger(Application.class);

  public static void main(String args[]) {

    final Vertx vertx = Vertx.vertx();

    final Configuration config = new Configuration(vertx, System.getProperty("conf.location"));

    config.getConfiguration(configuration -> {

      LOG.info("configuration file loaded {}", System.getProperty("conf.location"));
      vertx.deployVerticle(new ServerVerticle(configuration));

    }, ex -> {

      LOG.error("failed to load configuration file exeption : {}", ex.getMessage());

    });



  }

}
