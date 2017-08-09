package com.dpesmdr20.mypunchin.Utils;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.net.URLDecoder;

/**
 * Created by dimanandhar on 8/7/17.
 */
public class RouteHandlers {
    public static void checkUser(RoutingContext routingContext){
        String name = null, pass = null;
        name = routingContext.request().getParam("username");
        pass = routingContext.request().getParam("password");
        JsonObject jo = new JsonObject();
        jo.put("username",name);
        jo.put("password",pass);
        EventBus eb = ConfigProvider.getInstance().getEventBus();
        eb.send("login_request",jo,event -> {
            if(event.succeeded())
            {
                routingContext.response().setStatusCode(200).putHeader("content-type", "application/json").end(event.result().body().toString());
                routingContext.response().close();
            }
            else
                routingContext.response().setStatusMessage("Failed");
        });
    }
}
