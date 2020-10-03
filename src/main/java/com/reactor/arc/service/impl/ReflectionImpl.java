package com.reactor.arc.service.impl;

import java.lang.reflect.Field;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.reactor.arc.service.Reflection;

@Service
public class ReflectionImpl implements Reflection {

	@Override
	public void setField(Class<?> className, Object object, String fieldName, Object fieldValue) {
		Field field = ReflectionUtils.findField(className, fieldName);
		field.setAccessible(true);
		ReflectionUtils.setField(field, object, fieldValue);
	}

}
