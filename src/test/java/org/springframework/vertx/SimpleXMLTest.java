package org.springframework.vertx;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.http.HttpServer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/config/testConfig.xml"})
public class SimpleXMLTest {

	@Autowired
	private ApplicationContext context;
	
	@Test
	public void test() {
		Vertx vertx = context.getBean(Vertx.class);
		assertNotNull(vertx);
		
		EventBus eventBus = vertx.eventBus();
		assertNotNull(eventBus);
		
		HttpServer httpServer = context.getBean("vertxHttpServer", HttpServer.class);
		assertNotNull(httpServer);

		HttpServer webSocketServer = context.getBean("vertxWebSocketServer", HttpServer.class);
		assertNotNull(webSocketServer);

		try {
			Thread.sleep(30000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
