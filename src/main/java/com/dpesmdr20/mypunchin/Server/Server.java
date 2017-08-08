package com.dpesmdr20.mypunchin.Server;

import com.dpesmdr20.mypunchin.Utils.ConfigProvider;
import com.dpesmdr20.mypunchin.Utils.RouteHandlers;
import com.dpesmdr20.mypunchin.Utils.UrlHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
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
        confProvider.setVertx(vertx);
        confProvider.setEventBus(vertx.eventBus());
        Router router = Router.router(vertx);
        router.route("/web-app/*").handler(StaticHandler.create("web-app"));

        router.get("/login/").handler(RouteHandlers::checkUser);

        deployVerticles();
        vertx.createHttpServer().requestHandler(router::accept).listen(confProvider.getConfig().getInteger("port"));
    }
    private void deployVerticles() {
        vertx.deployVerticle("com.dpesmdr20.mypunchin.Verticles.LoginVerticle");
    }
}
