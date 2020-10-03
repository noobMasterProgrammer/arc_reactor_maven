package com.reactor.arc.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactor.arc.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	private String currentDir = System.getProperty("user.dir");
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Object initializeFromFile(String path, Class<?> className, String fileName) throws IOException {
		Path currentPath = Paths.get(currentDir);
		Path filePath = Paths.get(currentPath.toString(), path, fileName);
		BufferedReader bufferReader = new BufferedReader(new FileReader(filePath.toString()));
		return mapper.readValue(bufferReader, className);
	}

	@Override
	public Object initializeFromFile(String path, Class<?> className, String fileName, Object defaultValue) {
		try {
			return initializeFromFile(path,className,fileName);
		} catch (IOException e) {
			return defaultValue;
		}
	}

}
