package org.springframework.vertx;

import org.springframework.beans.factory.FactoryBean;
import org.vertx.java.deploy.impl.VerticleManager;

public class VerticleManagerFactoryBean implements FactoryBean<VerticleManager> {

	@Override
	public VerticleManager getObject() throws Exception {
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return VerticleManager.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
