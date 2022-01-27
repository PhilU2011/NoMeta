package com.Metaservice.ModelMeta;

public class Key {

	private Attribute [] key;
	
	public Key () {}

	public Attribute[] getKey() {
		return key;
	}

	public void setKey(Attribute[] key) {
		this.key = key;
	}
	
	public String getKeyAsString() {
		String output="";
		
		for (int i=0; i<key.length; i++) {
			if (i==key.length-1) {
				output= output + key[i].getName();
			} else {
				output= output + key[i].getName()+":";
			}
		}
		return output;
	}
	
}
