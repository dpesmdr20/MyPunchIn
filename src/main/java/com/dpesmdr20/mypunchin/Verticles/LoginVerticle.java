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
        eventBus.consumer("login_request",message -> {
            JsonObject request = (JsonObject)message.body();
            String _uname = request.getString("username");
            String _pass = request.getString("password");
            Database database = new Database();
            database.query(resultSet->{
                JsonObject object = new JsonObject();
                for(int i=0;i<resultSet.getNumRows();i++){
                    if(resultSet.getRows().get(i).getString("username").equals(_uname)&&resultSet.getRows().get(i).getString("password").equals(_pass))
                    {
                        object.put("login","success");
                        break;
                    }
                    else
                        object.put("login","failed");
                }

                message.reply(object);
            });
        });
    }
}
