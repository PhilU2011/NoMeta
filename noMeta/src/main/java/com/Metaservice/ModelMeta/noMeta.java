package com.Metaservice.ModelMeta;

import java.util.ArrayList;

public class noMeta {

	private String noName;
	private ArrayList<EntityMeta> entities;
	private ArrayList <Relationship> relationships;
	
	public noMeta () {}

	public String getNoName() {
		return noName;
	}

	public void setNoName(String noName) {
		this.noName = noName;
	}

	public ArrayList<EntityMeta> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<EntityMeta> entities) {
		this.entities = entities;
	}

	public ArrayList<Relationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(ArrayList<Relationship> relationships) {
		this.relationships = relationships;
	};
	
	
	
	
}
