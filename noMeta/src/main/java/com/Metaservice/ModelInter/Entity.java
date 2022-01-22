package com.Metaservice.ModelInter;

import java.util.ArrayList;
import java.util.ListIterator;


public class Entity {

	private String name;
	private String nodeType;
	private int properties_size;
	private ArrayList<Property> properties;
	
	
	public Entity () {};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public int getProperties_size() {
		return properties_size;
	}
	public void setProperties_size(int properties_size) {
		this.properties_size = properties_size;
	}
	
	public ArrayList<Property> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}
	
	public String output () {
		String out="";
		out="Name: " + getName() + "; NodeType: " + getNodeType() + "; PropertySize: " + getProperties_size() + ";" + System.lineSeparator();
		
		ListIterator<Property> iter= getProperties().listIterator();
		
			while (iter.hasNext()) {
				Property prop = iter.next();
				out = out + "Property Name: " + prop.getName() + "; Property Type: " +  prop.getNodeType() + "; Children: " + 
					 prop.getAllChildren(prop)+ System.lineSeparator();
			}
			
		System.out.println(out);
		return out;
	}
	
}
