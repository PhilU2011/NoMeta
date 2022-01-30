package com.Metaservice.Services;

import java.util.ArrayList;

import com.Metaservice.ModelInter.Entity;
import com.Metaservice.ModelInter.Property;
import com.Metaservice.ModelInter.Root;
import com.Metaservice.ModelMeta.Attribute;
import com.Metaservice.ModelMeta.EntityMeta;
import com.Metaservice.ModelMeta.NoMeta;

public class Transformations {

	private NoMeta noMetaOutput;
	private NoMeta noMetaInput;
	private Root [] rootsInput;
	private Root [] rootsOutput;
	
	
	public Transformations () {
		noMetaOutput = new NoMeta();
		noMetaInput = new NoMeta();
		rootsInput = null;
		rootsOutput = null;
	}
	
	
	// set NoMeta name
	
	public void setNoMetaName (String name) {
		noMetaOutput.setNoName(name);
	}
	
	//Transform Entity in EntityMeta
	
	public void transEntityInEntityMeta () {
		ArrayList<Entity> entList = new ArrayList<Entity> ();
		ArrayList<Property> propList = new ArrayList<Property> ();
		ArrayList<Attribute> attrList = new ArrayList<Attribute>();
		ArrayList<EntityMeta> metaList = new ArrayList<EntityMeta> ();
		
		for (int i=0; i<rootsInput.length; i++) {
			Entity e = rootsInput[i].getRootElement();
			entList.add(e);
		}
		
		
		
		for (int a=0; a<entList.size(); a++) {
			
			//Entity
			Entity enRoot = entList.get(a);
			EntityMeta enMeta = new EntityMeta();
			
			enMeta.setEnName(enRoot.getName());
			enMeta.setType(enRoot.getNodeType());
			
			//Attributes
			propList = enRoot.getProperties();			
			attrList = transformPropInAttr(propList);
			enMeta.setAttributes(attrList);
			attributeList=null;
			//Key
			
			
			//Relationship
			
			
			metaList.add(enMeta);
		}
		
		noMetaOutput.setEntities(metaList);
	}
	
	//Transform EntityMeta in Entity
	
	
	
	
	//Transform Property in Attribute
	
	ArrayList<Attribute> attributeList = new ArrayList<Attribute>();
	
	public ArrayList<Attribute> transformPropInAttr(ArrayList<Property> list) {
	
		
		
		for (int i=0; i<list.size(); i++) {
			Property p = list.get(i);
			Attribute a = new Attribute();
			
			if ((p.getChildren()== null) ||(p.getChildren().length==0)) {
				
				a.setName(p.getName());
				a.setType(p.getNodeType());
				Attribute [] arr = null;
				if (p.getChildren()==null) {
					arr = null;	
				}  else {
					arr= new Attribute [0];
				}
				
				a.setAttributes(arr);
				attributeList.add(a);
				
				//System.out.println("Eins: " + a.getName());
				
			} else {
				
				//attr = new Attribute[p.getChildren().length];
				//Attribute a = new Attribute();
				a.setName(p.getName());
				a.setType(p.getNodeType());
				Attribute [] arr = change(p.getChildren(),true, new Attribute ());
				a.setAttributes(arr);
				attributeList.add(a);
				
				//System.out.println("Zwei: " + a.getName());
				
				
				// ohne das Stück hier
				// ArrayList<Property> listProperty = new ArrayList<Property> ();
				// for (int z=0; z<p.getChildren().length; z++) {
				//	listProperty.add(p.getChildren()[z]);
				//}
				
				//transformPropInAttr(listProperty);
			}
		}
		
		return attributeList;
	}
	
	
	// Hilf Property [] in Attribute []
	
	
	public Attribute [] change (Property [] prop, boolean isChildren, Attribute newAttribute) {
	
		Attribute [] attr = new Attribute [prop.length];
		Attribute ex = new Attribute ();
		
		int z=0;
		for (int j=0; j<prop.length; j++ ) {
			Property p = prop[j];
			System.out.println(p.getName() + j);
			if (isChildren) {
				newAttribute.setName(p.getName());
				newAttribute.setType(p.getNodeType());
				
				if (p.getChildren().length==0 || p.getChildren()== null) {
					if (p.getChildren()==null) {
					newAttribute.setAttributes(null);
					
					ex=newAttribute;
					attr[z]=ex;
					newAttribute=new Attribute();
					System.out.println( j + "Weg eins " + attr[z].getName() + " " +attr[z].getType()  + " " + attr[z].allAttributes());
					z=z+1;
					} else {
						
					newAttribute.setAttributes(new Attribute[0]);
						
					ex=newAttribute;
					attr[z]=ex;
					newAttribute=new Attribute();
					System.out.println(j + "Weg zwei "  + attr[z].getName() + " " +attr[z].getType()  + " " + attr[z].allAttributes());
					z=z+1;
					}
				} else {
					Attribute b = new Attribute ();
					Attribute  [] arr2 = change(p.getChildren(), true,b);
					newAttribute.setAttributes(arr2);
					
					ex=newAttribute;
					attr[z]=ex;
					newAttribute = new Attribute();
					System.out.println(j + "Weg drei " + attr[z].getName() + " " +attr[z].getType()  + " " + attr[z].allAttributes());
					z=z+1;
				}
			}
		}
		
		//for (int i=0; i<attr.length; i++) {
		//System.out.println(attr[i].getName()+ " " + attr[i].getType() + " " + attr[i].allAttributes());
		//}
		
		
		//if (prop==null) {
			//		attr = null;
			//} else {
			//if (prop.length==0) {
			//attr= new Attribute[prop.length];
			//} else {
		
			//for (int j=0; j<prop.length; j++) {
			//Property p = prop[j];
			//Attribute a = new Attribute();
			//if (p.getChildren()==null) {
			//	if (!isChildren) {
			//		a.setName(p.getName());
			//		a.setType(p.getNodeType());
			//		a.setAttributes(null);
			//		attr[j]=a;
			//	} else {
			//		Attribute [] x = a.getAttributes();
			//		Attribute b = new Attribute();
			//		b.setName(null);
			//		b.setType(null);
			//		
			//		change(p.getChildren(), true);
			//	}
			//if (p.getChildren().length==0) {
			//	if (!isChildren) {
			//		a.setName(p.getName());
			//		a.setType(p.getNodeType());				
			//		a.setAttributes(new Attribute [p.getChildren().length]);
			//		attr[j]=a;
			//	}
			//} 
			//else {
			//	if (!isChildren) {
			//		change(p.getChildren(), false);
			//		}
			//	else {change(p.getChildren(), true);
			//		}
			//	}
			//}
			//}
	
			//}
		
		System.out.println("Ende");
		for (int i=0; i<attr.length; i++) {
			System.out.println(attr[i].getName()+ " " + attr[i].getType() + " " + attr[i].allAttributes());
			}
				
		return attr;
	}
	
	
	
	//Transform Attribute in Property	
	
	
	
	
	
	public NoMeta getNoMetaOutput() {
		return noMetaOutput;
	}



	public void setNoMetaOutput(NoMeta noMetaOutput) {
		this.noMetaOutput = noMetaOutput;
	}



	public NoMeta getNoMetaInput() {
		return noMetaInput;
	}



	public void setNoMetaInput(NoMeta noMetaInput) {
		this.noMetaInput = noMetaInput;
	}



	public Root[] getRootsInput() {
		return rootsInput;
	}



	public void setRootsInput(Root[] rootsInput) {
		this.rootsInput = rootsInput;
	}



	public Root[] getRootsOutput() {
		return rootsOutput;
	}



	public void setRootsOutput(Root[] rootsOutput) {
		this.rootsOutput = rootsOutput;
	}
	
	
	public void getAttributeList() {
		for (int i=0; i<attributeList.size(); i++) {
			Attribute a = attributeList.get(i);
				System.out.println(a.getName() + " " + a.getType() + a.allAttributes());
			}
		}
	
}
