package com.ray.gef.helloworld.part.editpart;


import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.ray.gef.helloworld.model.ContentsModel;
import com.ray.gef.helloworld.part.policy.CustomerXYLayoutEditPolicy;




public class ContentsEditorPart extends AbstractGraphicalEditPart {

	protected IFigure createFigure() {
		//给图形集设置一个透明图层（Layer）
		Layer figure = new Layer();
		figure.setLayoutManager(new XYLayout());
		return figure;
	}

	protected void createEditPolicies() {
		//安装Policy
		//参数一：指定 EditPolicy的角色，设置这个变量是因为：一个EditPart 可以安装很多 EditPolicy，如果他们的角色都相同，就是这个字符串参数相同，
		//那么只有最后安装的一个 policy 是有效的。
		installEditPolicy(EditPolicy.LAYOUT_ROLE,new CustomerXYLayoutEditPolicy());

	}
	
	protected List getModelChildren(){
		
		return ((ContentsModel)getModel()).getChildren();
	}
}
