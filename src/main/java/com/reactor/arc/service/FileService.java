package com.reactor.arc.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
	Object initializeFromFile(String path,Class<?> className,String fileName) throws FileNotFoundException, IOException;
	Object initializeFromFile(String path,Class<?> className,String fileName,Object defaultValue);
}
