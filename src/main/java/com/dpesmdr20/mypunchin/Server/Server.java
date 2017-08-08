package com.dpesmdr20.mypunchin.Server;

import com.dpesmdr20.mypunchin.Utils.ConfigProvider;
import com.dpesmdr20.mypunchin.Utils.UrlHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dpesmdr on 8/6/17.
 */
public class Server extends AbstractVerticle{
    private ConfigProvider confProvider;

    @Override
    public void start() {
        confProvider = ConfigProvider.getInstance();
        confProvider.setConfig(vertx.getOrCreateContext().config());

        Router router = Router.router(vertx);
        //router = UrlHandler.getRoutes(router);
        router.route("/templates/*").handler(StaticHandler.create("web-app/app/templates"));
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

    public boolean checkUser(String uname,String pass){
        return (uname.equals("admin") && pass.equals("admin"));
    }

}
