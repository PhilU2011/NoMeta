package com.Metaservice.ModelInter;

public class Property {

	private String name;
	private String nodeType;
	private Property [] children;
	
	public Property () {};	
	
	
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
	public Property[] getChildren() {
		return children;
	}
	public void setChildren(Property[] children) {
		this.children = children;
	}
	
	
	public String getAllChildren (Property property) {
		String output="";
		
		if (property.getChildren()==null) {
			output= "null";
		} else {
			if (property.getChildren().length==0) {
			output="leer";
			} else {
				for (int i=0; i<property.getChildren().length; i++) {
					output ="Name: " + property.getName() + "; NodeType: " + property.getNodeType() + "; Children: Name:" + property.getChildren()[i].getName() +
							"; NodeType: " + property.getChildren()[i].getNodeType() + System.lineSeparator();  
					getAllChildren(property.getChildren()[i]);
				}
		
			}
		}
		
		return output;
	}
}
