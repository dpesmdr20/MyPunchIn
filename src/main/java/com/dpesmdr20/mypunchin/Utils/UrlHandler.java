package com.dpesmdr20.mypunchin.Utils;

import com.dpesmdr20.mypunchin.Server.Server;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by dimanandhar on 8/7/17.
 */
public class UrlHandler {
    public static Router getRoutes(Router router) {
        router.route().handler(BodyHandler.create());
        router.get("/login/username:uname&password:pass").handler(RouteHandlers::checkUser);
        return router;
    }
}
//http://localhost:9000/MyPunchIn/login/?username=dfdf&password=dfdf