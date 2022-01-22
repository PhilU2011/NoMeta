package com.Metaservice.Services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonMapper {


private static ObjectMapper mapper= getMapper();
	
public JsonMapper () {
	this.mapper= getMapper();
}

	public static ObjectMapper getMapper () {
		ObjectMapper defaultMapper = new ObjectMapper();
		defaultMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		defaultMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		return defaultMapper;
	}
	

	// read one JSON File as Value
	
	public static <T> T readJsonAsValue (String filename, Class<T> cl) throws StreamReadException, DatabindException, IOException {
		T object = mapper.readValue(new File (filename), cl);
		return object;
	}
	
	
	// read one JSON File as Tree
	
	
	
	
}
	
	
