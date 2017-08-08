package com.dpesmdr20.mypunchin.Verticles;

import com.dpesmdr20.mypunchin.Utils.Database;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

/**
 * Created by dimanandhar on 8/8/17.
 */
public class LoginVerticle extends AbstractVerticle {

    @Override
    public void start(){
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer("login_request",event -> {
            Database database = new Database();
            database.query(resultSet->{
                JsonObject object = new JsonObject();
                object.put("login",resultSet.getRows());
            });
        });
    }
}
