package org.springframework.vertx;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.StringUtils;
import org.vertx.java.core.Vertx;


public class VertxNodeFactoryBean implements FactoryBean<Vertx> {
	
	private int port;
	
	private String address;
	
	private Vertx vertxNode;

	@Override
	public Vertx getObject() throws Exception {
		
		if (port != -1 && StringUtils.hasText(address)) {
			vertxNode = Vertx.newVertx(port, address);
		}
		else if (StringUtils.hasText(address)) {
			vertxNode = Vertx.newVertx(address);
		}
		else {
			vertxNode = Vertx.newVertx();
		}
		
		return vertxNode;
	}

	@Override
	public Class<?> getObjectType() {
		return Vertx.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
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
