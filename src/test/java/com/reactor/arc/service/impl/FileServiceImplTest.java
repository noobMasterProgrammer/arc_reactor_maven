package com.reactor.arc.service.impl;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceImplTest {

	@Test
	public void initializeFromJsonTest() throws IOException {
		FileServiceImpl jsonServiceImpl = new FileServiceImpl();
		Object obj = jsonServiceImpl.initializeFromFile("src/main/java/resources", Map.class, "Sample.json");
		System.out.print(obj);
		assertNotNull(obj);
	}
	@Test
	public void testTest() throws IOException {
		FileServiceImpl jsonServiceImpl = new FileServiceImpl();
		Object obj = jsonServiceImpl.initializeFromFile("src/main/java/resou", Map.class, "Sample.json",new HashMap<>());
		System.out.print(obj);
		assertNotNull(obj);
	}

}
