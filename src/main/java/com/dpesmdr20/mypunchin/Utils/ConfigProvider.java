package com.dpesmdr20.mypunchin.Utils;

import io.vertx.core.json.JsonObject;

/**
 * Created by dpesmdr on 8/6/17.
 */
public class ConfigProvider {
    private JsonObject config;
    private static ConfigProvider instance = null;


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
}
