package org.springframework.vertx;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.ServerWebSocket;

public interface WebSocketServerRequestHandler extends Handler<ServerWebSocket> {

}
