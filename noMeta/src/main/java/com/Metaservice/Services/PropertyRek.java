package com.Metaservice.Services;

import java.util.ArrayList;
import java.util.ListIterator;

import com.Metaservice.ModelInter.Property;
import com.Metaservice.ModelInter.Root;


public class PropertyRek {

	private ArrayList<String> output = new ArrayList<String> ();
	
	public PropertyRek () {};
	
	public ArrayList<String> getAllChildren (Property pro, boolean isChildren) {
		String out="";
		boolean checkChildren = isChildren;
		
		if (pro.getChildren()==null) {
			if (!isChildren) {
			out=" PropertyName: " + pro.getName() +"; PropteryType: " + pro.getNodeType() + "; Children: " + "null" + System.lineSeparator();
			output.add(out);}
				else {	
				}
		} else {
			if (pro.getChildren().length==0) {
				if (!isChildren) {
				out= " PropertyName: " + pro.getName() +"; PropteryType: " + pro.getNodeType() + "; Children: " + "leer" + System.lineSeparator();
				output.add(out);}
				else {
				}
			} else {
				for (int i=0; i<pro.getChildren().length; i++) {
					
					if (i==0 && !checkChildren) {
						out=" PropertyName: " + pro.getName() +"; PropteryType: " + pro.getNodeType() + "; Children: " + pro.allChildren() + System.lineSeparator();
						output.add(out);
					} 
					if (checkChildren){
						out="  Children Name: " + pro.getChildren()[i].getName() + "; Children PropertyType: " + pro.getChildren()[i].getNodeType() + 
						"; Children: " + pro.getChildren()[i].allChildren() + System.lineSeparator();
						output.add(out);
					} else {
						out= "  Children Name: " + pro.getChildren()[i].getName() + "; Children PropertyType: " + pro.getChildren()[i].getNodeType() + 
								"; Children: " + pro.getChildren()[i].allChildren() + System.lineSeparator();
						output.add(out);
					}
					getAllChildren(pro.getChildren()[i], true);
					
				}
			}
		}
		
		return output;
	}
	
	
	public ArrayList<String> rekAlg(Root root) {
		
		ArrayList<Property> proList = root.getRootElement().getProperties();
		ListIterator<Property> iter = proList.listIterator();
		
		String out="Entity Name: " + root.getRootElement().getName()+ "; Entity Type: " + root.getRootElement().getNodeType() + 
				"; PropterySize: " + root.getRootElement().getProperties_size() + System.lineSeparator();
		
		String outputRoot=""; 
		
		output.add(out);
		
		while (iter.hasNext()) {
			Property property = iter.next();
			getAllChildren(property,false);
			}
		
		for (int i=0; i<output.size(); i++) {
			outputRoot= outputRoot + output.get(i);
		}
		
		System.out.println(outputRoot);
		return output;
	
	}

	public ArrayList<String> getOutput() {
		return output;
	}

	public void setOutput(ArrayList<String> output) {
		this.output = output;
	}
	
	
}
