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
import com.Metaservice.ModelMeta.NoMeta;
import com.Metaservice.Services.JsonMapper;
import com.Metaservice.Services.MetaRek;
import com.Metaservice.Services.PropertyRek;
import com.Metaservice.Services.Transformations;
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

	@RequestMapping(value="/startAppFour/{name}/{text}", produces="application/json")
	@ResponseBody
	
	public String readNoMetaEntity(@PathVariable String name, @PathVariable boolean text) throws IOException {
		
		String filename = "src/main/Files/" + name + ".json";
		NoMeta [] noMeta = JsonMapper.readJsonArrayMetaAsValue(filename);
		String out="";
		
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		if (text==true) {
			JsonNode nd = JsonMapper.ObjectToNode(noMeta);
			out = JsonMapper.NodeToString(nd);
		} else {
			
			if (!text) {
				for (int j=0; j<noMeta.length; j++) {	
					MetaRek rek = new MetaRek();
					ArrayList<String> listString = rek.rekAlg(noMeta[j]);
					
					list.add(listString);
				}
			
				for (int x=0; x<list.size(); x++) {
					for (int z=0; z<list.get(x).size();z++) {
						out= out + list.get(x).get(z);
					}
				}	
			}
		}	
		
		return out;
	}


	@RequestMapping(value="/startAppFive/{name}", produces="application/json")
	@ResponseBody
	
	public String transformInterToNoMeta(@PathVariable String [] name) throws IOException {
		
		String path = "src/main/Files/";
		String extension = ".json";
		String output="";
		String save= "sixthTest";
		
		// ich lese mehere JSON Files ein
		
		for (int i=0; i<name.length; i++) {
			name[i]=path + name[i] + extension;
		}
		
		// ich mache ein JSON Array File daraus und speichere es
		// ich parse das JSON Arary File in Root Objekte
		
		ArrayList<Root> rootList = JsonMapper.readSeveralJsonAsValue(name, Root.class, save, path);		
	
		Transformations trans = new Transformations();
		
		Root [] input = new Root[rootList.size()];
		
				for (int i=0; i<rootList.size(); i++) {
					input[i]=rootList.get(i);
				}
		
		// Ich Transformiere Root Objekte in NoMeta Objekt
		
				trans.setNoMetaName("Dokument");
				trans.setRootsInput(input);
				trans.transEntityInEntityMeta();
				NoMeta meta = trans.getNoMetaOutput();
				
				//trans.getAttributeList();
		// Ich schreibe das NoMeta Objekt
				
				JsonNode nd = JsonMapper.ObjectToNode(meta);
				output = JsonMapper.NodeToString(nd);
				
				return output;
	}
	
	
	
}
