package com.Metaservice.ModelMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class Key {

	private ArrayList<Attribute> keyList;
	
	public Key () {
		
		keyList=new ArrayList<Attribute>();
	}

	public ArrayList<Attribute> getKey() {
		return keyList;
	}

	public void setKey(ArrayList<Attribute> keyList) {
		this.keyList = keyList;
	}
	
	
	public Map<String,Object> getFlatteredKeyPattern(EntityMeta en) {
		
		// Attribute [] > 0
		
		
		ListIterator<Attribute> iter = keyList.listIterator();
		Map<String, Object> hashMap = new HashMap<String,Object>();
		
		String name =en.getEnName();
		String mapKey=name;
		
		
		while (iter.hasNext()) {
		
			Attribute a = iter.next();
			Object mapValue = new Object();
			mapKey=mapKey+ "."+a.getName();
			
			mapValue = a.getType();
			hashMap.put(mapKey, mapValue);
			
			//children
					
		}
		
		return hashMap;
		
	}
	
	public String getKeyAsString() {
		
		//if ()
		
		return null;
	}
	
}
