package com.Metaservice.ModelMeta;

import java.util.ArrayList;

public class Embedded extends Relationship {

	private ArrayList<EntityMeta> embedded;
	
	public Embedded () {}

	public ArrayList<EntityMeta> getEmbedded() {
		return embedded;
	}

	public void setEmbedded(ArrayList<EntityMeta> embedded) {
		this.embedded = embedded;
	};
	
	
}
