package org.springframework.vertx.config;

import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.vertx.VertxEventBusFactoryBean;
import org.w3c.dom.Element;

public class VertxEventBusParser extends AbstractSingleBeanDefinitionParser {
	
	private static final String VERTX_NODE = "node";

	@Override
	protected Class<?> getBeanClass(Element element) {
		return VertxEventBusFactoryBean.class;
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
		
		String nodeValue = element.getAttribute(VERTX_NODE);
		if (StringUtils.hasText(nodeValue)) {
			builder.addPropertyValue(VERTX_NODE, new RuntimeBeanReference(nodeValue));
		}
	}
}
