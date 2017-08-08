package com.dpesmdr20.mypunchin.Utils;

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by dimanandhar on 8/7/17.
 */
public class RouteHandlers {
    public static void checkUser(RoutingContext routingContext){
        String name = null, pass = null;
        name = routingContext.request().getParam("username");
        pass = routingContext.request().getParam("password");
        EventBus eb = ConfigProvider.getInstance().getEventBus();
        eb.send("login_request",routingContext.request(),event -> {
            if(event.succeeded())
            {
                routingContext.response().setStatusCode(200).putHeader("content-type", "application/json").end("hello");
                routingContext.response().close();

            }
        });

    }

    private static boolean doesUserExist(String uname,String upass) {
        return (uname.equals("admin")&&upass.equals("admin"));
    }
}
