package com.reactor.arc.service;

public interface Reflection {
	void setField(Class<?> className,Object object, String fieldName,Object fieldValue);
}
