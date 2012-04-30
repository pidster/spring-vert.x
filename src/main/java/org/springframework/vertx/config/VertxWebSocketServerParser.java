package org.springframework.vertx.config;

import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.vertx.VertxWebSocketServerFactoryBean;
import org.w3c.dom.Element;

public class VertxWebSocketServerParser extends AbstractSingleBeanDefinitionParser {

	private static final String VERTX_NODE = "node";

	private static final String HTTP_SERVER_PORT = "port";

	private static final String HTTP_SERVER_ADDRESS = "address";
	
	@Override
	protected Class<?> getBeanClass(Element element) {
		return VertxWebSocketServerFactoryBean.class;
	}

	@Override
	protected boolean shouldGenerateId() {
		return false;
	}

	@Override
	protected boolean shouldGenerateIdAsFallback() {
		return true;
	}

	@Override
	protected void doParse(Element element, ParserContext parserContext,
			BeanDefinitionBuilder builder) {
		
		String portValue = element.getAttribute(HTTP_SERVER_PORT);
		if (StringUtils.hasText(portValue)) {
			builder.addPropertyValue(HTTP_SERVER_PORT, portValue);
		}

		String hostnameValue = element.getAttribute(HTTP_SERVER_ADDRESS);
		if (StringUtils.hasText(hostnameValue)) {
			builder.addPropertyValue(HTTP_SERVER_ADDRESS, hostnameValue);
		}
		
		String nodeValue = element.getAttribute(VERTX_NODE);
		if (StringUtils.hasText(nodeValue)) {
			builder.addPropertyValue(VERTX_NODE, new RuntimeBeanReference(nodeValue));
		}
	}
}
