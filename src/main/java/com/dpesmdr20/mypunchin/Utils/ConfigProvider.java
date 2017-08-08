package com.dpesmdr20.mypunchin.Utils;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

/**
 * Created by dpesmdr on 8/6/17.
 */
public class ConfigProvider {
    private JsonObject config;
    private static ConfigProvider instance = null;
    private Vertx vertx;
    private EventBus eventBus;


    public static ConfigProvider getInstance(){
        if(instance==null)
            instance = new ConfigProvider();
        return instance;
    }

    public JsonObject getConfig() {
        return config;
    }

    public void setConfig(JsonObject config) {
        this.config = config;
    }

    public Vertx getVertx() {
        return vertx;
    }

    public void setVertx(Vertx vertx) {
        this.vertx = vertx;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
