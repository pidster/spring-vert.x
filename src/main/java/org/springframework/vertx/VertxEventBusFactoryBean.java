package org.springframework.vertx;

import org.springframework.beans.factory.FactoryBean;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.eventbus.EventBus;


public class VertxEventBusFactoryBean implements FactoryBean<EventBus> {
	
	private Vertx vertxNode;

	@Override
	public EventBus getObject() throws Exception {
		return vertxNode.eventBus();
	}

	@Override
	public Class<?> getObjectType() {
		return Vertx.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public Vertx getVertxNode() {
		return vertxNode;
	}

	public void setVertxNode(Vertx vertxNode) {
		this.vertxNode = vertxNode;
	}

}
