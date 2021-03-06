package cn.rongcapital.mc2.me.gateway;

import java.util.Collections;

import org.apache.ignite.IgniteSpringBean;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.rongcapital.mc2.me.commons.api.ApiMessageReader;
import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteNodeType;

@Configuration
public class Config {

	@Value("${me.gateway.service.ignite.name}")
	private String name;

	@Value("${me.gateway.service.ignite.addresses}")
	private String[] addresses;

	@Bean
	public ApiMessageReader apiMessageReader() {
		return new ApiMessageReader();
	}

	@Bean
	public IgniteSpringBean igniteSpringBean() {
		IgniteConfiguration configuration = new IgniteConfiguration();
		configuration.setClientMode(true);
		configuration.setIgniteInstanceName(name);
		configuration.setPeerClassLoadingEnabled(true);
		configuration.setUserAttributes(Collections.singletonMap(IgniteNodeType.GATEWAY_NODE.name(), true));
		IgniteSpringBean bean = new IgniteSpringBean();
		bean.setConfiguration(configuration);
		return bean;
	}

}
