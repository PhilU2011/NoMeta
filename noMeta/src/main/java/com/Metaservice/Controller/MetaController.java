package com.Metaservice.Controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Metaservice.ModelInter.Root;
import com.Metaservice.Services.JsonMapper;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

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
		
		return rootObject.getRootElement().output();
	}
	
	
}
