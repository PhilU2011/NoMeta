package com.Metaservice.Controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Metaservice.ModelInter.Root;
import com.Metaservice.Services.JsonMapper;
import com.Metaservice.Services.PropertyRek;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class MetaController {

	@RequestMapping("/start")
	@ResponseBody 
	public String startApp() {
		return "Start Application + Meta:";
		
	}
	
	@RequestMapping(value="/startAppOne/{name}")
	@ResponseBody
	public String readJson (@PathVariable String name) throws StreamReadException, DatabindException, IOException {
		name= "src/main/Files/" + name + ".json";
		
		Root rootObject = new Root();
		rootObject = JsonMapper.readJsonAsValue(name, Root.class);
		PropertyRek rek = new PropertyRek();
		
		return rek.rekAlg(rootObject);
	}
	
	@RequestMapping(value="/startAppTwo/{name}", produces="application/json")
	@ResponseBody
	public String readAndWriteJson (@PathVariable String name) throws StreamReadException, DatabindException, IOException {
		name= "src/main/Files/" + name + ".json";
		String output="";
		
		Root rootObject = new Root();
		rootObject = JsonMapper.readJsonAsValue(name, Root.class);
		
		JsonNode node = JsonMapper.ObjectToNode(rootObject);
		output= JsonMapper.NodeToString(node);
		
		System.out.println(output);
		return output;
		
	}
	
	
}
