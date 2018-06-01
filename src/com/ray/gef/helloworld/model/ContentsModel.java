package com.ray.gef.helloworld.model;

import java.util.ArrayList;
import java.util.List;

public class ContentsModel extends AbstractModel{
	//定义下面的字符串用于标识该模型中结构（Children）改变
	public static String P_CHILDREN = "_children";
	
	private List children = new ArrayList();


	public void addChild(Object child){
		children.add(child);
		
		//添加子模型后通知EditPart
		firePropertyChange(P_CHILDREN,null,null);
	}

	public List getChildren(){
		return children;
	}

	public void removeChild(Object child){
		
		children.remove(child);
		
		//删除子模型后通知EditPart
		firePropertyChange(P_CHILDREN,null,null);
	}

}
