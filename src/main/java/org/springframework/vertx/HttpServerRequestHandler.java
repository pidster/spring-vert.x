package org.springframework.vertx;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;

public interface HttpServerRequestHandler extends Handler<HttpServerRequest> {

}
