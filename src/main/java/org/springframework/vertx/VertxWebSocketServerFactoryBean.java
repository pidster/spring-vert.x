package org.springframework.vertx;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.Lifecycle;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.ServerWebSocket;

public class VertxWebSocketServerFactoryBean  implements FactoryBean<HttpServer>, Lifecycle {
	
	private Vertx node;
	
	private int port;
	
	private String address;

	private HttpServer httpServer;

	private boolean running;

	@Override
	public HttpServer getObject() throws Exception {
		
		HttpServer httpServer = node.createHttpServer();
		// this.httpServer = httpServer.requestHandler(handler);
		
		System.out.println("Getting WebSocket HttpServer");

		this.httpServer = httpServer.websocketHandler(new WebSocketServerRequestHandler() {
			@Override
			public void handle(ServerWebSocket socket) {
				System.out.println("WebSocket event");
			}
		});
		
		this.httpServer.listen(port, address);

		System.out.println("Listening on: " + address + ":" + port);

		return httpServer;
	}

	@Override
	public Class<?> getObjectType() {
		return HttpServer.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public void start() {
		this.running = true;
	}

	@Override
	public void stop() {
		httpServer.close();
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	public Vertx getNode() {
		return node;
	}

	public void setNode(Vertx node) {
		this.node = node;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
