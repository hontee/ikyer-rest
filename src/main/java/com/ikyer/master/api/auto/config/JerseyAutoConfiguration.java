package com.ikyer.master.api.auto.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ikyer.master.api.rest.MenuRest;
import com.ikyer.master.api.rest.ProductRest;
import com.ikyer.master.api.rest.RecommendRest;
import com.ikyer.master.api.rest.TopicRest;
import com.ikyer.master.api.rest.UserRest;
import com.ikyer.master.api.rest.WebFetchRest;

@Configuration
public class JerseyAutoConfiguration extends ResourceConfig {
	
	/**
	 * 配置RESTful服务类
	 */
	public JerseyAutoConfiguration() {
		register(MenuRest.class);
		register(ProductRest.class);
		register(RecommendRest.class);
		register(TopicRest.class);
		register(UserRest.class);
		register(WebFetchRest.class);
	}
	
	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(),
				"/api/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
				JerseyAutoConfiguration.class.getName());
		return registration;
	}
	
}
