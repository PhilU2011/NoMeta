package com.Metaservice.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/startAppOne/{name}" , produces="text/plain", method=RequestMethod.GET)
	@ResponseBody
	public String readJson (@PathVariable String name) throws StreamReadException, DatabindException, IOException {
		name= "src/main/Files/" + name + ".json";
		
		Root rootObject = new Root();
		rootObject = JsonMapper.readJsonAsValue(name, Root.class);
		PropertyRek rek = new PropertyRek();
		
		ArrayList<String> list = rek.rekAlg(rootObject);
		String out="";
		ListIterator<String> iter = list.listIterator();
		
			while (iter.hasNext()) {
				String strOutput = iter.next();
				out = out + strOutput;
			}
		
		
		return out;
	}
	
	@RequestMapping(value="/startAppTwo/{name}/{text}", produces="application/json")
	@ResponseBody
	public String readAndWriteJson (@PathVariable String [] name, @PathVariable boolean text) throws StreamReadException, DatabindException, IOException {
		String path = "src/main/Files/";
		String extension = ".json";
		String output="";
		String save= "fourthTest";
		
		for (int i=0; i<name.length; i++) {
			name[i]=path + name[i] + extension;
		}
		
		ArrayList<Root> rootList = JsonMapper.readSeveralJsonAsValue(name, Root.class, save, path);
		ListIterator<Root> iter = rootList.listIterator();
		
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>> ();
		
			if (!text) {
					while (iter.hasNext()) {
						Root root = iter.next();
						PropertyRek rek = new PropertyRek();
						ArrayList<String> listString = rek.rekAlg(root);
						
						list.add(listString);
					}
				
					for (int j=0; j<list.size(); j++) {
						for (int z=0; z<list.get(j).size();z++) {
							output= output + list.get(j).get(z);
						}
					}	
				}
			else {
				JsonNode nd = JsonMapper.ObjectToNode(rootList);
				output = JsonMapper.NodeToString(nd);
			}
		
		return output;
		
	}
	
	
	@RequestMapping(value="/startAppThree/{name}", produces="application/json")
	@ResponseBody
	
	public String readJsonArrayAndWrite (@PathVariable String name) throws IOException {
		String filename = "src/main/Files/" + name + ".json";
		
		Root [] root = JsonMapper.readJsonArrayRootAsValue(filename);
		
		JsonMapper.ObjectToJson("fifthTest", root, "src/main/Files/");
		
		JsonNode nd = JsonMapper.ObjectToNode(root);
		String output= JsonMapper.NodeToString(nd);
		
		return output;
 		
	}
	
	
}
