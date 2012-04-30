package org.springframework.vertx.config;

import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.vertx.VertxNodeFactoryBean;
import org.w3c.dom.Element;

public class VertxNodeParser extends AbstractSingleBeanDefinitionParser {
	
	private static final String VERTX_NODE_PORT = "port";

	private static final String VERTX_NODE_HOSTNAME = "hostname";

	@Override
	protected Class<?> getBeanClass(Element element) {
		return VertxNodeFactoryBean.class;
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

		String portValue = element.getAttribute(VERTX_NODE_PORT);
		if (StringUtils.hasText(portValue)) {
			builder.addPropertyValue(VERTX_NODE_PORT, portValue);
		}

		String hostnameValue = element.getAttribute(VERTX_NODE_HOSTNAME);
		if (StringUtils.hasText(hostnameValue)) {
			builder.addPropertyValue(VERTX_NODE_HOSTNAME, new TypedStringValue(hostnameValue));
		}
	}
}
