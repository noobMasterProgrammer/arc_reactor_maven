package com.reactor.arc.service;

import static com.reactor.arc.constant.ArcReactorConstant.JSON;
import static com.reactor.arc.constant.ArcReactorConstant.YAML;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
public abstract class FileService {
	
	private String currentDir = System.getProperty("user.dir");
	protected ObjectMapper mapper = new ObjectMapper();
	
	public abstract Object initializeFromFile(String path,Class<?> className,String fileName) throws FileNotFoundException, IOException;
	public Object initializeFromFile(String path,Class<?> className,String fileName,Object defaultValue) {
		try {
			return initializeFromFile(path,className,fileName);
		} catch (IOException e) {
			return defaultValue;
		}
	}
	protected String getCurrentDirectory() {
		return currentDir;
	}
	protected BufferedReader getBufferedReader(String path,String fileName) throws FileNotFoundException {
		Path filePath = Paths.get(getCurrentDirectory().toString(), path, fileName);
		return new BufferedReader(new FileReader(filePath.toString()));
	}
	
	@Bean(JSON)
	private ObjectMapper getJsonMapper() {
		return new ObjectMapper(new JsonFactory());
	}
	@Bean(YAML)
	private ObjectMapper getYamlMapper() {
		return new ObjectMapper(new YAMLFactory());
	}
}
