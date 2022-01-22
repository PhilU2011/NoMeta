package com.Metaservice.ModelMeta;

public class Attribute {

	private String name;
	private String type;
	private Attribute [] attributes;
	
	
	public Attribute () {}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Attribute[] getAttributes() {
		return attributes;
	}


	public void setAttributes(Attribute[] attributes) {
		this.attributes = attributes;
	};
	
	
}
