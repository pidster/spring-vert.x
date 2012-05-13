package org.springframework.vertx.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class VertxNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("node", new VertxNodeParser());
		registerBeanDefinitionParser("event-bus", new VertxEventBusParser());
		registerBeanDefinitionParser("http-server", new VertxHttpServerParser());
		registerBeanDefinitionParser("websocket-server", new VertxWebSocketServerParser());

//		registerBeanDefinitionParser("verticle-manager", new VerticleManagerParser());
//		registerBeanDefinitionParser("verticle", new VerticleParser());
	}

}
