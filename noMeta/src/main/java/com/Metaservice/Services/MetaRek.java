package com.Metaservice.Services;

import java.util.ArrayList;
import java.util.ListIterator;

import com.Metaservice.ModelMeta.Attribute;
import com.Metaservice.ModelMeta.EntityMeta;
import com.Metaservice.ModelMeta.NoMeta;

public class MetaRek {

	
	private ArrayList<String> listOutput = new ArrayList<String> ();
	
	public MetaRek() {};
	
	public ArrayList<String> getAllAttributes (Attribute attr, boolean isAttributeChildren ) {
		String out="";
		boolean checkAttributeChildren=isAttributeChildren;
		
		
		if (attr.getAttributes()==null) {
			if (!checkAttributeChildren) {
			out=" AttributeName: " + attr.getName() +"; AttributeType: " + attr.getType() + "; AttributeChildren: " + "null" + System.lineSeparator();
			listOutput.add(out);}
				else {	
				}
		} else {
			if (attr.getAttributes().length==0) {
				if (!checkAttributeChildren) {
				out= " AttributeName: " + attr.getName() +"; AttributeType: " + attr.getType() + "; AttributeChildren: " + "leer" + System.lineSeparator();
				listOutput.add(out);
				//System.out.println(out);
				}
				else {
				}
			} else {
				for (int i=0; i<attr.getAttributes().length; i++) {
					
					if (i==0 && !checkAttributeChildren) {
						out=" AttributeName: " + attr.getName() +"; AttributeType: " + attr.getType() + "; Children: " + attr.allAttributes() + System.lineSeparator();
						listOutput.add(out);
						//System.out.println(out);
					} 
					if (checkAttributeChildren){
						out="  Chidlren AttributeName: " + attr.getAttributes()[i].getName() + "; Children AttributeType: " + attr.getAttributes()[i].getType() + 
						"; Children Attributes: " + attr.getAttributes()[i].allAttributes() + System.lineSeparator();
						listOutput.add(out);
						//System.out.println(out);
					} else {
						out= "  Chidlren AttributeName: " + attr.getAttributes()[i].getName() + "; Children AttributeType: " + attr.getAttributes()[i].getType() + 
								"; Children Attributes: " + attr.getAttributes()[i].allAttributes() + System.lineSeparator();
						listOutput.add(out);
						//System.out.println(out);
					}
					getAllAttributes(attr.getAttributes()[i], true);
				}
			}
		}
		return listOutput;
	}
	
	public ArrayList<String> rekAlg(NoMeta meta){
	
		ArrayList<Attribute> attributes = new ArrayList<Attribute> ();
		ListIterator<Attribute> iter; 
		
		ArrayList<EntityMeta> entities = new ArrayList<EntityMeta>();
		String entityOut ="";	
		entities = meta.getEntities();
		
		String outputConsole="";
			
			for (int i=0; i<entities.size(); i++) {
				EntityMeta e = entities.get(i);
				entityOut= "Entity Name: " + e.getEnName() + "; Entity Type: " + e.getType() +System.lineSeparator();
				listOutput.add(entityOut);
				
				attributes=e.getAttributes();
				iter= attributes.listIterator();
				while (iter.hasNext()) {
					Attribute a = iter.next();
					getAllAttributes(a, false);
					}
			}
			
			for (int z=0; z<listOutput.size(); z++) {
				outputConsole=outputConsole+ listOutput.get(z);
			}
			System.out.println(outputConsole);
		
		return listOutput;
	}

	public ArrayList<String> getListAttributes() {
		return listOutput;
	}

	public void setListAttributes(ArrayList<String> listAttributes) {
		this.listOutput= listAttributes;
	}
	
	
}
