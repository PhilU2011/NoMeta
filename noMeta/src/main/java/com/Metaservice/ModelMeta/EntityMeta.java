package com.Metaservice.ModelMeta;

import java.util.ArrayList;

public class EntityMeta {

	private String enName;
	private String type;
	private ArrayList<Attribute> attributes;
	private Key key;
	
	public EntityMeta () {}


	public String getEnName() {
		return enName;
	}


	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}


	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}

	public Key getKey() {
		return key;
	}


	public void setKey(Key key) {
		this.key = key;
	};
	
	
	
	
}
