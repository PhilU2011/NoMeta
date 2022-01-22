package com.Metaservice.ModelMeta;

import java.util.ArrayList;

public class Reference extends Relationship {

	private int lowerBound;
	private int upperBound;
	private ArrayList<EntityMeta> referenced;
	private boolean bidirectional;
	
	public Reference () {}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public ArrayList<EntityMeta> getReferenced() {
		return referenced;
	}

	public void setReferenced(ArrayList<EntityMeta> referenced) {
		this.referenced = referenced;
	}

	public boolean isBidirectional() {
		return bidirectional;
	}

	public void setBidirectional(boolean bidirectional) {
		this.bidirectional = bidirectional;
	};
	
	
	
}
