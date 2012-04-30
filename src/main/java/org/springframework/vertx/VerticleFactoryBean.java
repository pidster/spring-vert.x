package org.springframework.vertx;

import org.springframework.beans.factory.FactoryBean;
import org.vertx.java.deploy.Verticle;

public class VerticleFactoryBean implements FactoryBean<Verticle> {

	@Override
	public Verticle getObject() throws Exception {
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Verticle> getObjectType() {
		return Verticle.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
