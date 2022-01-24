package com.Metaservice.Services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
	
	
	// read several JSON Files as Value and save in one JSON Array file
	
	public static <T> ArrayList<T> readSeveralJsonAsValue (String [] filename, Class<T> cl, String saveFile, String savePath) throws StreamReadException, DatabindException, IOException {
		
		ArrayList<T> listObjects = new ArrayList<T> ();
		
		for (int i=0; i<filename.length; i++) {
			T object = mapper.readValue(new File (filename[i]), cl);
			listObjects.add(object);
		}
		
		JsonMapper.ObjectToJson(saveFile, listObjects, savePath);
		
		return listObjects;
	}

	// read one JSON Array File	as Value
	
	// read one JSON File as Tree
	
	public static JsonNode readJsonAsNode (String filename) throws IOException {
		JsonNode node = mapper.readTree(new File (filename));
		
		return node;
		
	}
	
	
	// read one JSON Array as Tree
	
	// read several JSON Files as Tree and transform to Object ArrayList
	
	
	// read Node zu Object
	
	public static <T> T NodeToObject (JsonNode node, Class<T> cl) throws JsonProcessingException, IllegalArgumentException {
		T object = mapper.treeToValue(node, cl);
		return object;
	}
	
	// read Object zu Node
	
	public static JsonNode ObjectToNode (Object ob) {
		return mapper.valueToTree(ob);
	}
	
	
	// write String from Node
	
	public static String NodeToString (JsonNode node) throws JsonProcessingException {
		ObjectWriter writer = mapper.writer();
		String output = writer.withDefaultPrettyPrinter().writeValueAsString(node);
		
		return output;
	}
	
	//write Json File from Object to JSON
	
	public static void ObjectToJson (String filename, Object value, String path) throws StreamWriteException, DatabindException, IOException {
		String ending= ".json";
		filename=path+filename+ending;
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), value);
	}
	
	
	//write Json Array File from Objects to JSON
	
}
	
	
