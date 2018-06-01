package com.ray.gef.helloworld.model;

import java.util.ArrayList;
import java.util.List;

public class ContentsModel {
	  private List children = new ArrayList();

	public List getChildren() {
		return children;
	}

	public void addChild(Object child){
		children.add(child);
	}
	  
	public void removeChild(Object child){
		children.remove(child);
	}

}
