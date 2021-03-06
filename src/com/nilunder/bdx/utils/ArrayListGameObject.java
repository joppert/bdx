package com.nilunder.bdx.utils;

import java.util.HashMap;

import com.nilunder.bdx.GameObject;

public class ArrayListGameObject extends ArrayListNamed<GameObject> {
	
	public GameObject getByProperty(String propName){
		for (GameObject g : this) {
			if (g.props.containsKey(propName)) {
				return g;
			}
		}
		return null;
	}
	
	public GameObject getByComponent(String compName){
		for (GameObject g : this) {
			if (g.components.get(compName) != null) {
				return g;
			}
		}
		return null;
	}
	
	public ArrayListGameObject getObjectsByProperty(String propName) {
		ArrayListGameObject l = new ArrayListGameObject();
		for (GameObject g : this) {
			if (g.props.containsKey(propName))
				l.add(g);
		}
		return l;
	}
	
	public ArrayListGameObject getObjectsByComponent(String compName) {
		ArrayListGameObject l = new ArrayListGameObject();
		for (GameObject g : this) {
			if (g.components.get(compName) != null)
				l.add(g);
		}
		return l;
	}
	
	public ArrayListGameObject group(String groupName){
		ArrayListGameObject l = new ArrayListGameObject();
		for (GameObject g : this){
			if (g.groups.contains(groupName)){
				l.add(g);
			}
		}
		return l;
	}
	
	public HashMap<String, ArrayListGameObject> groups(){
		HashMap<String, ArrayListGameObject> m = new HashMap<String, ArrayListGameObject>();
		for (GameObject g : this){
			for (String groupName : g.groups){
				if (!m.containsKey(groupName)){
					m.put(groupName, group(groupName));
				}
			}
		}
		return m;
	}
	
}
