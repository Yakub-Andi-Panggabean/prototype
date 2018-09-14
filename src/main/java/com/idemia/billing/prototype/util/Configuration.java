package com.idemia.billing.prototype.util;

import java.util.function.Consumer;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class Configuration {


  private static final String CONFIG_TYPE = "file";
  private static final String CONFIG_FORMAT = "properties";

  private final ConfigRetriever configRetriever;

  public Configuration(Vertx vertx, String configLocation) {
    super();

    final ConfigStoreOptions storeOption = new ConfigStoreOptions().setType(CONFIG_TYPE)
        .setFormat(CONFIG_FORMAT).setConfig(new JsonObject().put("path", configLocation));

    final ConfigRetrieverOptions configRetrieveOptions =
        new ConfigRetrieverOptions().addStore(storeOption);

    configRetriever = ConfigRetriever.create(vertx, configRetrieveOptions);

  }


  public void getConfiguration(Consumer<JsonObject> value, Consumer<Throwable> ex) {

    configRetriever.getConfig(handler -> {

      if (handler.succeeded()) {

        value.accept(handler.result());

      } else {

        ex.accept(handler.cause());

      }

    });

  }



}
