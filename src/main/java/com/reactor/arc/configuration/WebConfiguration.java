package com.reactor.arc.configuration;

import static com.reactor.arc.constant.ArcReactorConstant.CUSTOMRESTTEMPLATE;

import javax.net.ssl.SSLContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.reactor.arc.service.component.CustomRestTemplate;
import com.reactor.arc.service.component.CustomRestTemplateUtils;

@Configuration
public class WebConfiguration {
	
	CustomRestTemplateUtils customRestTemplateUtils;
	SSLContext cloudContext;
	
	@Bean(CUSTOMRESTTEMPLATE)
	public RestTemplate getCustomRestTemplate() {
		return new CustomRestTemplate(customRestTemplateUtils,cloudContext).getCustomRestTemplate();
	}

}
