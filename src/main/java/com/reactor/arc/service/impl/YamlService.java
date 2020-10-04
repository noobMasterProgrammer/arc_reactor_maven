package com.reactor.arc.service.impl;

import static com.reactor.arc.constant.ArcReactorConstant.YAML;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactor.arc.service.FileService;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Qualifier(YAML)
public class YamlService extends FileService {

	@Autowired
	@Qualifier(YAML)
	private ObjectMapper mapper;
	
	@Override
	public Object initializeFromFile(String path, Class<?> className, String fileName) throws IOException {
		return mapper.readValue(getBufferedReader(path,fileName), className);
	}

}
