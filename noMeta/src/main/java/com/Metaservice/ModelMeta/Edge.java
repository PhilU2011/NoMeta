package com.Metaservice.ModelMeta;

import java.util.ArrayList;

public class Edge extends Relationship {

	private String edName;
	private ArrayList<Attribute> edgeAttributes;
	private EntityMeta source;
	private EntityMeta target;
	
	public Edge () {}

	public String getEdName() {
		return edName;
	}

	public void setEdName(String edName) {
		this.edName = edName;
	}

	public ArrayList<Attribute> getEdgeAttributes() {
		return edgeAttributes;
	}

	public void setEdgeAttributes(ArrayList<Attribute> edgeAttributes) {
		this.edgeAttributes = edgeAttributes;
	}

	public EntityMeta getSource() {
		return source;
	}

	public void setSource(EntityMeta source) {
		this.source = source;
	}

	public EntityMeta getTarget() {
		return target;
	}

	public void setTarget(EntityMeta target) {
		this.target = target;
	};
	
	
	
}
