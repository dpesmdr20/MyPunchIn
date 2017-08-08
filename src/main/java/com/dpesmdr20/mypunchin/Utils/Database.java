package com.dpesmdr20.mypunchin.Utils;

import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;

import javax.swing.*;

/**
 * Created by dimanandhar on 8/8/17.
 */
public class Database {
    JDBCClient client;
    String sql = "SELECT * FROM login;";

    public Database() {


    }
    public void query(Handler<ResultSet> done){
        client = JDBCClient.createNonShared(ConfigProvider.getInstance().getVertx(), ConfigProvider.getInstance().getConfig().getJsonObject("databaseConfig"));
        executeQuery(client, sql, done);

    }
    public void executeQuery(JDBCClient client, String sql, Handler<ResultSet> done) {
        client.getConnection(conn -> {
            if (conn.failed()) {
                System.out.println(":::::Error Connection not established due to ::::: " + conn.cause());
                done.handle(null);
                throw new RuntimeException(conn.cause());
            } else {
                final SQLConnection connection = conn.result();
                connection.query(sql, rs -> {
                    connection.close(kill -> {
                                if (kill.failed())
                                    System.out.println(":::::Error [executeQuery] Connection could not be killed  :::::: " + kill.cause());
                            }
                    );
                    if (rs.failed()) {
                        System.out.println(":::::Error Query could not be executed due to ::::: " + rs.cause() + "\n" + sql);
                        done.handle(null);
                    } else {
                        done.handle(rs.result());
                    }
                });
            }
        });
    }
}
