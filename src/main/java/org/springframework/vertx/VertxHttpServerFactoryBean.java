package org.springframework.vertx;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.Lifecycle;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;

public class VertxHttpServerFactoryBean  implements FactoryBean<HttpServer>, Lifecycle {
	
	private Vertx node;
	
	private int port;
	
	private String address;

	// private Handler<HttpServerRequest> handler;
	
	private HttpServer httpServer;

	private boolean running;

	@Override
	public HttpServer getObject() throws Exception {
		
		HttpServer httpServer = node.createHttpServer();
		// this.httpServer = httpServer.requestHandler(handler);
		
		System.out.println("Getting HttpServer");
		
		this.httpServer = httpServer.requestHandler(new HttpServerRequestHandler() {
			@Override
			public void handle(HttpServerRequest req) {
				
				System.out.println("Handling request: " + req.path);

				String message = "Hello World";
				
				req.response.statusCode = 200;
				req.response.putHeader("Content-Type", "text/plain");
				req.response.putHeader("Content-Length", message.length());
				req.response.write(message);
				req.response.end();
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
