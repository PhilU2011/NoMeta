package com.Metaservice.Services;

import java.util.ArrayList;
import java.util.ListIterator;

import com.Metaservice.ModelInter.Property;
import com.Metaservice.ModelInter.Root;


public class PropertyRek {

	private ArrayList<String> output = new ArrayList<String> ();
	
	public PropertyRek () {};
	
	public ArrayList<String> getAllChildren (Property pro) {
		String out="";
		
		if (pro.getChildren()==null) {
			out=" PropertyName: " + pro.getName() +"; PropteryType: " + pro.getNodeType() + "; Children: " + "null" + System.lineSeparator();
			output.add(out);
		} else {
			if (pro.getChildren().length==0) {
				out= " PropertyName: " + pro.getName() +"; PropteryType: " + pro.getNodeType() + "; Children: " + "leer" + System.lineSeparator();
				output.add(out);
			} else {
				for (int i=0; i<pro.getChildren().length; i++) {
					
					if (i!=0) {
						out="Children";
						output.add(out);
					} else {
						out=" PropertyName: " + pro.getName() +"; PropteryType: " + pro.getNodeType() + "; Children: " + pro.allChildren() + System.lineSeparator();
						output.add(out);
					}
						out= "Children Name: " + pro.getChildren()[i].getName() + "; Children PropertyType: " + pro.getChildren()[i].getNodeType() + System.lineSeparator();
						output.add(out);
					
					getAllChildren(pro.getChildren()[i]);
				}
			}
		}
		
		return output;
	}
	
	
	public String rekAlg(Root root) {
		
		ArrayList<Property> proList = root.getRootElement().getProperties();
		ListIterator<Property> iter = proList.listIterator();
		String out="Entity Name: " + root.getRootElement().getName()+ "; Entity Type: " + root.getRootElement().getNodeType() + 
				"; PropterySize: " + root.getRootElement().getProperties_size() + System.lineSeparator();
		
		ListIterator<String> iterString = output.listIterator();
		String outputRoot=""; 
		
		output.add(out);
		
		while (iter.hasNext()) {
			Property property = iter.next();
			getAllChildren(property);
			}
		
		for (int i=0; i<output.size(); i++) {
			outputRoot= outputRoot + output.get(i);
		}
		
		
		System.out.println();
		System.out.println(outputRoot);
		return outputRoot;
	
	}

	public ArrayList<String> getOutput() {
		return output;
	}

	public void setOutput(ArrayList<String> output) {
		this.output = output;
	}
	
	
}
